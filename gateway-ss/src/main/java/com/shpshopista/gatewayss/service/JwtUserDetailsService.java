package com.shpshopista.gatewayss.service;

import com.shpshopista.gatewayss.model.user.Usuario;
import com.shpshopista.gatewayss.repository.IUsuarioREPO;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Johnny
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private IUsuarioREPO userRepo;

    @Autowired
    private PasswordEncoder bCryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Usuario: javainuse 
        // Password: password
        /*
        if ("javainuse".equals(username)) {
            return new User(
                    "javainuse",
                    "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>()
            );
        } else {
            throw new UsernameNotFoundException(
                    "Usuario no encontrao con el nombre: "
                    + username
            );
        }*/

        Usuario user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(
                    "Usuario no encontrao: "
                    + username
            );
        }
        
        /*System.out.println("Numero de roles: " + user.getRoles().size());
        user.getRoles().forEach(r -> {
            System.out.println("ROL: " + r.getRol().getRol_nombre());
        });*/

        return new User(
                user.getUsername(),
                user.getPassword(),
                new ArrayList<>()
        );
    }

    public Usuario save(Usuario user) {
        user.setPassword(
                bCryptEncoder.encode(user.getPassword())
        );

        return userRepo.save(user);
    }

}
