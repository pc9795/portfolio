package com.prashantchaubey.dto.mappers;

import com.prashantchaubey.dto.responses.ListItemResponse;
import com.prashantchaubey.entities.ListItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ListItemMapper {
    ListItemResponse to(ListItem listItem);
}
