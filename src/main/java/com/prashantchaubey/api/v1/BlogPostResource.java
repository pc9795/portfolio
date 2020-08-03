package com.prashantchaubey.api.v1;

import com.prashantchaubey.caches.BlogPostCache;
import com.prashantchaubey.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.Resource.BLOG_POSTS_V1)
public class BlogPostResource {
    private final BlogPostCache blogPostCache;
    @Autowired
    public BlogPostResource(BlogPostCache blogPostCache) {
        this.blogPostCache = blogPostCache;
    }

    @GetMapping
    public void getAll() {

    }

    public void getByYear() {

    }

    public void getByMonthYear() {

    }

    public void search() {

    }

    public void getByName() {

    }
}