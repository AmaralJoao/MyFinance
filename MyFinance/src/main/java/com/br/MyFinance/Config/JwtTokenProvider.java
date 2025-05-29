package com.br.MyFinance.Config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.br.MyFinance.Dto.Response.TokenResponseDto;
import com.br.MyFinance.Model.UsuarioPermissaoModel;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.Servlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long validityInMilliseconds;

    @Autowired
    private UserDetailsService userDetailsService;

    Algorithm algorithm = null;

    @PostConstruct
    protected void init(){
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
        algorithm = Algorithm.HMAC256(secret.getBytes());

    }

    public TokenResponseDto criarTokenDeAcesso(String nomeDeUsuario, List<String> permissoes){

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);
        String acessToken = getTokenDeAcesso(nomeDeUsuario, permissoes, now, validity);
        String refreshToken = getAtualizarToken(nomeDeUsuario, permissoes, now);
        return new TokenResponseDto(nomeDeUsuario, true, now, validity, acessToken, refreshToken);
    }

    private String getAtualizarToken(String nomeDeUsuario, List<String> permissoes, Date now) {
        String issueUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        return JWT.create().withClaim("roles", permissoes).toString();
    }

    private String getTokenDeAcesso(String nomeDeUsuario, List<String> permissoes, Date now, Date validity) {
        return "";
    }
}
