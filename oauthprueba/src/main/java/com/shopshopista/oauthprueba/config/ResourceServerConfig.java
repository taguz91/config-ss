package com.shopshopista.oauthprueba.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 *
 * @author gus
 */
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // Configurando para el token y que puedan probar peticiones sin authentificacion
        http.authorizeRequests()
                .antMatchers(
                        "/oauth/token",
                        "/oauth/authorize**"
                ).permitAll();
        // Configurando las demas peticiones 
        http.requestMatchers()
                .antMatchers("/api/saluda")
                .and().authorizeRequests()
                .antMatchers("/api/saluda").access("hasRole(USER)")
                .and()
                .requestMatchers()
                .antMatchers("/api/mensaje")
                .and()
                .authorizeRequests()
                .antMatchers("/api/mensaje", "/api/personas")
                .access("hasRole(ADMIN)");
    }
    
}
