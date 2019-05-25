package com.pc.repositories;

import com.pc.entities.BlogTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BlogTagRepository extends JpaRepository<BlogTag, Long> {
    public BlogTag findBlogTagById(long id);
}