package com.shopshopista.loginss.repository;

import com.shopshopista.loginss.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gus
 */
@Repository("UserRepo")
public interface UserREPO extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
}
