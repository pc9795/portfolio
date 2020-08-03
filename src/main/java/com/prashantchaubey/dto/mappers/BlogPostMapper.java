package com.prashantchaubey.dto.mappers;

import com.prashantchaubey.dto.responses.BlogPostResponse;
import com.prashantchaubey.dto.responses.BlogPostWithContentResponse;
import com.prashantchaubey.dto.responses.BlogTagResponse;
import com.prashantchaubey.entities.BlogPost;
import com.prashantchaubey.entities.BlogTag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class BlogPostMapper {
    @Autowired
    private BlogTagMapper blogTagMapper;

    @Mapping(source = "blogTags", target = "blogTags", qualifiedByName = "blogTagToGetBlogTagResponse")
    public abstract BlogPostResponse toBlogPostResponse(BlogPost blogPost);

    @Mapping(source = "blogTags", target = "blogTags", qualifiedByName = "blogTagToGetBlogTagResponse")
    public abstract BlogPostWithContentResponse toBlogPostWithContentResponse(BlogPost blogPost);

    @Named("blogTagToGetBlogTagResponse")
    Set<BlogTagResponse> blogTagToGetBlogTagResponse(Set<BlogTag> blogTags) {
        return blogTags.stream().map(blogTagMapper::to).collect(Collectors.toSet());
    }
}