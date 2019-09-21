package com.shopshopista.loginss.service.impl;

import com.shopshopista.loginss.models.Usuario;
import com.shopshopista.loginss.repository.UserREPO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 *
 * @author gus
 */
@Component
public class UserService implements UserDetailsService {
    
    @Autowired
    private UserREPO userRepo;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Usuario u =  userRepo.findByUsername(name);
        
        if(u == null){
            throw new UsernameNotFoundException(String.format("No existe el usuario: %s", name));
        }
        
        List<GrantedAuthority> a = new ArrayList<>();
        u.getRoles().forEach(r -> {
            a.add(new SimpleGrantedAuthority(r.getRol().getRol_nombre()));
        });
        
        UserDetails ud = new org.springframework.security.core.userdetails.User(
                u.getUsername(), 
                u.getPass(), 
                a
        );
        
        return ud;
    }
    
}
