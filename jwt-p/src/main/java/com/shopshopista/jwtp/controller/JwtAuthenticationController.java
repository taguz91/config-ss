package com.shopshopista.jwtp.controller;

import com.shopshopista.jwtp.config.JwtTokenUtil;
import com.shopshopista.jwtp.model.JwtRequest;
import com.shopshopista.jwtp.model.JwtResponse;
import com.shopshopista.jwtp.model.user.Usuario;
import com.shopshopista.jwtp.repository.IUsuarioREPO;
import com.shopshopista.jwtp.service.JwtUserDetailsService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Johnny
 */
@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private IUsuarioREPO userRepo;

    @Autowired
    private AuthenticationManager auth;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @CrossOrigin
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authRequest) throws Exception {
        authenticate(
                authRequest.getUsername(),
                authRequest.getPassword()
        );

        final UserDetails userDetails = userDetailService
                .loadUserByUsername(authRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token, userRepo.findByUsername(authRequest.getUsername())));
    }

    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    public ResponseEntity<?> guardarUsuario(@Valid @RequestBody Usuario user) throws Exception {
        return ResponseEntity.ok(userDetailService.save(user));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            auth.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
