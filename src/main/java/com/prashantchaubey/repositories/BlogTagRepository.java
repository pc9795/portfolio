package com.prashantchaubey.repositories;

import com.prashantchaubey.entities.BlogTag;
import com.prashantchaubey.utils.Constants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogTagRepository extends JpaRepository<BlogTag, Long> {
    @EntityGraph(Constants.EntityGraphName.BLOG_TAG_WITH_BLOG_POSTS_LOADED_WITH_BLOG_TAGS)
    BlogTag findByName(String name);

    Page<BlogTag> findAll(Pageable pageable);
}
