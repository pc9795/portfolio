package com.prashantchaubey.dto.mappers;

import com.prashantchaubey.dto.responses.BlogTagResponse;
import com.prashantchaubey.entities.BlogTag;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BlogTagMapper {
  BlogTagResponse toBlogTagResponse(BlogTag blogTag);
}
