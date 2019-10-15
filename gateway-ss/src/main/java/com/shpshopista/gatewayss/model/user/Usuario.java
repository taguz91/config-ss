package com.shpshopista.gatewayss.model.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Johnny
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    //@JsonIgnore
    private String password;

    @Column(name = "user_tipo")
    private String user_tipo;

    @Column(name = "user_activo")
    private boolean user_activo = true;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username.toLowerCase();
    }

    public void setUsername(String username) {
        username = username.toLowerCase();
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_tipo() {
        return user_tipo;
    }

    public void setUser_tipo(String user_tipo) {
        user_tipo = user_tipo.toUpperCase();
        this.user_tipo = user_tipo;
    }

    public boolean isUser_activo() {
        return user_activo;
    }

    public void setUser_activo(boolean user_activo) {
        this.user_activo = user_activo;
    }

}
