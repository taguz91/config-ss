package com.shopshopista.loginss.filters;

import com.shopshopista.loginss.utils.JwtUtil;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

/**
 *
 * @author Johnny
 */
public class JwtFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        Authentication auth = JwtUtil.getAuthentication((HttpServletRequest) sr);
        
        SecurityContextHolder.getContext().setAuthentication(auth);
        fc.doFilter(sr, sr1);
        
    }

}
