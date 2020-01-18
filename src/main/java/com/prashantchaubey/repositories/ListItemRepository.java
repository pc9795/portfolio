package com.prashantchaubey.repositories;

import com.prashantchaubey.entities.ListItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for list items.
 * Created By: Prashant Chaubey
 * Created On: 02-09-2018 03:47
 **/
public interface ListItemRepository extends JpaRepository<ListItem, Long> {
    List<ListItem> findListItemsByType(ListItem.Type type);
}
