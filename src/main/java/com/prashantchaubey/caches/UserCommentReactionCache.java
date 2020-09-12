package com.prashantchaubey.caches;

import com.prashantchaubey.entities.UserCommentReaction;
import com.prashantchaubey.entities.UserCommentReactionId;
import com.prashantchaubey.repositories.UserCommentReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
public class UserCommentReactionCache {
  private final UserCommentReactionRepository userCommentReactionRepository;

  @Autowired
  public UserCommentReactionCache(UserCommentReactionRepository userCommentReactionRepository) {
    this.userCommentReactionRepository = userCommentReactionRepository;
  }

  public Optional<UserCommentReaction> findById(UserCommentReactionId id) {
    return userCommentReactionRepository.findById(id);
  }

  public void save(UserCommentReaction userCommentReaction) {
    userCommentReactionRepository.save(userCommentReaction);
  }

  public void delete(UserCommentReaction userCommentReaction) {
    userCommentReactionRepository.delete(userCommentReaction);
  }

  public Set<UserCommentReaction> findByUserAndBlogPost(Long userId, Long blogPostId) {
    return userCommentReactionRepository.findByIdUserIdAndCommentBlogPostId(userId, blogPostId);
  }
}
