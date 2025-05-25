package com.br.MyFinance.Mapper;

import com.br.MyFinance.Dto.Request.UsuarioRequestDto;
import com.br.MyFinance.Dto.Response.UsuarioResponseDto;
import com.br.MyFinance.Model.UsuarioModel;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-21T17:23:08-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioModel requestToModel(UsuarioRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        UsuarioModel usuarioModel = new UsuarioModel();

        return usuarioModel;
    }

    @Override
    public UsuarioResponseDto toDto(UsuarioModel model) {
        if ( model == null ) {
            return null;
        }

        String usuarioId = null;
        String usuario = null;
        String email = null;
        String token = null;

        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto( usuarioId, usuario, email, token );

        return usuarioResponseDto;
    }

    @Override
    public void updateModelFromDto(UsuarioRequestDto dto, UsuarioModel model) {
        if ( dto == null ) {
            return;
        }
    }
}
