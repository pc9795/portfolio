package com.prashantchaubey.dto.responses;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GetBlogTagResponse {
    private String name;
}
