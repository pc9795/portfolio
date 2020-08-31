package com.prashantchaubey.dto.mappers;

import com.prashantchaubey.dto.responses.ListItemResponse;
import com.prashantchaubey.entities.ListItem;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ListItemMapper {
  ListItemResponse to(ListItem listItem);
}
