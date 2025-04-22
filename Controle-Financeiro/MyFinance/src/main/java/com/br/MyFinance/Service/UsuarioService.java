package com.br.MyFinance.Service;

import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import com.br.MyFinance.Model.UsuarioModel;
import com.br.MyFinance.Repository.UsuarioRepository;

@ApplicationScoped
public class UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;

    public Optional<UsuarioModel> autenticar(String nomeUsuario, String senha) {
        Optional<UsuarioModel> usuarioOptional = usuarioRepository.buscarUsuarioPorNomeUsuario(nomeUsuario);

        if (usuarioOptional.isPresent() && usuarioOptional.get().getSenha().equals(senha)) {
            return usuarioOptional;
        }

        return Optional.empty();
    }
}