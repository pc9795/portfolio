package com.prashantchaubey.repositories;

import com.prashantchaubey.entities.Comment;
import com.prashantchaubey.utils.Constants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
  @EntityGraph(Constants.EntityGraphName.COMMENT_WITH_USERS)
  Page<Comment> findAllByBlogPostIdOrderByCreatedAt(Long blogPostId, Pageable pageable);

  @EntityGraph(Constants.EntityGraphName.COMMENT_WITH_USERS)
  Optional<Comment> findById(Long id);

  @EntityGraph(Constants.EntityGraphName.COMMENT_WITH_USERS)
  Comment save(Comment comment);

  @Modifying
  @Transactional
  @Query("update Comment c set c.message = :message where c.id = :id")
  void updateMessage(@Param("id") Long id, @Param("message") String message);

  @Modifying
  @Query("update Comment  c set c.upVotes = c.upVotes + 1 where c.id = :id")
  void incrementUpVote(@Param("id") Long id);

  @Modifying
  @Query("update Comment  c set c.upVotes = c.upVotes - 1 where c.id = :id")
  void decrementUpVote(@Param("id") Long id);

  @Modifying
  @Query("update Comment  c set c.downVotes = c.downVotes + 1 where c.id = :id")
  void incrementDownVote(@Param("id") Long id);

  @Modifying
  @Query("update Comment  c set c.downVotes = c.downVotes - 1 where c.id = :id")
  void decrementDownVote(@Param("id") Long id);
}
