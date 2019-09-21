package com.shopshopista.loginss.repository;

import com.shopshopista.loginss.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gus
 */
public interface UserREPO extends JpaRepository<Usuario, Long>{
 Usuario findByUsername(String username);   
}
