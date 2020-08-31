package com.prashantchaubey.dto.mappers;

import com.prashantchaubey.dto.responses.BlogPostResponse;
import com.prashantchaubey.dto.responses.BlogPostWithContentResponse;
import com.prashantchaubey.dto.responses.BlogTagResponse;
import com.prashantchaubey.entities.BlogPost;
import com.prashantchaubey.entities.BlogTag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class BlogPostMapper {
  @Autowired private BlogTagMapper blogTagMapper;

  @Mapping(
      source = "blogTags",
      target = "blogTags",
      qualifiedByName = "blogTagToGetBlogTagResponse")
  public abstract BlogPostResponse toBlogPostResponse(BlogPost blogPost);

  @Mapping(
      source = "blogTags",
      target = "blogTags",
      qualifiedByName = "blogTagToGetBlogTagResponse")
  @Mapping(
      source = "content",
      target = "content") // Map struct was not mapping this column automatically
  public abstract BlogPostWithContentResponse toBlogPostWithContentResponse(BlogPost blogPost);

  @Named("blogTagToGetBlogTagResponse")
  Set<BlogTagResponse> blogTagToGetBlogTagResponse(Set<BlogTag> blogTags) {
    return blogTags.stream().map(blogTagMapper::toBlogTagResponse).collect(Collectors.toSet());
  }
}
