package com.shopshopista.loginss.repository;

import com.shopshopista.loginss.models.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gus
 */
@Repository
public interface CiudadREPO extends JpaRepository<Ciudad, Long>{
    
}
