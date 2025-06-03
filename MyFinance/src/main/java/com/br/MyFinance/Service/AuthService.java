package com.br.MyFinance.Service;

import com.br.MyFinance.Config.JwtTokenFilter;
import com.br.MyFinance.Config.JwtTokenProvider;
import com.br.MyFinance.Dto.Request.AccountCredenctialRequestDto;
import com.br.MyFinance.Dto.Response.TokenResponseDto;
import com.br.MyFinance.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<TokenResponseDto> signIn(AccountCredenctialRequestDto credentials){

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                credentials.getNomeDeusuario(),
                credentials.getSenha()
        ));

        var user = usuarioRepository.findByNomeDeUsuario(credentials.getNomeDeusuario());

        if (user == null) {
            throw new UsernameNotFoundException("Nome de usuario não localizado");
        }

        var tokenResponse = jwtTokenProvider.criarTokenDeAcesso(credentials.getNomeDeusuario(), user.getRoles());

        return ResponseEntity.ok(tokenResponse);
    }

}
