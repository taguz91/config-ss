package com.shpshopista.gatewayss.pojos;

import com.shpshopista.gatewayss.model.user.Usuario;
import java.io.Serializable;

/**
 *
 * @author Johnny
 */
public class LoginRP implements Serializable {

    private final String jwttoken;
    private final long id_user;
    private final String user_name;
    private final String user_tipo;

    public LoginRP(String token, Usuario user) {
        this.jwttoken = token;
        this.id_user = user.getId();
        this.user_name = user.getUsername();
        this.user_tipo = user.getUser_tipo();
    }

    public String getJwttoken() {
        return jwttoken;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_tipo() {
        return user_tipo;
    }

    public long getId_user() {
        return id_user;
    }

}
