package com.shopshopista.oauthprueba.repository;

import com.shopshopista.oauthprueba.models.PersonaP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gus
 */
@Repository
public interface PersonaREPO extends JpaRepository<PersonaP, Integer>{
    
}
