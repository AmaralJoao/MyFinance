package com.br.MyFinance.Mapper;

import com.br.MyFinance.Dto.Request.ReceitaRequestDto;
import com.br.MyFinance.Dto.Response.ReceitaResponseDto;
import com.br.MyFinance.Model.ReceitaModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-19T18:24:37-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class ReceitaMapperImpl implements ReceitaMapper {

    @Override
    public ReceitaModel requestToModel(ReceitaRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        ReceitaModel receitaModel = new ReceitaModel();

        receitaModel.setTipoRenda( dto.getTipoRenda() );
        receitaModel.setDescricao( dto.getDescricao() );
        receitaModel.setValor( dto.getValor() );
        receitaModel.setData( dto.getData() );
        receitaModel.setObservacao( dto.getObservacao() );
        receitaModel.setRepetir( dto.getRepetir() );

        return receitaModel;
    }

    @Override
    public ReceitaResponseDto toDto(ReceitaModel model) {
        if ( model == null ) {
            return null;
        }

        ReceitaResponseDto receitaResponseDto = new ReceitaResponseDto();

        receitaResponseDto.setTipoRenda( model.getTipoRenda() );
        receitaResponseDto.setDescricao( model.getDescricao() );
        receitaResponseDto.setValor( model.getValor() );
        receitaResponseDto.setData( model.getData() );
        receitaResponseDto.setObservacao( model.getObservacao() );
        receitaResponseDto.setRepetir( model.getRepetir() );

        return receitaResponseDto;
    }

    @Override
    public void updateModelFromDto(ReceitaRequestDto dto, ReceitaModel model) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getTipoRenda() != null ) {
            model.setTipoRenda( dto.getTipoRenda() );
        }
        if ( dto.getDescricao() != null ) {
            model.setDescricao( dto.getDescricao() );
        }
        if ( dto.getValor() != null ) {
            model.setValor( dto.getValor() );
        }
        if ( dto.getData() != null ) {
            model.setData( dto.getData() );
        }
        if ( dto.getObservacao() != null ) {
            model.setObservacao( dto.getObservacao() );
        }
        if ( dto.getRepetir() != null ) {
            model.setRepetir( dto.getRepetir() );
        }
    }
}
