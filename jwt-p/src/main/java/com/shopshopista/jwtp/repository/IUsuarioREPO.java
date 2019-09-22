package com.shopshopista.jwtp.repository;

import com.shopshopista.jwtp.model.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Johnny
 */
public interface IUsuarioREPO extends JpaRepository<Usuario, Long> {
    
    Usuario findByUsername(String username);
    
}
