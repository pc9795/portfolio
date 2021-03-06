package com.prashantchaubey.api.v1;

import com.prashantchaubey.caches.BlogTagCache;
import com.prashantchaubey.dto.mappers.BlogTagMapper;
import com.prashantchaubey.dto.responses.BlogTagResponse;
import com.prashantchaubey.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.Endpoint.BLOG_TAGS_V1)
public class BlogTagResource {
  private final BlogTagCache blogTagCache;
  private final BlogTagMapper blogTagMapper;

  @Autowired
  public BlogTagResource(BlogTagCache blogTagCache, BlogTagMapper blogTagMapper) {
    this.blogTagCache = blogTagCache;
    this.blogTagMapper = blogTagMapper;
  }

  @GetMapping
  public Page<BlogTagResponse> getAll(Pageable pageable) {
    return blogTagCache.findAll(pageable).map(blogTagMapper::toBlogTagResponse);
  }
}
