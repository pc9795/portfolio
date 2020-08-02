package com.prashantchaubey.repositories;

import com.prashantchaubey.entities.ListItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListItemRepository extends JpaRepository<ListItem, Long> {

    Page<ListItem> findListItemsByType(ListItem.Type type, Pageable pageable);
}
