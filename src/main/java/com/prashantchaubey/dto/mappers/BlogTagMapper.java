package com.prashantchaubey.dto.mappers;

import com.prashantchaubey.dto.responses.BlogTagResponse;
import com.prashantchaubey.entities.BlogTag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlogTagMapper {
    BlogTagResponse to(BlogTag blogTag);
}
