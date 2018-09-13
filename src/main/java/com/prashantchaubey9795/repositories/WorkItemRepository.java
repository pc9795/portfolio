package com.prashantchaubey9795.repositories;

import com.prashantchaubey9795.entities.WorkItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkItemRepository extends JpaRepository<WorkItem, Long> {
    List<WorkItem> findTop2ByOrderByTimestampDesc();
}
