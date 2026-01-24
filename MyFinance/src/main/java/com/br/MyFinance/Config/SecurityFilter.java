package com.br.MyFinance.Config;

import com.br.MyFinance.Model.LoginModel;
import com.br.MyFinance.Repository.LoginRepository;
import com.br.MyFinance.Service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private LoginRepository loginRepository;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return "OPTIONS".equalsIgnoreCase(request.getMethod());
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);
        var login = tokenService.validarToken(token);

        if (login != null){
            LoginModel usuario = loginRepository.findByLogin(login).orElseThrow(()-> new RuntimeException("erro ao localizar usuario"));
            var authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
            var autenticar = new UsernamePasswordAuthenticationToken(usuario,null, authorities);
            SecurityContextHolder.getContext().setAuthentication(autenticar);
        }

        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request){
        var authHeader = request.getHeader("authorization");

        if (authHeader == null) return null;
        return authHeader.replace("Bearer ","");
    }
}
