package com.prashantchaubey9795.repositories;

import com.prashantchaubey9795.entities.BlogItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface BlogItemRepository extends JpaRepository<BlogItem, Long> {
    public List<BlogItem> findBlogItemsByOrderByTimestampDesc();

    @Query(value = "select * from blogitem where to_char(timestamp,'MON_YYYY')=:monthYear", nativeQuery = true)
    public List<BlogItem> findBlogItemsByMonthsAndYear(@Param("monthYear") String monthYear);

    @Query(value = "select * from blogitem where to_char(timestamp,'YYYY')=:year", nativeQuery = true)
    public List<BlogItem> findBlogItemsByYear(@Param("year") String year);

    public List<BlogItem> findBlogItemsByHeadingContaining(String serachText);

    public BlogItem findBlogItemById(long id);

    public List<BlogItem> findTop3BlogItemsByOrderByTimestampDesc();

    public List<BlogItem> findBlogItemsByOrOrderByTimestampDesc(Pageable)

}
