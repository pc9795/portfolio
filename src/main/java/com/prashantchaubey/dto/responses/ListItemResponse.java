package com.prashantchaubey.dto.responses;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.prashantchaubey.entities.ListItem;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Builder
@Value
public class ListItemResponse {
  private String name;

  private ListItem.Type type;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  private LocalDateTime createdAt;
}
