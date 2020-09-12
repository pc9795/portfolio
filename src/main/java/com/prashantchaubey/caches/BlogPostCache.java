package com.prashantchaubey.caches;

import com.prashantchaubey.entities.BlogPost;
import com.prashantchaubey.repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BlogPostCache {
  private BlogPostRepository blogPostRepository;

  @Autowired
  public BlogPostCache(BlogPostRepository blogPostRepository) {
    this.blogPostRepository = blogPostRepository;
  }

  public Page<BlogPost> findAll(Pageable pageable) {
    return blogPostRepository.findByOrderByCreatedAtDesc(pageable);
  }

  public Page<BlogPost> findByYearCreatedAtBetween(
      LocalDateTime from, LocalDateTime to, Pageable pageable) {
    return blogPostRepository.findByCreatedAtBetweenOrderByCreatedAtDesc(from, to, pageable);
  }

  public Page<BlogPost> findByHeadingContaining(String searchText, Pageable pageable) {
    return blogPostRepository.findByHeadingContainingIgnoreCaseOrderByCreatedAtDesc(
        searchText, pageable);
  }

  public BlogPost findByName(String name) {
    return blogPostRepository.findByName(name);
  }

  public Page<BlogPost> findByTagName(String blogTagName, Pageable pageable) {
    return blogPostRepository.findByBlogTagsNameOrderByCreatedAtDesc(blogTagName, pageable);
  }

  public boolean existsById(Long id) {
    return blogPostRepository.existsById(id);
  }

  public BlogPost getOne(Long id) {
    return blogPostRepository.getOne(id);
  }
}
