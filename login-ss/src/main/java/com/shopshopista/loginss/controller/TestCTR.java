package com.shopshopista.loginss.controller;

import com.shopshopista.loginss.models.Ciudad;
import com.shopshopista.loginss.models.Usuario;
import com.shopshopista.loginss.service.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gus
 */
@RestController
@RequestMapping("/test")
public class TestCTR {
    
    @Autowired
    private GenericService userSer; 
    
    @RequestMapping(value = "/ciudades", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER') or "
            + "hasAuthority('STANDARD_USER')")
    public List<Ciudad> getCiudades(){
        return userSer.buscarTodasCiudades();
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<Usuario> getUsuarios(){
        return userSer.buscarTodosUsers();
    }
  
    
}
