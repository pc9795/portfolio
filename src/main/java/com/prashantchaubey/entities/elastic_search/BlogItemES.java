package com.prashantchaubey.entities.elastic_search;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created By: Prashant Chaubey
 * Created On: 25-01-2020 17:43
 **/
@Document(indexName = "blogs", type = "doc")
public class BlogItemES {
    @Getter
    @Setter
    @Id
    private String id;
    @Getter
    @Setter
    private String heading;
    @Getter
    @Setter
    private String description;
}
