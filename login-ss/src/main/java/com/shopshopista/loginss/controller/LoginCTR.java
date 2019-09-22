package com.shopshopista.loginss.controller;

import com.shopshopista.loginss.models.Usuario;
import com.shopshopista.loginss.service.GenericService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gus
 */
@RestController
@RequestMapping("/")
public class LoginCTR {

    @Autowired
    private GenericService userSer;

    @RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
    @CrossOrigin
    public Usuario getUser(@PathVariable String username) {
        return userSer.findByUsername(username);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @CrossOrigin
    public List<Usuario> getUsuarios() {
        return userSer.buscarTodosUsers();
    }
    
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @CrossOrigin
    public void login(@Valid @RequestBody Usuario user) {
        System.out.println(user);
    }
    
    

}
