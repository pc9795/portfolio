package com.prashantchaubey9795.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Dispatcher servlet for the portfolio.
 * We have to extend this particular class to make it a Dispatcher servlet.
 * Created By: Prashant Chaubey
 */
public class PortfolioInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    /*
    Return the configuration classes which provide beans for whole application.
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                PortfolioRootConfig.class
        };
    }

    /*
    Return the configuration classes which provide beans for a particular servlet mapping.
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                PortfolioWebConfig.class
        };
    }

    /*
    Servlet mapping to which the application listens.
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{
                "/"
        };
    }
}
