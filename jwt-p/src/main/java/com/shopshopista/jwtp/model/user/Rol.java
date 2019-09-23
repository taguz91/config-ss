package com.shopshopista.jwtp.model.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "rol")
public class Rol {

    @Id
    @Column(name = "id_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rol;

    @Column(name = "rol_nombre", nullable = false, unique = true)
    private String rol_nombre;

    @Column(name = "rol_activo")
    private boolean rol_ativo = true;

    @JsonManagedReference(value = "rol_user")
    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    private List<UsuarioRol> usuarios;


    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getRol_nombre() {
        return rol_nombre;
    }

    public void setRol_nombre(String rol_nombre) {
        this.rol_nombre = rol_nombre;
    }

    public boolean isRol_ativo() {
        return rol_ativo;
    }

    public void setRol_ativo(boolean rol_ativo) {
        this.rol_ativo = rol_ativo;
    }

    public List<UsuarioRol> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioRol> usuarios) {
        this.usuarios = usuarios;
    }

}
