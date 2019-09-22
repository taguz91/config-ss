package com.shopshopista.jwtp.model;

import java.io.Serializable;

/**
 *
 * @author Johnny
 */
public class JwtResponse implements Serializable {

    private final String jwttoken;

    public JwtResponse(String token) {
        this.jwttoken = token;
    }

    public String getJwttoken() {
        return jwttoken;
    }

}
