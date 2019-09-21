package com.shopshopista.loginss.service;

import com.shopshopista.loginss.models.Ciudad;
import com.shopshopista.loginss.models.Usuario;
import java.util.List;

/**
 *
 * @author gus
 */
public interface GenericService {
    
    Usuario buscarPorNombre(String username);
    
    List<Usuario> buscarTodosUsers();
    
    List<Ciudad> buscarTodasCiudades();
}
