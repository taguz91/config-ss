package com.shopshopista.oauthprueba.config;

import com.shopshopista.oauthprueba.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author gus
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private BCryptPasswordEncoder bCrypt;
    
    @Bean
    public BCryptPasswordEncoder passEncoder(){
        BCryptPasswordEncoder bcryp = new BCryptPasswordEncoder();
        return bcryp;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        // Usuarios por memoria 
        /*
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("123")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("USER", "ADMIN");*/
        auth.userDetailsService(userService)
                .passwordEncoder(bCrypt);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        /*http.requestMatchers()
                .and()
                .authorizeRequests()
                .antMatchers("/login")
                .permitAll()
                .antMatchers("api/**")
                .authenticated()
                .and()
                .httpBasic();*/
    }
    
    
    
    
}
