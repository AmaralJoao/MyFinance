package com.br.MyFinance.Service;

import com.br.MyFinance.Dto.Request.UsuarioRequestDto;
import com.br.MyFinance.Dto.Response.UsuarioResponseDto;
import com.br.MyFinance.Exception.EmailJaExistenteException;
import com.br.MyFinance.Model.UsuarioModel;
import com.br.MyFinance.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoderor;

    public UsuarioResponseDto cadastrar(UsuarioRequestDto usuarioRequestDto){

        usuarioRepository.findByEmail(usuarioRequestDto.getEmail()).ifPresent(u ->{
            throw new EmailJaExistenteException("Email já cadastrado");
        });

        String senhaCriptografada = passwordEncoderor.encode(usuarioRequestDto.getSenha());

        UsuarioModel usuario = new UsuarioModel();
        usuario.setNomeDoUsuario(usuarioRequestDto.getNomeDoUsuario());
        usuario.setUsuario(usuarioRequestDto.getUsuario());
        usuario.setEmail(usuarioRequestDto.getEmail());
        usuario.setSenha(senhaCriptografada);
        usuario.setDataDeNascimento(usuarioRequestDto.getDataDeNascimento());

        usuarioRepository.save(usuario);

        return null;
    }
}
