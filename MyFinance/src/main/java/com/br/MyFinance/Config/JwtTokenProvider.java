package com.br.MyFinance.Config;

import com.br.MyFinance.Model.UsuarioModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expirationInMs;

    public String gerarToken(UsuarioModel usuario) {
        Date agora = new Date();
        Date expiracao = new Date(agora.getTime() + expirationInMs);

        return Jwts.builder()
                .setSubject(usuario.getCdUsuario().toString())
                .claim("usuario", usuario.getUsuario())
                .claim("email", usuario.getEmail())
                .setIssuedAt(agora)
                .setExpiration(expiracao)
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }
}
