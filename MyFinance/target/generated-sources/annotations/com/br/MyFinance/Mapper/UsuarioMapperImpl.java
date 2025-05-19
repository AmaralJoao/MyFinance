package com.br.MyFinance.Mapper;

import com.br.MyFinance.Dto.Request.UsuarioRequestDto;
import com.br.MyFinance.Dto.Response.UsuarioResponseDto;
import com.br.MyFinance.Model.UsuarioModel;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-19T18:24:37-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioModel requestToModel(UsuarioRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setDataDeNascimento( dto.getDataDeNascimento() );
        usuarioModel.setSenha( dto.getSenha() );
        usuarioModel.setUsuario( dto.getUsuario() );
        usuarioModel.setNomeDoUsuario( dto.getNomeDoUsuario() );
        usuarioModel.setEmail( dto.getEmail() );

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

        model.setDataDeNascimento( dto.getDataDeNascimento() );
        model.setSenha( dto.getSenha() );
        model.setUsuario( dto.getUsuario() );
        model.setNomeDoUsuario( dto.getNomeDoUsuario() );
        model.setEmail( dto.getEmail() );
    }
}
