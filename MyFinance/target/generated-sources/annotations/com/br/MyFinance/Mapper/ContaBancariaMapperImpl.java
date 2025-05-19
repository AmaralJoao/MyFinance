package com.br.MyFinance.Mapper;

import com.br.MyFinance.Dto.Request.ContaBancariaRequestDto;
import com.br.MyFinance.Dto.Response.ContaBancariaResponseDto;
import com.br.MyFinance.Model.ContaBancariaModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-19T00:10:12-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class ContaBancariaMapperImpl implements ContaBancariaMapper {

    @Override
    public ContaBancariaModel requestToModel(ContaBancariaRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        ContaBancariaModel contaBancariaModel = new ContaBancariaModel();

        contaBancariaModel.setNome( dto.getNome() );
        contaBancariaModel.setTipoConta( dto.getTipoConta() );

        return contaBancariaModel;
    }

    @Override
    public ContaBancariaResponseDto toDto(ContaBancariaModel model) {
        if ( model == null ) {
            return null;
        }

        ContaBancariaResponseDto contaBancariaResponseDto = new ContaBancariaResponseDto();

        contaBancariaResponseDto.setTipoConta( model.getTipoConta() );

        return contaBancariaResponseDto;
    }

    @Override
    public void updateModelFromDto(ContaBancariaRequestDto dto, ContaBancariaModel model) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getNome() != null ) {
            model.setNome( dto.getNome() );
        }
        if ( dto.getTipoConta() != null ) {
            model.setTipoConta( dto.getTipoConta() );
        }
    }
}
