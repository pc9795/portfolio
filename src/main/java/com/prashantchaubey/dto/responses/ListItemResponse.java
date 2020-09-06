package com.prashantchaubey.dto.responses;

import com.prashantchaubey.entities.ListItem;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDateTime;

@Builder
@Value
public class ListItemResponse {
  @NonNull private String name;

  @NonNull private ListItem.Type type;

  @NonNull private LocalDateTime createdAt;
}
