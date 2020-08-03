package com.prashantchaubey.dto.mappers;

import com.prashantchaubey.dto.responses.GetBlogTagResponse;
import com.prashantchaubey.entities.BlogTag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlogTagMapper {
    GetBlogTagResponse to(BlogTag blogTag);
}
