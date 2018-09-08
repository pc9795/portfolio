package com.prashantchaubey9795.repositories;

import com.prashantchaubey9795.entities.TutorialItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TutorialItemRepository extends JpaRepository<TutorialItem, Long> {
    public List<TutorialItem> findTutorialItemsByOrderByTimestampDesc();

    @Query(value = "select * from tutorialitem where to_char(timestamp,'MON_YYYY')=:monthYear", nativeQuery = true)
    public List<TutorialItem> findTutorialItemsByMonthsAndYear(@Param("monthYear") String monthYear);

    @Query(value = "select * from tutorialitem where to_char(timestamp,'YYYY')=:year", nativeQuery = true)
    public List<TutorialItem> findTutorialItemsByYear(@Param("year") String year);

    public List<TutorialItem> findTutorialItemsByHeadingContaining(String serachText);

    public TutorialItem findTutorialItemById(long id);
}
