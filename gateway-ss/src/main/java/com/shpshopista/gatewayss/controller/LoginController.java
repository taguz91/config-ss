package com.shpshopista.gatewayss.controller;

import com.shpshopista.gatewayss.pojos.LoginRQ;
import com.shpshopista.gatewayss.config.JwtTokenUtil;
import com.shpshopista.gatewayss.pojos.LoginRP;
import com.shpshopista.gatewayss.model.user.Usuario;
import com.shpshopista.gatewayss.repository.IUsuarioREPO;
import com.shpshopista.gatewayss.service.JwtUserDetailsService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class LoginController {

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
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRQ authRequest) throws Exception {
        authenticate(
                authRequest.getUsername(),
                authRequest.getPassword()
        );

        final UserDetails userDetails = userDetailService
                .loadUserByUsername(authRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new LoginRP(token, userRepo.findByUsername(authRequest.getUsername())));
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
