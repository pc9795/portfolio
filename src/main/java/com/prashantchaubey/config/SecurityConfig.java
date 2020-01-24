package com.prashantchaubey.config;

import com.prashantchaubey.entities.User;
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

/**
 * Purpose: Spring security configuration.
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;
    private final ApiUserDetailsService service;

    @Autowired
    public SecurityConfig(DataSource dataSource, ApiUserDetailsService service) {
        this.dataSource = dataSource;
        this.service = service;
    }

    /**
     * Enabling jdbc authentication.
     *
     * @param auth configuration object
     * @throws Exception if something goes wrong
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // We could have used 'defaultSchema' but it won't work with postgresql.
        auth.userDetailsService(service).passwordEncoder(encoder()).
                and().
                jdbcAuthentication().dataSource(dataSource);
    }

    /**
     * Configure http url access.
     *
     * @param http configuration object
     * @throws Exception if something goes wrong
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .exceptionHandling().authenticationEntryPoint(
                (httpServletRequest, httpServletResponse, e) ->
                        // Custom handling on authentication failures
                        Utils.createJSONErrorResponse(HttpServletResponse.SC_UNAUTHORIZED, Constants.ErrorMsg.UNAUTHORIZED,
                                httpServletResponse)
        ).accessDeniedHandler(
                // Custom handling of access denied.
                (request, response, accessDeniedException) -> {
                    Utils.createJSONErrorResponse(HttpServletResponse.SC_FORBIDDEN,
                            Constants.ErrorMsg.FORBIDDEN_RESOURCE, response);
                })
                .and()
                .authorizeRequests()
                //Authorization
                .antMatchers(Constants.Resource.BLOG_ITEM + "/**")
                .hasAnyRole(User.Role.Desc.ADMIN.replace("ROLE_", ""))
                .and()
                .logout().permitAll()
                .logoutSuccessHandler(
                        //Add logout functionality given by spring security
                        ((request, response, authentication) -> new HttpStatusReturningLogoutSuccessHandler())
                );

    }

    /**
     * Password encoder to encode user passwords.
     *
     * @return password encoder
     */
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
