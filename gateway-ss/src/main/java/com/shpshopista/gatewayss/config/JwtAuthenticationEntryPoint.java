package com.shpshopista.gatewayss.config;

import java.io.IOException;
import java.io.Serializable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author Johnny
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    @Override
    public void commence(
            HttpServletRequest hsr, 
            HttpServletResponse hsr1, 
            AuthenticationException ae
    ) throws IOException, ServletException {
        hsr1.sendError(
                HttpServletResponse.SC_UNAUTHORIZED, 
                "No tiene permiso para este URL"
        );
        
    }
    
}
