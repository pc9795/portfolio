package com.prashantchaubey;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import javax.validation.Valid;

/**
 * Created By: Prashant Chaubey
 * Created On: 18-01-2020 13:41
 * Purpose: Entry point of the program
 **/
@EnableWebMvc
@SpringBootApplication
public class Main implements WebMvcConfigurer {
    @Value("${elasticsearch.url}")
    String elasticsearchURL;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    /**
     * With the help of this setting our application will not handle static resources.
     *
     * @param configurer:contains settings for default servlet.
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * @return view resolver instance
     */
    @Bean
    public ViewResolver viewResolver() {
        return new TilesViewResolver();
    }


    /**
     * Configure apache tiles
     *
     * @return tiles configurer instance
     */
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/layout/tiles.xml");
        return tilesConfigurer;
    }

    @Bean
    public RestHighLevelClient elasticSearchClient() {
        ClientConfiguration conf = ClientConfiguration.builder().connectedTo(elasticsearchURL).build();
        return RestClients.create(conf).rest();
    }
}
