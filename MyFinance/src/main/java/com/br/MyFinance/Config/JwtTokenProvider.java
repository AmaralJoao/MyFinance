package com.br.MyFinance.Config;

import ch.qos.logback.core.util.StringUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.br.MyFinance.Dto.Response.TokenResponseDto;
import com.br.MyFinance.Exception.InvalidJwtAuthenticationException;
import com.br.MyFinance.Model.UsuarioPermissaoModel;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.Servlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
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
        Date refreshTokenValidity = new Date(now.getTime() + (validityInMilliseconds * 3));
        return JWT.create().withClaim("roles", permissoes).withIssuedAt(now).withExpiresAt(refreshTokenValidity).withSubject(nomeDeUsuario).sign(algorithm);
    }

    private String getTokenDeAcesso(String nomeDeUsuario, List<String> permissoes, Date now, Date validity) {
        String issueUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        return JWT.create().withClaim("roles", permissoes).withIssuedAt(now).withExpiresAt(validity).withSubject(nomeDeUsuario).withIssuer(issueUrl).sign(algorithm);
    }

    public Authentication getAuthentication(String token){
        DecodedJWT decodedJWT = decodedJWT(token);
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(decodedJWT.getSubject());

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

     private DecodedJWT decodedJWT (String token){
        Algorithm alg = Algorithm.HMAC256(secret.getBytes());
        JWTVerifier verifier = JWT.require(alg).build();
         return verifier.verify(token);
     }

     public String resolveToken(HttpServletRequest request) throws InvalidJwtAuthenticationException {
        String bearerToken = request.getHeader("Authorization");

        if (StringUtils.isEmpty(bearerToken) && bearerToken.startsWith("Bearer ")){
          return bearerToken.substring("Bearer ".length());
         }else {
            throw new InvalidJwtAuthenticationException("invalid JWT Token");
        }
     }

    public boolean validateToken(String token) throws InvalidJwtAuthenticationException {
        DecodedJWT decodedJWT = decodedJWT(token);
        try {
            if(decodedJWT.getExpiresAt().before(new Date())) {
                return false;
            }
            return true;
        } catch (Exception e) {
            throw new InvalidJwtAuthenticationException("Expired or Invalid JWT Token!");
        }
    }
}
