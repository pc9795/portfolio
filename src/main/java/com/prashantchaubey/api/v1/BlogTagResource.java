package com.prashantchaubey.api.v1;

import com.prashantchaubey.caches.BlogTagCache;
import com.prashantchaubey.dto.mappers.BlogPostMapper;
import com.prashantchaubey.dto.mappers.BlogTagMapper;
import com.prashantchaubey.dto.responses.GetBlogPostResponse;
import com.prashantchaubey.dto.responses.GetBlogTagResponse;
import com.prashantchaubey.entities.BlogTag;
import com.prashantchaubey.exceptions.ResourceNotFoundException;
import com.prashantchaubey.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(Constants.Resource.BLOG_TAGS_V1)
public class BlogTagResource {
    private final BlogTagCache blogTagCache;
    private final BlogTagMapper blogTagMapper;
    private final BlogPostMapper blogPostMapper;

    @Autowired
    public BlogTagResource(BlogTagCache blogTagCache, BlogTagMapper blogTagMapper, BlogPostMapper blogPostMapper) {
        this.blogTagCache = blogTagCache;
        this.blogTagMapper = blogTagMapper;
        this.blogPostMapper = blogPostMapper;
    }

    @GetMapping
    public Page<GetBlogTagResponse> getAll(Pageable pageable) {
        return blogTagCache.findAll(pageable).map(blogTagMapper::to);
    }

    @GetMapping("/{blogTagName}/blog-posts")
    public List<GetBlogPostResponse> getByTag(@PathVariable("blogTagName") String blogTagName) {
        BlogTag blogTag = blogTagCache.findByName(blogTagName);
        if (blogTag == null) {
            throw new ResourceNotFoundException(String.format("No blog tag found with name:%s", blogTagName));
        }

        return blogTag.getBlogPosts().stream().map(blogPostMapper::to).collect(Collectors.toList());
    }
}
