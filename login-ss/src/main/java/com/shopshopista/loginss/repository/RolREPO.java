package com.shopshopista.loginss.repository;

import com.shopshopista.loginss.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gus
 */
@Repository
public interface RolREPO extends JpaRepository<Rol, Long>{
    
    
}
