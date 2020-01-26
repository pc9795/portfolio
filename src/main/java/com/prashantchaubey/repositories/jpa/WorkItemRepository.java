package com.prashantchaubey.repositories.jpa;

import com.prashantchaubey.entities.WorkItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for WorkItem
 */
public interface WorkItemRepository extends JpaRepository<WorkItem, Long> {
    /**
     * Find 2 recent work items
     *
     * @return work items
     */
    List<WorkItem> findTop2ByOrderByCreatedAtDesc();

    /**
     * Find by descending order of creation time.
     *
     * @return work items
     */
    List<WorkItem> findByOrderByCreatedAtDesc();
}

