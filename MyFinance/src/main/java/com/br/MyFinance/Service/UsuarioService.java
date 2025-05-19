package com.br.MyFinance.Service;

import com.br.MyFinance.Config.JwtTokenProvider;
import com.br.MyFinance.Dto.Request.UsuarioRequestDto;
import com.br.MyFinance.Dto.Response.UsuarioResponseDto;
import com.br.MyFinance.Exception.EmailJaExistenteException;
import com.br.MyFinance.Model.UsuarioModel;
import com.br.MyFinance.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public UsuarioResponseDto cadastrar(UsuarioRequestDto usuarioRequestDto){

        usuarioRepository.findByEmail(usuarioRequestDto.getEmail()).ifPresent(u ->{
            throw new EmailJaExistenteException("Email já cadastrado");
        });

        String senhaCriptografada = passwordEncoder.encode(usuarioRequestDto.getSenha());

        UsuarioModel usuario = new UsuarioModel();
        usuario.setNomeDoUsuario(usuarioRequestDto.getNomeDoUsuario());
        usuario.setUsuario(usuarioRequestDto.getUsuario());
        usuario.setEmail(usuarioRequestDto.getEmail());
        usuario.setSenha(senhaCriptografada);
        usuario.setDataDeNascimento(usuarioRequestDto.getDataDeNascimento());

        usuarioRepository.save(usuario);

        return null;
    }

    public UsuarioResponseDto logar(UsuarioRequestDto usuarioRequestDto) {
        UsuarioModel usuario = usuarioRepository.findByEmail(usuarioRequestDto.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        boolean senhaValida = passwordEncoder.matches(usuarioRequestDto.getSenha(), usuario.getSenha());

        if (!senhaValida) {
            throw new BadCredentialsException("Credenciais inválidas");
        }

        String token = jwtTokenProvider.gerarToken(usuario);

        return new UsuarioResponseDto(
                usuario.getId().toString(),
                usuario.getUsuario(),
                usuario.getEmail(),
                token
        );
    }
}
