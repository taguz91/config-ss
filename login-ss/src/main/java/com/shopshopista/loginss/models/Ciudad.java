package com.shopshopista.loginss.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author gus
 */

@Entity(name = "Ciudad")
@Table(name = "ciudad")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudad")
    private long id_ciudad;
    
    @Column(
            name = "ciudad_nombre",
            length = 50,
            nullable = false
    )
    private String ciudad_nombre;

    public Ciudad() {
    }

    public Ciudad(long id_ciudad, String ciudad_nombre) {
        this.id_ciudad = id_ciudad;
        this.ciudad_nombre = ciudad_nombre;
    }

    public long getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(long id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getCiudad_nombre() {
        return ciudad_nombre;
    }

    public void setCiudad_nombre(String ciudad_nombre) {
        this.ciudad_nombre = ciudad_nombre;
    }
    
    
}

/*
INSERT INTO public.ciudad(id_ciudad, ciudad_nombre)
    VALUES (1, 'Bamako'),
    (2, 'Nonkon'),
    (3, 'Houston'),
    (4, 'Toronto'),
    (5, 'New York City'),
    (6, 'Mopti');
*/