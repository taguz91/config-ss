package com.shopshopista.loginss.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 *
 * @author gus
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${security.signing-key}")
    private String keyIngreso;

    @Value("${security.encoding-strength}")
    private Integer encodeStrength;

    @Value("${security.security-realm}")
    private String seguridadRealm;

    @Autowired
    private JdbcTemplate jdbcTemp;

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic()
                .realmName(seguridadRealm)
                .and()
                .csrf()
                .disable();
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter conver = new JwtAccessTokenConverter();
        conver.setSigningKey(keyIngreso);
        return conver;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(jdbcTemp.getDataSource());
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices dts = new DefaultTokenServices();
        dts.setTokenStore(tokenStore());
        dts.setSupportRefreshToken(true);
        return dts;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource s = new UrlBasedCorsConfigurationSource();
        CorsConfiguration c = new CorsConfiguration();
        c.setAllowCredentials(true);
        c.addAllowedOrigin("*");
        c.addAllowedHeader("*");
        c.addAllowedMethod("*");
        s.registerCorsConfiguration("/ **", c);
        return new CorsFilter(s);
    }

    // Para la exepcion de 
    // org.springframework.security.web.firewall.RequestRejectedException: 
    // The request was rejected because the HTTP method "UNLINK" 
    // was not included within the whitelist [HEAD, DELETE, POST, GET, OPTIONS, PATCH, PUT]
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web); //To change body of generated methods, choose Tools | Templates.
        web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
    }

    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall shf = new StrictHttpFirewall();
        //shf.setAllowedHttpMethods(allowedHttpMethods);
        shf.setAllowUrlEncodedSlash(true);
        return shf;
    }

}
