package com.shopshopista.loginss.config;

/**
 *
 * @author gus
 *//*
@Configuration
@EnableAuthorizationServer*/
public class AuthorizationServerConfig {
    /*
    @Autowired
    private TokenStore tokenStore;
    
    @Autowired
    private JwtAccessTokenConverter accessTokenStore;
    
    @Autowired
    private AuthenticationManager autentificacionManager;
    
    @Autowired
    private UserDetailsService userDetailService;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(jdbcTemplate.getDataSource());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore)
                .reuseRefreshTokens(false)
                .accessTokenConverter(accessTokenStore)
                .authenticationManager(autentificacionManager)
                .userDetailsService(userDetailService);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("hasAuthority('ROLE_TRUSTED_CLIENT')")
                .checkTokenAccess("hasAuthority('ROLE_TRUSTED_CLIENT')");
    }*/
    
    
    
    
    
}
