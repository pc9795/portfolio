package com.prashantchaubey.repositories;

import com.prashantchaubey.entities.BlogPost;
import com.prashantchaubey.utils.Constants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
  @EntityGraph(Constants.EntityGraphName.BLOG_POST_WITH_BLOG_TAGS)
  Page<BlogPost> findByOrderByCreatedAtDesc(Pageable pageable);

  @EntityGraph(Constants.EntityGraphName.BLOG_POST_WITH_BLOG_TAGS)
  Page<BlogPost> findByCreatedAtBetweenOrderByCreatedAtDesc(
      LocalDateTime from, LocalDateTime to, Pageable pageable);

  @EntityGraph(Constants.EntityGraphName.BLOG_POST_WITH_BLOG_TAGS)
  Page<BlogPost> findByHeadingContainingOrderByCreatedAtDesc(String searchText, Pageable pageable);

  @EntityGraph(Constants.EntityGraphName.BLOG_POST_WITH_BLOG_TAGS)
  BlogPost findByName(String name);

  @EntityGraph(Constants.EntityGraphName.BLOG_POST_WITH_BLOG_TAGS)
  Page<BlogPost> findByBlogTagsNameOrderByCreatedAtDesc(String name, Pageable pageable);
}
