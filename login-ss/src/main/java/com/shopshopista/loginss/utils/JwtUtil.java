package com.shopshopista.loginss.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Collections;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

/**
 *
 * @author Johnny
 */
public class JwtUtil {
    public static void addAuthentication(HttpServletResponse res, String username){
        String token = Jwts.builder()
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS512, "123")
                .compact();
        res.addHeader("Autorization", "Bearer: "+token);
    }
    
    public static  Authentication getAuthentication(HttpServletRequest request){
        String token = request.getHeader("Autorization");
        
        if(token != null){
            String user = Jwts.parser()
                    .setSigningKey("123")
                    .parseClaimsJws(token.replace("Bearer", ""))
                    .getBody()
                    .getSubject();
            
            return user != null ?
                    new UsernamePasswordAuthenticationToken(
                            user, 
                            null, 
                            Collections.emptyList()
                    ):
                    null;
        }
        return null;
    }
}
