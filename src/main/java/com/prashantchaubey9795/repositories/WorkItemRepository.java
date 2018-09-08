package com.prashantchaubey9795.repositories;

import com.prashantchaubey9795.entities.WorkItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkItemRepository extends JpaRepository<WorkItem, Long> {
}
