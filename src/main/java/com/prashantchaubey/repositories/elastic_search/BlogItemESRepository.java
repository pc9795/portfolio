package com.prashantchaubey.repositories.elastic_search;

import com.prashantchaubey.entities.elastic_search.BlogItemES;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created By: Prashant Chaubey
 * Created On: 25-01-2020 12:20
 **/
public interface BlogItemESRepository extends ElasticsearchRepository<BlogItemES, Long> {
    @Query("{\"bool\":{\"should\":[{\"term\":{\"heading\":\"?0\"}},{\"term\":{\"description\":\"?0\"}}],\"minimum_should_match\":1}}")
    List<BlogItemES> findSearchResults(String searchText);
}