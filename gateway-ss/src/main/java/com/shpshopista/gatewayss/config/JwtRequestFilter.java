package com.shpshopista.gatewayss.config;

import com.shpshopista.gatewayss.service.JwtUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author Johnny
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUserDetailsService jwtUserDetailService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(
            HttpServletRequest hsr,
            HttpServletResponse hsr1,
            FilterChain fc
    ) throws ServletException, IOException {
        final String requestTokenHeader = hsr.getHeader("Authorization");

        String username = null;
        String jwtToken = null;

        if (requestTokenHeader != null) {
            jwtToken = requestTokenHeader.replace("Bearer", "");
            try {
                username = jwtTokenUtil.getUsernameFromToken(jwtToken);
            } catch (IllegalArgumentException e) {
                System.out.println("No logramos obtener  JWT Token");
            } catch (ExpiredJwtException e) {
                System.out.println("JWT Token ha expirado.");
            }
        } else {
            logger.warn("JWT Token no lo tenemos");
        }

        // Validamos el username 
        if (username != null
                && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.jwtUserDetailService.loadUserByUsername(username);
            
            // Si el token es valido configuramos el Spring security 
            if(jwtTokenUtil.validateToken(jwtToken, userDetails)){
                UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(
                        userDetails, 
                        null,
                        userDetails.getAuthorities()
                );
                upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(hsr));
                
                SecurityContextHolder.getContext().setAuthentication(upat);
            }
        }
        
        fc.doFilter(hsr, hsr1);
    }

}
