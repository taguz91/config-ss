package com.shopshopista.oauthprueba.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfiguration;

/**
 *
 * @author gus
 */
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfiguration {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configurando para el token y que puedan probar peticiones sin authentificacion
        http.authorizeRequests()
                .antMatchers(
                        "/oauth/token",
                        "/oauth/authorize**",
                        "/api/"
                ).permitAll();
        // Configurando las demas peticiones 
        http.requestMatchers()
                .antMatchers("/saluda")
                .and().authorizeRequests()
                .antMatchers("/saluda").access("hasRole(USER)")
                .and()
                .requestMatchers()
                .antMatchers("/mensaje")
                .and()
                .authorizeRequests()
                .antMatchers("/mensaje")
                .access("hasRole(ADMIN)");
    }
    
}
