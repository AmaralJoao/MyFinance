package com.br.MyFinance.Mapper;

import com.br.MyFinance.Dto.Request.ReceitaRequestDto;
import com.br.MyFinance.Dto.Request.UsuarioRequestDto;
import com.br.MyFinance.Dto.Response.ReceitaResponseDto;
import com.br.MyFinance.Dto.Response.UsuarioResponseDto;
import com.br.MyFinance.Model.ReceitaModel;
import com.br.MyFinance.Model.UsuarioModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioModel requestToModel(UsuarioRequestDto dto);

    UsuarioResponseDto toDto(UsuarioModel model);

    void updateModelFromDto(UsuarioRequestDto dto, @MappingTarget UsuarioModel model);
}
