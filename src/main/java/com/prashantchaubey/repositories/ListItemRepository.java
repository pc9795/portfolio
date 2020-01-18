package com.prashantchaubey.repositories;

import com.prashantchaubey.entities.ListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Repository for list items.
 * Created By: Prashant Chaubey
 * Created On: 02-09-2018 03:47
 **/
@Transactional
@Repository
public interface ListItemRepository extends JpaRepository<ListItem, Long> {
    public List<ListItem> findListItemsByType(String type);
}
