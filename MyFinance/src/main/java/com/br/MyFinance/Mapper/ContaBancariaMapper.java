package com.br.MyFinance.Mapper;

import com.br.MyFinance.Dto.Request.ContaBancariaRequestDto;
import com.br.MyFinance.Dto.Response.ContaBancariaResponseDto;
import com.br.MyFinance.Model.ContaBancariaModel;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ContaBancariaMapper {

    ContaBancariaMapper INSTANCE = Mappers.getMapper(ContaBancariaMapper.class);

    ContaBancariaModel requestToModel(ContaBancariaRequestDto dto);

    ContaBancariaResponseDto toDto(ContaBancariaModel model);

    void updateModelFromDto(ContaBancariaRequestDto dto, @MappingTarget ContaBancariaModel model);
}
