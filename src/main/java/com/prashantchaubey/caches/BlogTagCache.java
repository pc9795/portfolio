package com.prashantchaubey.caches;

import com.prashantchaubey.caches.core.CacheKey;
import com.prashantchaubey.caches.core.SimpleMapCache;
import com.prashantchaubey.entities.BlogTag;
import com.prashantchaubey.repositories.BlogTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@Component
public class BlogTagCache extends SimpleMapCache<BlogTag> {
    private BlogTagRepository blogTagRepository;

    @Autowired
    public BlogTagCache(BlogTagRepository blogTagRepository) {
        this.blogTagRepository = blogTagRepository;
    }

    public Page<BlogTag> findAll(Pageable pageable) {
        return blogTagRepository.findAll(pageable);
    }

    @Override
    public BlogTag load(CacheKey key) {
        return null;
    }
}
