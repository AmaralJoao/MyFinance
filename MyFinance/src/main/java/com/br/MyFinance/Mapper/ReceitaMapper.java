package com.br.MyFinance.Mapper;

import com.br.MyFinance.Dto.Request.ContaBancariaRequestDto;
import com.br.MyFinance.Dto.Request.ReceitaRequestDto;
import com.br.MyFinance.Dto.Response.ContaBancariaResponseDto;
import com.br.MyFinance.Dto.Response.ReceitaResponseDto;
import com.br.MyFinance.Model.ContaBancariaModel;
import com.br.MyFinance.Model.ReceitaModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ReceitaMapper {

    ReceitaMapper INSTANCE = Mappers.getMapper(ReceitaMapper.class);

    ReceitaModel requestToModel(ReceitaRequestDto dto);

    ReceitaResponseDto toDto(ReceitaModel model);

    void updateModelFromDto(ReceitaRequestDto dto, @MappingTarget ReceitaModel model);
}
