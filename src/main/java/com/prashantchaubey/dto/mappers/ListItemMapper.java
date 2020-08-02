package com.prashantchaubey.dto.mappers;

import com.prashantchaubey.dto.responses.GetListItemResponse;
import com.prashantchaubey.entities.ListItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ListItemMapper {
    GetListItemResponse to(ListItem listItem);
}
