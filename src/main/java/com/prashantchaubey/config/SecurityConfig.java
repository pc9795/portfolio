package com.prashantchaubey.config;

import com.prashantchaubey.entities.Role;
import com.prashantchaubey.services.ApiUserDetailsService;
import com.prashantchaubey.utils.Constants;
import com.prashantchaubey.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;
    private final ApiUserDetailsService service;

    @Autowired
    public SecurityConfig(DataSource dataSource, ApiUserDetailsService service) {
        this.dataSource = dataSource;
        this.service = service;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service).passwordEncoder(encoder()).
                and().
                jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .exceptionHandling().authenticationEntryPoint(
                (httpServletRequest, httpServletResponse, e) ->
                        Utils.updateErrorInResponse(HttpServletResponse.SC_UNAUTHORIZED, Constants.ErrorMsg.UNAUTHORIZED,
                                httpServletResponse)
        ).accessDeniedHandler(
                (request, response, accessDeniedException) ->
                        Utils.updateErrorInResponse(HttpServletResponse.SC_FORBIDDEN,
                                Constants.ErrorMsg.FORBIDDEN_RESOURCE, response))
                .and()
                .authorizeRequests()
                .antMatchers(Constants.Resource.BLOG_POSTS_V1 + "/**")
                .hasAnyRole(Role.Desc.ADMIN.replace("ROLE_", ""))
                .and()
                .logout().permitAll()
                .logoutSuccessHandler(
                        ((request, response, authentication) -> new HttpStatusReturningLogoutSuccessHandler())
                );
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
