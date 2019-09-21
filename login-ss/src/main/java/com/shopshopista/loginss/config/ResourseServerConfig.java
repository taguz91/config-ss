package com.shopshopista.loginss.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 *
 * @author gus
 */
@Configuration
@EnableResourceServer
public class ResourseServerConfig extends ResourceServerConfigurerAdapter {
    
    @Autowired
    private ResourceServerTokenServices tokenService;
    
    @Autowired
    private JwtAccessTokenConverter accessToken;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenServices(tokenService);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/actuator/**", 
                        "/swagger-ui.html",
                        "/login/*",
                        "/oauth/**"
                ).permitAll()
                .antMatchers("/test/**")
                .authenticated();
    }
    
    
    
    
}
