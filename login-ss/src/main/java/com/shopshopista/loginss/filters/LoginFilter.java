package com.shopshopista.loginss.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopshopista.loginss.pojo.Usuario;
import com.shopshopista.loginss.utils.JwtUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author Johnny
 */
public class LoginFilter extends AbstractAuthenticationProcessingFilter {

    public LoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest hsr, HttpServletResponse hsr1) throws AuthenticationException, IOException, ServletException {
        System.out.println("BUSCANDOOOOO USUARIOOOO");
        InputStream body = hsr.getInputStream();
        String result = convertInputStreamToString(body);
        System.out.println("Resultado: "+result);
        System.out.println("HEADERS: "+hsr.getContentType());
        System.out.println("Metodo: "+hsr.getMethod());
        System.out.println("Auth: " + hsr.getAuthType());
        System.out.println("----------------------------");
        if(result.isEmpty()){
            return null;
        }
        Usuario user = new ObjectMapper().readValue(body, Usuario.class);

        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPass(),
                        Collections.emptyList()
                )
        );
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }

        return result.toString(StandardCharsets.UTF_8.name());

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        JwtUtil.addAuthentication(response, authResult.getName());
    }

}
