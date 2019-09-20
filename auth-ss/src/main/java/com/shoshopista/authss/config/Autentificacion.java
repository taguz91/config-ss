package com.shoshopista.authss.config;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 *
 * @author gus
 */
@Configuration
@EnableAuthorizationServer
public class Autentificacion extends AuthorizationServerConfigurerAdapter {

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain tec = new TokenEnhancerChain();
        tec.setTokenEnhancers(
                Arrays.asList(
                        tokenEnchancer(), 
                        accessTokenConverter()
                )
        );
        
        endpoints.tokenStore(tokenStore())
                .tokenEnhancer(tec)
                .authenticationManager(authenticationManager);
    }
    
    // Toke 
    @Bean
    public TokenStore tokenStore(){
        return new JwtTokenStore(accessTokenConverter());
    }
    
    @Bean
    public JwtAccessTokenConverter accessTokenConverter(){
        JwtAccessTokenConverter c = new JwtAccessTokenConverter();
        c.setSigningKey("123");
        return c;
    }
    
    @Bean
    @Primary
    public DefaultTokenServices tokenServices(){
        DefaultTokenServices dts = new DefaultTokenServices();
        dts.setTokenStore(tokenStore());
        dts.setSupportRefreshToken(true);
        return dts;
    }
    
    // Token personalizado 
    @Bean
    public TokenEnhancer tokenEnchancer(){
        return new CustomTokenEnhancer();
    }

}
