package com.prashantchaubey.repositories.jpa;

import com.prashantchaubey.entities.ListItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created By: Prashant Chaubey
 * Created On: 02-09-2018 03:47
 * Repository for entity ListItem.
 **/
public interface ListItemRepository extends JpaRepository<ListItem, Long> {
    /**
     * Find list items by type
     *
     * @param type type of the list
     * @return list items
     */
    List<ListItem> findListItemsByType(ListItem.Type type);
}
