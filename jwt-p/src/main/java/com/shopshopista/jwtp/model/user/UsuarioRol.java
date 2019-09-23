package com.shopshopista.jwtp.model.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Johnny
 */
@Entity
@Table(name = "usuario_rol", uniqueConstraints = {
    @UniqueConstraint(columnNames = {
        "id_usuario", "id_rol"
    })
})
public class UsuarioRol {

    @Id
    @Column(name = "id_user_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user_rol;

    @JsonBackReference(value = "user_rol")
    @JoinColumn(name = "id_usuario")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Usuario usuario;

    @JsonBackReference(value = "rol_user")
    @JoinColumn(name = "id_rol")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    /*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)*/
    private Rol rol;

    public int getId_user_rol() {
        return id_user_rol;
    }

    public void setId_user_rol(int id_user_rol) {
        this.id_user_rol = id_user_rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

}
