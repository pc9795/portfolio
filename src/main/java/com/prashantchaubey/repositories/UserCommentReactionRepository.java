package com.prashantchaubey.repositories;

import com.prashantchaubey.entities.UserCommentReaction;
import com.prashantchaubey.entities.UserCommentReactionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCommentReactionRepository
    extends JpaRepository<UserCommentReaction, UserCommentReactionId> {}
