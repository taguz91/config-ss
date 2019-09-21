package com.shopshopista.oauthprueba.controllers;

import com.shopshopista.oauthprueba.models.PersonaP;
import com.shopshopista.oauthprueba.repository.PersonaREPO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gus
 */
@RestController
@RequestMapping("api/")
public class PersonaCTR {
    
    @Autowired
    private PersonaREPO repo;
    
    
    @GetMapping("/")
    public String home(){
        return "HOME PAGE";
    }
    
    @GetMapping("/mensaje")
    @CrossOrigin
    public String prueba(){
        PersonaP p = new PersonaP();
        p.setNombre("Pepe");
        repo.save(p);
        return "GUARDADO";
    }
    
    @GetMapping("/saluda")
    public String saluda(){
        return "HOLAAA";
    }
    
    @GetMapping("/personas")
    public List<PersonaP> getAll(){
        return repo.findAll();
    }
}
