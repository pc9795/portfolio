package com.prashantchaubey.api.v1;

import com.prashantchaubey.caches.BlogPostCache;
import com.prashantchaubey.caches.BlogTagCache;
import com.prashantchaubey.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.Resource.BLOG_POSTS_V1)
public class BlogPostResource {
    private final BlogPostCache blogPostCache;
    private final BlogTagCache blotTagCache;

    @Autowired
    public BlogPostResource(BlogPostCache blogPostCache, BlogTagCache blotTagCache) {
        this.blogPostCache = blogPostCache;
        this.blotTagCache = blotTagCache;
    }
}