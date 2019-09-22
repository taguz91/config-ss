package com.shopshopista.loginss.service;

import com.shopshopista.loginss.models.Usuario;
import com.shopshopista.loginss.repository.UserREPO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Johnny
 */
@Service("UsuarioService")
public class UsuarioService implements UserDetailsService {
    
    @Autowired
    @Qualifier("UserRepo")
    private UserREPO repo; 

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = repo.findByUsername(username);
        
        // Todos los permisos 
        List<GrantedAuthority> a = new ArrayList<>();
        u.getRoles().forEach(r -> {
            a.add(new SimpleGrantedAuthority(r.getRol().getRol_nombre()));
        });
        
        return new User(
                u.getUsername(),
                u.getPass(),
                a
        );
    }
}
