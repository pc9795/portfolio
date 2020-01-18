package com.prashantchaubey.repositories;

import com.prashantchaubey.entities.BlogTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogTagRepository extends JpaRepository<BlogTag, Long> {
    BlogTag findBlogTagById(long id);
}
