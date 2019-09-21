package com.shopshopista.loginss.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author gus
 */
@Entity(name = "Rol")
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private long id_rol;

    @Column(
            name = "rol_nombre",
            nullable = false,
            length = 25
    )
    private String rol_nombre;

    @Column(
            name = "rol_descripcion",
            nullable = false,
            length = 255
    )
    private String descripcion;

    @JsonManagedReference(value = "rol_user")
    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    private List<UserRol> users;

    public Rol() {
    }

    public Rol(long id_rol, String rol_nombre, String descripcion, List<UserRol> users) {
        this.id_rol = id_rol;
        this.rol_nombre = rol_nombre;
        this.descripcion = descripcion;
        this.users = users;
    }

    public long getId_rol() {
        return id_rol;
    }

    public void setId_rol(long id_rol) {
        this.id_rol = id_rol;
    }

    public String getRol_nombre() {
        return rol_nombre;
    }

    public void setRol_nombre(String rol_nombre) {
        this.rol_nombre = rol_nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<UserRol> getUsers() {
        return users;
    }

    public void setUsers(List<UserRol> users) {
        this.users = users;
    }

}

/*


INSERT INTO public.rol(
            id_rol, rol_descripcion, rol_nombre)
    VALUES 
    (1, 'Standard User - Has no admin rights', 'STANDARD_USER'),
    (2, 'Admin User - Has permission to perform admin tasks','ADMIN_USER');

*/
