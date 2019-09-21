package com.shopshopista.loginss.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author gus
 */
@Entity(name = "UserRol")
@Table(name = "user_rol")
public class UserRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id_user_rol",
            nullable = false
    )
    private long id_user_rol;

    @JsonBackReference(value = "user_rol")
    @JoinColumn(name = "id_user")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Usuario usuario;

    @JsonBackReference(value = "rol_user")
    @JoinColumn(name = "id_rol")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Rol rol;

    public UserRol() {
    }

    public UserRol(long id_user_rol, Usuario user, Rol rol) {
        this.id_user_rol = id_user_rol;
        this.usuario = user;
        this.rol = rol;
    }

    public long getId_user_rol() {
        return id_user_rol;
    }

    public void setId_user_rol(long id_user_rol) {
        this.id_user_rol = id_user_rol;
    }

    public Usuario getUser() {
        return usuario;
    }

    public void setUser(Usuario user) {
        this.usuario = user;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

}

/*

INSERT INTO public.user_rol(
            id_user_rol, id_rol, id_user)
    VALUES 
    (1, 1, 1),
    (2, 2, 1),
    (3, 2, 2);

*/