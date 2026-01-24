package com.br.MyFinance.Service;

import com.br.MyFinance.Dto.Request.DespesaRequestDto;
import com.br.MyFinance.Dto.Response.DespesaResponseDto;
import com.br.MyFinance.Mapper.BaseMapper;
import com.br.MyFinance.Mapper.DespesaMapper;
import com.br.MyFinance.Model.DespesaModel;
import com.br.MyFinance.Repository.BaseRepository;
import com.br.MyFinance.Repository.DespesaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DespesaService extends BaseService<DespesaRequestDto,DespesaResponseDto,DespesaModel,Long>{

    @Autowired
    private DespesaRepository despesaRepository;

    public DespesaService(BaseRepository<DespesaModel, Long> repository, BaseMapper<DespesaRequestDto, DespesaResponseDto, DespesaModel> mapper) {
        super(repository, mapper);
    }

    @Transactional(readOnly = true)
    public List<DespesaResponseDto> listarReceitaPorUsuario(@Valid long cdUsuario){

        List<DespesaModel> despesas = despesaRepository.findByUsuarioId(cdUsuario);

        if (despesas.isEmpty()) {
            throw new RuntimeException("Usuário não possui nenhuma Despesa cadastrada");
        }

        return despesas.stream().map(this.mapper::toDto).collect(Collectors.toList());
    }

    public DespesaResponseDto editarReceita(DespesaRequestDto despesaRequestDto){

        if (this.validaSeNull(despesaRequestDto)){
            throw new RuntimeException("Despesa não pode ser vazia");
        }

        DespesaModel despesaModel = this.requestToModel(despesaRequestDto);
        return this.ModeltoResponse(despesaRepository.save(despesaModel));
    }
}
