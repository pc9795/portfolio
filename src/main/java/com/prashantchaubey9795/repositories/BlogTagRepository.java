package com.prashantchaubey9795.repositories;

import com.prashantchaubey9795.entities.BlogItem;
import com.prashantchaubey9795.entities.BlogTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface BlogTagRepository extends JpaRepository<BlogTag, Long> {
    public BlogTag findBlogTagById(long id);
}
