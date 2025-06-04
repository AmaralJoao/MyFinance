package com.br.MyFinance.Mapper;

import com.br.MyFinance.Dto.Request.UsuarioRequestDto;
import com.br.MyFinance.Dto.Response.UsuarioResponseDto;
import com.br.MyFinance.Model.DadosUsuarioModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DadosUsuarioMapper {

        /*DadosUsuarioMapper INSTANCE = Mappers.getMapper(DadosUsuarioMapper.class);

        DadosUsuarioModel requestToModel(UsuarioRequestDto dto);

        UsuarioResponseDto toDto(DadosUsuarioModel model);

        void updateModelFromDto(UsuarioRequestDto dto, @MappingTarget DadosUsuarioModel model);*/
}
