package com.shopshopista.oauthprueba.repository;

import com.shopshopista.oauthprueba.models.UsuarioP;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gus
 */
public interface UsuarioREPO extends JpaRepository<UsuarioP, Integer>{
    
    UsuarioP findByUsername(String username);
}
