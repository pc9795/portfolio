package com.prashantchaubey.caches;

import com.prashantchaubey.entities.Comment;
import com.prashantchaubey.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CommentCache {
  private CommentRepository commentRepository;

  @Autowired
  public CommentCache(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  public Page<Comment> findAllByBlogPostId(Long blogPostId, Pageable pageable) {
    return commentRepository.findAllByBlogPostIdOrderByCreatedAtDesc(blogPostId, pageable);
  }

  public Comment save(Comment comment) {
    return commentRepository.save(comment);
  }

  public Optional<Comment> findById(Long id) {
    return commentRepository.findById(id);
  }

  public void updateMessage(Long id, String message) {
    commentRepository.updateMessage(id, message);
  }

  public void incrementUpVote(Long id) {
    commentRepository.incrementUpVote(id);
  }

  public void decrementUpVote(Long id) {
    commentRepository.decrementUpVote(id);
  }

  public void incrementDownVote(Long id) {
    commentRepository.incrementDownVote(id);
  }

  public void decrementDownVote(Long id) {
    commentRepository.decrementDownVote(id);
  }

  public void delete(Comment comment) {
    commentRepository.delete(comment);
  }
}
