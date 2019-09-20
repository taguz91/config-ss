package com.shpshopista.pruebass.controller;

import com.shpshopista.pruebass.model.Carro;
import com.shpshopista.pruebass.model.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gus
 */
@RestController
@RequestMapping("api/v1/carro")
public class CarroCTR {
    
    @GetMapping("/{id}")
    public Carro getCart(@Valid @PathVariable long id) {
        List<Producto> ps = new ArrayList<>();
        Producto p1 = new Producto(1, "Patata", 1, 2.3);
        ps.add(p1);

        Producto p2 = new Producto(2, "Tomate", 2, 5.4);
        ps.add(p2);

        Carro c = new Carro(
                p1.getCantidad() + p2.getCantidad(),
                (p1.getCantidad() * p1.getPrecio()) +
                (p2.getCantidad() * p2.getPrecio()),
                ps
        );
        return c;
    }

}
