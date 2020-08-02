package com.prashantchaubey.repositories;

import com.prashantchaubey.entities.BlogPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    Page<BlogPost> findByOrderByCreatedAtDesc(Pageable pageable);

    @Query(value = "select * from blogitem where to_char(timestamp,'MON_YYYY')=:monthYear", nativeQuery = true)
    Page<BlogPost> findByMonthsAndYear(@Param("monthYear") String monthYear, Pageable pageable);

    @Query(value = "select * from blogitem where to_char(timestamp,'YYYY')=:year", nativeQuery = true)
    Page<BlogPost> findByYear(@Param("year") String year, Pageable pageable);

    Page<BlogPost> findByHeadingContaining(String searchText, Pageable pageable);

    BlogPost findByName(String name);
}
