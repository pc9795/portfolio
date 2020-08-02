package com.prashantchaubey.dto.responses;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Builder
@Value
public class GetProjectResponse {
    private String name;

    private String heading;

    private String description;

    private LocalDateTime createAt;

    private String link;
}
