package com.br.MyFinance.Mapper;

import com.br.MyFinance.Dto.Request.UsuarioRequestDto;
import com.br.MyFinance.Dto.Response.UsuarioResponseDto;
import com.br.MyFinance.Model.UsuarioModel;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-20T21:16:37-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioModel requestToModel(UsuarioRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setNomeDoUsuario( dto.getNomeDoUsuario() );
        usuarioModel.setEmail( dto.getEmail() );
        usuarioModel.setUsuario( dto.getUsuario() );
        usuarioModel.setSenha( dto.getSenha() );
        usuarioModel.setDataDeNascimento( dto.getDataDeNascimento() );

        return usuarioModel;
    }

    @Override
    public UsuarioResponseDto toDto(UsuarioModel model) {
        if ( model == null ) {
            return null;
        }

        String usuario = null;
        String email = null;

        usuario = model.getUsuario();
        email = model.getEmail();

        String usuarioId = null;
        String token = null;

        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto( usuarioId, usuario, email, token );

        return usuarioResponseDto;
    }

    @Override
    public void updateModelFromDto(UsuarioRequestDto dto, UsuarioModel model) {
        if ( dto == null ) {
            return;
        }

        model.setNomeDoUsuario( dto.getNomeDoUsuario() );
        model.setEmail( dto.getEmail() );
        model.setUsuario( dto.getUsuario() );
        model.setSenha( dto.getSenha() );
        model.setDataDeNascimento( dto.getDataDeNascimento() );
    }
}
