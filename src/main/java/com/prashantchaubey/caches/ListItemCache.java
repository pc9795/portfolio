package com.prashantchaubey.caches;

import com.prashantchaubey.entities.ListItem;
import com.prashantchaubey.repositories.ListItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ListItemCache {
    private ListItemRepository listItemRepository;

    @Autowired
    public ListItemCache(ListItemRepository listItemRepository) {
        this.listItemRepository = listItemRepository;
    }

    public Page<ListItem> findByType(ListItem.Type type, Pageable pageable) {
        return listItemRepository.findByType(type, pageable);
    }
}
