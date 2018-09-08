package com.prashantchaubey9795.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

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
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * This bean will take the string returned from controllers and with the help of suffix
     * and prefix find the associated view i.e., jsp page.
     *
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setSuffix(".jsp");
        resolver.setPrefix("/WEB-INF/views/");
        return resolver;
    }

}
