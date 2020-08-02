package com.prashantchaubey.api.v1;

import com.prashantchaubey.caches.ListItemCache;
import com.prashantchaubey.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.Resource.LISTS_V1)
public class ListsResource {

    private ListItemCache listItemCache;

    @Autowired
    public ListsResource(ListItemCache listItemCache) {
        this.listItemCache = listItemCache;
    }
}
