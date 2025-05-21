package com.br.MyFinance.Mapper;

import com.br.MyFinance.Dto.Request.DespesaRequestDto;
import com.br.MyFinance.Dto.Response.DespesaResponseDto;
import com.br.MyFinance.Model.DespesaModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-20T21:16:37-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class DespesaMapperImpl implements DespesaMapper {

    @Override
    public DespesaModel requestToModel(DespesaRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        DespesaModel despesaModel = new DespesaModel();

        despesaModel.setValor( dto.getValor() );
        despesaModel.setData( dto.getData() );
        if ( dto.getRepetir() != null ) {
            despesaModel.setRepetir( Boolean.parseBoolean( dto.getRepetir() ) );
        }

        return despesaModel;
    }

    @Override
    public DespesaResponseDto toDto(DespesaModel model) {
        if ( model == null ) {
            return null;
        }

        DespesaResponseDto despesaResponseDto = new DespesaResponseDto();

        despesaResponseDto.setDescricao( model.getDescricao() );
        despesaResponseDto.setValor( model.getValor() );
        despesaResponseDto.setData( model.getData() );
        if ( model.getRepetir() != null ) {
            despesaResponseDto.setRepetir( String.valueOf( model.getRepetir() ) );
        }

        return despesaResponseDto;
    }

    @Override
    public void updateModelFromDto(DespesaRequestDto dto, DespesaModel model) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getValor() != null ) {
            model.setValor( dto.getValor() );
        }
        if ( dto.getData() != null ) {
            model.setData( dto.getData() );
        }
        if ( dto.getRepetir() != null ) {
            model.setRepetir( Boolean.parseBoolean( dto.getRepetir() ) );
        }
    }
}
