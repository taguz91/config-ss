package com.shopshopista.oauthprueba.services;

import com.shopshopista.oauthprueba.models.UsuarioP;
import com.shopshopista.oauthprueba.repository.UsuarioREPO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author gus
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UsuarioREPO repo;
    
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        UsuarioP u = repo.findByUsername(string);
        // Roles
        List<GrantedAuthority> a = new ArrayList<>();
        a.add(new SimpleGrantedAuthority("ADMIN"));
        
        UserDetails ud = new User(
                u.getUsername(), 
                u.getPassword(), 
                a
        );
        return ud;
    }
    
}
