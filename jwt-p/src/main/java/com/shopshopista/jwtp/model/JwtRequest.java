package com.shopshopista.jwtp.model;

import java.io.Serializable;

/**
 *
 * @author Johnny
 */
public class JwtRequest implements Serializable {
    private static final long serialVersionUID = 4223236723763276L;
    
    private String username;
    private String password;

    public JwtRequest() {
    }

    public JwtRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
