package com.shopshopista.loginss.service;

import com.shopshopista.loginss.models.Ciudad;
import com.shopshopista.loginss.models.Usuario;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author gus
 */
public interface GenericService {
    
    Usuario findByUsername(String username);
    
    List<Usuario> buscarTodosUsers();
    
    List<Ciudad> buscarTodasCiudades();
}
