package com.shopshopista.loginss.models;

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
 * @author gus
 */
@Entity(name = "Usuario")
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private long id_user;

    @Column(
            name = "primer_nombre",
            nullable = false,
            length = 25
    )
    private String primer_nombre;

    @Column(
            name = "primer_apellido",
            nullable = false,
            length = 25
    )
    private String primer_apellido;

    @Column(
            name = "username",
            nullable = false,
            length = 255
    )
    private String username;

    @Column(
            name = "pass",
            nullable = false,
            length = 255
    )
    private String pass;

    @JsonManagedReference(value = "user_rol")
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<UserRol> roles;

    public Usuario() {
    }

    public Usuario(long id_user, String primer_nombre, String primer_apellido, String username, String pass, List<UserRol> roles) {
        this.id_user = id_user;
        this.primer_nombre = primer_nombre;
        this.primer_apellido = primer_apellido;
        this.username = username;
        this.pass = pass;
        this.roles = roles;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<UserRol> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRol> roles) {
        this.roles = roles;
    }

}


/*

INSERT INTO public.usuario(
            id_user, 
            pass, 
            primer_apellido, 
            primer_nombre, 
            username)
    VALUES (1, 
    '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 
    'Doe', 
    'John', 
    'john.doe'),
    (2, 
    '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 
    'Admin', 
    'Admin', 
    'admin.admin');


*/