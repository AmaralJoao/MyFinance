package com.br.MyFinance.Mapper;

import com.br.MyFinance.Dto.Request.DespesaRequestDto;
import com.br.MyFinance.Dto.Request.ReceitaRequestDto;
import com.br.MyFinance.Dto.Response.DespesaResponseDto;
import com.br.MyFinance.Dto.Response.ReceitaResponseDto;
import com.br.MyFinance.Model.DespesaModel;
import com.br.MyFinance.Model.ReceitaModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DespesaMapper {

    DespesaMapper INSTANCE = Mappers.getMapper(DespesaMapper.class);

    DespesaModel requestToModel(DespesaRequestDto dto);

    DespesaResponseDto toDto(DespesaModel model);

    void updateModelFromDto(DespesaRequestDto dto, @MappingTarget DespesaModel model);
}
