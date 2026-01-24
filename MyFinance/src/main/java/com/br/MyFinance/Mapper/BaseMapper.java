package com.br.MyFinance.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BaseMapper<REQ, RESP, MODEL> {

    MODEL requestToModel(REQ request);

    RESP toDto(MODEL model);

    void updateModelFromDto(REQ request, @MappingTarget MODEL model);
}
