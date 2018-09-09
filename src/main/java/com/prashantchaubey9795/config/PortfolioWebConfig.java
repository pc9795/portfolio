package com.prashantchaubey9795.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * Beans used by the servlet.
 * Created By: Prashant Chaubey
 */
@ComponentScan
@EnableWebMvc
@ComponentScan(value = "com.prashantchaubey9795.controllers")
public class PortfolioWebConfig extends WebMvcConfigurerAdapter {

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
     * This bean will take the string returned from controllers and with the help of suffix
     * and prefix find the associated view i.e., jsp page.
     *
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

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resource/**").addResourceLocations("/resources/", "/node_modules/");
//    }
}
