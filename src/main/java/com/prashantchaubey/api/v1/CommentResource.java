package com.prashantchaubey.api.v1;

import com.prashantchaubey.caches.BlogPostCache;
import com.prashantchaubey.caches.CommentCache;
import com.prashantchaubey.caches.UserCache;
import com.prashantchaubey.caches.UserCommentReactionCache;
import com.prashantchaubey.config.UserPrincipal;
import com.prashantchaubey.dto.mappers.CommentMapper;
import com.prashantchaubey.dto.mappers.UserCommentReactionMapper;
import com.prashantchaubey.dto.requests.CommentCreateRequest;
import com.prashantchaubey.dto.requests.CommentEditRequest;
import com.prashantchaubey.dto.responses.CommentResponse;
import com.prashantchaubey.dto.responses.UserCommentReactionResponse;
import com.prashantchaubey.entities.Comment;
import com.prashantchaubey.entities.UserCommentReaction;
import com.prashantchaubey.entities.UserCommentReactionId;
import com.prashantchaubey.exceptions.BadDataException;
import com.prashantchaubey.exceptions.ResourceNotFoundException;
import com.prashantchaubey.exceptions.UnauthorizedAccessException;
import com.prashantchaubey.utils.Constants;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(Constants.Endpoint.COMMENTS_V1)
public class CommentResource {
  private final CommentMapper commentMapper;
  private final CommentCache commentCache;
  private final BlogPostCache blogPostCache;
  private final UserCache userCache;
  private final UserCommentReactionCache userCommentReactionCache;
  private final UserCommentReactionMapper userCommentReactionMapper;

  public CommentResource(
      CommentCache commentCache,
      CommentMapper commentMapper,
      BlogPostCache blogPostCache,
      UserCache userCache,
      UserCommentReactionCache userCommentReactionCache,
      UserCommentReactionMapper userCommentReactionMapper) {
    this.commentCache = commentCache;
    this.commentMapper = commentMapper;
    this.blogPostCache = blogPostCache;
    this.userCache = userCache;
    this.userCommentReactionCache = userCommentReactionCache;
    this.userCommentReactionMapper = userCommentReactionMapper;
  }

  @GetMapping
  public List<CommentResponse> getAll(
      @RequestParam("blog_post_id") Long blogPostId,
      Pageable pageable,
      @AuthenticationPrincipal UserPrincipal userPrincipal) {
    return commentCache.findAllByBlogPostId(blogPostId, pageable).stream()
        .map(comment -> commentMapper.toCommentResponse(comment, userPrincipal))
        .collect(Collectors.toList());
  }

  @GetMapping("/reactions")
  public Set<UserCommentReactionResponse> getAllReactions(
      @RequestParam("blog_post_id") Long blogPostId,
      @AuthenticationPrincipal UserPrincipal userPrincipal) {
    return userCommentReactionCache.findByUserAndBlogPost(userPrincipal.getId(), blogPostId)
        .stream()
        .map(userCommentReactionMapper::toUserCommentReactionResponse)
        .collect(Collectors.toSet());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CommentResponse create(
      @RequestBody @Valid CommentCreateRequest request,
      @AuthenticationPrincipal UserPrincipal userPrincipal) {
    if (!blogPostCache.existsById(request.getBlogPostId())) {
      throw new BadDataException(
          String.format("BlogPost with id [%s] doesn't exist", request.getBlogPostId()));
    }

    Comment comment =
        commentMapper.from(
            request,
            userCache.getOne(userPrincipal.getId()),
            blogPostCache.getOne(request.getBlogPostId()));

    // This line will currently try to load the user from database
    return commentMapper.toCommentResponse(commentCache.save(comment), userPrincipal);
  }

  @PutMapping("/{id}")
  public CommentResponse edit(
      @PathVariable("id") Long id,
      @Valid @RequestBody CommentEditRequest request,
      @AuthenticationPrincipal UserPrincipal userPrincipal) {
    Comment originalComment =
        commentCache
            .findById(id)
            .orElseThrow(
                () -> {
                  throw new ResourceNotFoundException(
                      String.format("Comment with id [%s] is not found", id));
                });

    if (!originalComment.getUser().getId().equals(userPrincipal.getId())) {
      throw new UnauthorizedAccessException("You can't edit another user's comment");
    }

    commentCache.updateMessage(id, request.getMessage());

    return commentMapper.toCommentResponse(originalComment, request.getMessage(), userPrincipal);
  }

  @PatchMapping("/{id}/up_vote")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Transactional
  public void upVote(
      @PathVariable("id") Long id, @AuthenticationPrincipal UserPrincipal userPrincipal) {
    Comment comment =
        commentCache
            .findById(id)
            .orElseThrow(
                () -> {
                  throw new ResourceNotFoundException(
                      String.format("Comment with id [%s] is not found", id));
                });

    UserCommentReactionId userCommentReactionId =
        UserCommentReactionId.builder().commentId(id).userId(userPrincipal.getId()).build();
    Optional<UserCommentReaction> maybeUserCommentReaction =
        userCommentReactionCache.findById(userCommentReactionId);
    if (maybeUserCommentReaction.isPresent()) {
      throw new BadDataException("User has already reacted to this comment");
    }

    commentCache.incrementUpVote(id);
    // Setting id will result in another Select statement by Hibernate
    userCommentReactionCache.save(
        UserCommentReaction.builder()
            .id(userCommentReactionId)
            .type(UserCommentReaction.Type.UP_VOTE)
            .comment(comment)
            .user(userCache.getOne(userPrincipal.getId()))
            .build());
  }

  @PatchMapping("/{id}/up_vote/remove")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Transactional
  public void removeUpVote(
      @PathVariable("id") Long id, @AuthenticationPrincipal UserPrincipal userPrincipal) {
    commentCache
        .findById(id)
        .orElseThrow(
            () -> {
              throw new ResourceNotFoundException(
                  String.format("Comment with id [%s] is not found", id));
            });

    UserCommentReactionId userCommentReactionId =
        UserCommentReactionId.builder().commentId(id).userId(userPrincipal.getId()).build();
    UserCommentReaction userCommentReaction =
        userCommentReactionCache
            .findById(userCommentReactionId)
            .orElseThrow(
                () -> {
                  throw new BadDataException("User has never up-voted this comment");
                });

    if (!userCommentReaction.getType().equals(UserCommentReaction.Type.UP_VOTE)) {
      throw new BadDataException("User has never up-voted this comment");
    }

    commentCache.decrementUpVote(id);
    userCommentReactionCache.delete(userCommentReaction);
  }

  @PatchMapping("/{id}/down_vote")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Transactional
  public void downVote(
      @PathVariable("id") Long id, @AuthenticationPrincipal UserPrincipal userPrincipal) {
    Comment comment =
        commentCache
            .findById(id)
            .orElseThrow(
                () -> {
                  throw new ResourceNotFoundException(
                      String.format("Comment with id [%s] is not found", id));
                });

    UserCommentReactionId userCommentReactionId =
        UserCommentReactionId.builder().commentId(id).userId(userPrincipal.getId()).build();
    Optional<UserCommentReaction> maybeUserCommentReaction =
        userCommentReactionCache.findById(userCommentReactionId);
    if (maybeUserCommentReaction.isPresent()) {
      throw new BadDataException("User has already reacted to this comment");
    }

    commentCache.incrementDownVote(id);
    // Setting id will result in another Select statement by Hibernate
    userCommentReactionCache.save(
        UserCommentReaction.builder()
            .id(userCommentReactionId)
            .type(UserCommentReaction.Type.DOWN_VOTE)
            .comment(comment)
            .user(userCache.getOne(userPrincipal.getId()))
            .build());
  }

  @PatchMapping("/{id}/down_vote/remove")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Transactional
  public void removeDownVote(
      @PathVariable("id") Long id, @AuthenticationPrincipal UserPrincipal userPrincipal) {
    commentCache
        .findById(id)
        .orElseThrow(
            () -> {
              throw new ResourceNotFoundException(
                  String.format("Comment with id [%s] is not found", id));
            });

    UserCommentReactionId userCommentReactionId =
        UserCommentReactionId.builder().commentId(id).userId(userPrincipal.getId()).build();
    UserCommentReaction userCommentReaction =
        userCommentReactionCache
            .findById(userCommentReactionId)
            .orElseThrow(
                () -> {
                  throw new BadDataException("User has never down-voted this comment");
                });

    if (!userCommentReaction.getType().equals(UserCommentReaction.Type.DOWN_VOTE)) {
      throw new BadDataException("User has never down-voted this comment");
    }

    commentCache.decrementDownVote(id);
    userCommentReactionCache.delete(userCommentReaction);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(
      @PathVariable("id") Long id, @AuthenticationPrincipal UserPrincipal userPrincipal) {
    Comment comment =
        commentCache
            .findById(id)
            .orElseThrow(
                () -> {
                  throw new ResourceNotFoundException(
                      String.format("Comment with id [%s] is not found", id));
                });

    if (!comment.getUser().getId().equals(userPrincipal.getId())) {
      throw new UnauthorizedAccessException("You can't delete another user's comment");
    }
    commentCache.delete(comment);
  }
}
