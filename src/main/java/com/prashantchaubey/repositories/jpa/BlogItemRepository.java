package com.prashantchaubey.repositories.jpa;

import com.prashantchaubey.entities.BlogItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository for entity BlogItm
 */
public interface BlogItemRepository extends JpaRepository<BlogItem, Long> {
    /**
     * Get blog items in descending order of creation date.
     *
     * @return blog items
     */
    List<BlogItem> findBlogItemsByOrderByCreatedAtDesc();

    /**
     * Get blog items by particular month and year
     *
     * @param monthYear month in uppercase 3 letters and year in 4 letters separated by hypon(_)
     * @return blog items
     */
    @Query(value = "select * from blogitem where to_char(timestamp,'MON_YYYY')=:monthYear", nativeQuery = true)
    List<BlogItem> findBlogItemsByMonthsAndYear(@Param("monthYear") String monthYear);

    /**
     * Get blog items by given year
     *
     * @param year year in 4 letters
     * @return blog items
     */
    @Query(value = "select * from blogitem where to_char(timestamp,'YYYY')=:year", nativeQuery = true)
    List<BlogItem> findBlogItemsByYear(@Param("year") String year);

    /**
     * Get blog items with given heading
     *
     * @param searchText text to search for in heading
     * @return blog items
     */
    List<BlogItem> findBlogItemsByHeadingContaining(String searchText);

    /**
     * Get blog item with given id
     *
     * @param id input id
     * @return blog item
     */
    BlogItem findBlogItemById(long id);

    List<BlogItem> findTop3BlogItemsByOrderByCreatedAtDesc();
}
