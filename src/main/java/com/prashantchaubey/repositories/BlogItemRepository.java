package com.prashantchaubey.repositories;

import com.prashantchaubey.entities.BlogItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogItemRepository extends JpaRepository<BlogItem, Long> {
    List<BlogItem> findBlogItemsByOrderByCreatedAtDesc();

    @Query(value = "select * from blogitem where to_char(timestamp,'MON_YYYY')=:monthYear", nativeQuery = true)
    List<BlogItem> findBlogItemsByMonthsAndYear(@Param("monthYear") String monthYear);

    @Query(value = "select * from blogitem where to_char(timestamp,'YYYY')=:year", nativeQuery = true)
    List<BlogItem> findBlogItemsByYear(@Param("year") String year);

    List<BlogItem> findBlogItemsByHeadingContaining(String searchText);

    BlogItem findBlogItemById(long id);

    List<BlogItem> findTop3BlogItemsByOrderByCreatedAtDesc();

}
