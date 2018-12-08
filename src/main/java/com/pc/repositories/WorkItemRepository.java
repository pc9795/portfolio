package com.pc.repositories;

import com.pc.entities.WorkItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkItemRepository extends JpaRepository<WorkItem, Long> {
    List<WorkItem> findTop2ByOrderByTimestampDesc();
}
