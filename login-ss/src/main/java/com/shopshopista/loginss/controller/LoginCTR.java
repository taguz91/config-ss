package com.shopshopista.loginss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gus
 */
@RestController
@RequestMapping("/test")
@CrossOrigin
public class LoginCTR {
    
    
    @Autowired
    private TokenEndpoint tokenEndpoint;
    
    @Autowired
    private TokenStore tokenStore;
    /*
    public ResponseEntity<?> crearToken(@RequestBody ){
        
    }*/
    
    
    
}
