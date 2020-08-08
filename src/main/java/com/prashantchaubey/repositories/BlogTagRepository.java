package com.prashantchaubey.repositories;

import com.prashantchaubey.entities.BlogTag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogTagRepository extends JpaRepository<BlogTag, Long> {
    Page<BlogTag> findAll(Pageable pageable);
}
