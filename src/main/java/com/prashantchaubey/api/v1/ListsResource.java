package com.prashantchaubey.api.v1;

import com.prashantchaubey.caches.ListItemCache;
import com.prashantchaubey.dto.mappers.ListItemMapper;
import com.prashantchaubey.dto.responses.GetListItemResponse;
import com.prashantchaubey.entities.ListItem;
import com.prashantchaubey.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.Resource.LISTS_V1)
public class ListsResource {

    private ListItemCache listItemCache;
    private ListItemMapper listItemMapper;

    @Autowired
    public ListsResource(ListItemCache listItemCache, ListItemMapper listItemMapper) {
        this.listItemCache = listItemCache;
        this.listItemMapper = listItemMapper;
    }

    @GetMapping("/technical")
    public Page<GetListItemResponse> getTechnicalLists(Pageable pageable) {
        return listItemCache.findByType(ListItem.Type.TECHNICAL, pageable).map(listItemMapper::to);
    }

    @GetMapping("/gaming")
    public Page<GetListItemResponse> getGamingList(Pageable pageable) {
        return listItemCache.findByType(ListItem.Type.GAMING, pageable).map(listItemMapper::to);
    }
}
