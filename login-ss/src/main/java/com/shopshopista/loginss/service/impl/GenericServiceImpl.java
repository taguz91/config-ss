package com.shopshopista.loginss.service.impl;

import com.shopshopista.loginss.models.Ciudad;
import com.shopshopista.loginss.models.Usuario;
import com.shopshopista.loginss.repository.CiudadREPO;
import com.shopshopista.loginss.repository.UserREPO;
import com.shopshopista.loginss.service.GenericService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gus
 */
@Service
public class GenericServiceImpl implements GenericService {
    
    @Autowired
    private UserREPO userRepo;
    
    @Autowired
    private CiudadREPO ciudadRepo;

    @Override
    public List<Usuario> buscarTodosUsers() {
        return (List<Usuario>)userRepo.findAll();
    }

    @Override
    public List<Ciudad> buscarTodasCiudades() {
        return (List<Ciudad>)ciudadRepo.findAll();
    }

    @Override
    public Usuario findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
    
    
    
}
