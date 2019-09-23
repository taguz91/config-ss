package com.shopshopista.jwtp.model;

import com.shopshopista.jwtp.model.user.Rol;
import com.shopshopista.jwtp.model.user.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Johnny
 */
public class JwtResponse implements Serializable {

    private final String jwttoken;
    private final Usuario user;
    private final List<Rol> roles;

    public JwtResponse(String token, Usuario user) {
        this.jwttoken = token;
        this.user = user;
        this.roles = getRolesFromUser(user);
    }

    public String getJwttoken() {
        return jwttoken;
    }

    public Usuario getUser() {
        return user;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    private List<Rol> getRolesFromUser(Usuario user) {
        List<Rol> rs = new ArrayList<>();
        user.getRoles().forEach(r -> {
            rs.add(r.getRol());
        });
        return rs;
    }

}
