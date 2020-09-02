package com.prashantchaubey.repositories;

import com.prashantchaubey.entities.UserCommentReaction;
import com.prashantchaubey.entities.UserCommentReactionId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserCommentReactionRepository
    extends JpaRepository<UserCommentReaction, UserCommentReactionId> {

  Set<UserCommentReaction> findByIdUserIdAndCommentBlogPostId(Long userId, Long blogPostId);
}
