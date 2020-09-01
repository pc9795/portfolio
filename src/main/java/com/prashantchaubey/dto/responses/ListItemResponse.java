package com.prashantchaubey.dto.responses;

import com.prashantchaubey.entities.ListItem;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Builder
@Value
public class ListItemResponse {
  private String name;

  private ListItem.Type type;

  private LocalDateTime createdAt;
}
