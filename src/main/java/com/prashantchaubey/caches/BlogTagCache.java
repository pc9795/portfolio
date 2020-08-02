package com.prashantchaubey.caches;

import com.prashantchaubey.caches.core.CacheKey;
import com.prashantchaubey.caches.core.SimpleMapCache;
import com.prashantchaubey.entities.BlogTag;
import com.prashantchaubey.repositories.BlogTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlogTagCache extends SimpleMapCache<BlogTag> {
    private BlogTagRepository blogTagRepository;

    @Autowired
    public BlogTagCache(BlogTagRepository blogTagRepository) {
        this.blogTagRepository = blogTagRepository;
    }

    public BlogTag findByName(String name) {
        return blogTagRepository.findByName(name);
    }

    @Override
    public BlogTag load(CacheKey key) {
        return null;
    }
}
