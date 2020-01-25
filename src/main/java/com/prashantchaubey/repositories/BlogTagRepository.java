package com.prashantchaubey.repositories;

import com.prashantchaubey.entities.BlogTag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for BlogTag
 */
public interface BlogTagRepository extends JpaRepository<BlogTag, Long> {
    /**
     * Get blog tag by id
     *
     * @param id input id
     * @return blog tag object
     */
    BlogTag findBlogTagById(long id);

    /**
     * Get blog tag by name
     *
     * @param name tag name
     * @return blog tag object
     */
    BlogTag findBlogTagByName(String name);
}
