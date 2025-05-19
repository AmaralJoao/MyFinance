package com.br.MyFinance.Service;

import com.br.MyFinance.Dto.Request.DespesaRequestDto;
import com.br.MyFinance.Dto.Request.ReceitaRequestDto;
import com.br.MyFinance.Dto.Response.DespesaResponseDto;
import com.br.MyFinance.Dto.Response.ReceitaResponseDto;
import com.br.MyFinance.Mapper.DespesaMapper;
import com.br.MyFinance.Mapper.ReceitaMapper;
import com.br.MyFinance.Model.DespesaModel;
import com.br.MyFinance.Model.ReceitaModel;
import com.br.MyFinance.Repository.DespesaRepository;
import com.br.MyFinance.Repository.ReceitaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;
    @Autowired
    private DespesaMapper receitaMapper;

    public DespesaResponseDto criarNovaReceita(DespesaRequestDto despesaRequestDto){

        if (despesaRequestDto == null){
            throw new RuntimeException("Despesa não pode ser vazia");
        }

        DespesaModel despesaModel = receitaMapper.requestToModel(despesaRequestDto);
        despesaModel.setData(LocalDate.now());

        DespesaModel salvarDespesa = despesaRepository.save(despesaModel);
        return receitaMapper.toDto(salvarDespesa);
    }

    @Transactional(readOnly = true)
    public List<DespesaResponseDto> listarReceitaPorUsuario(@Valid long cdUsuario){

        List<DespesaModel> despesas = despesaRepository.findByUsuarioId(cdUsuario);

        if (despesas.isEmpty()) {
            throw new RuntimeException("Usuário não possui nenhuma Despesa cadastrada");
        }

        return despesas.stream().map(receitaMapper::toDto).collect(Collectors.toList());
    }

    public DespesaResponseDto editarReceita(DespesaRequestDto despesaRequestDto){

        if (despesaRequestDto == null){
            throw new RuntimeException("Despesa não pode ser vazia");
        }

        DespesaModel despesaModel = receitaMapper.requestToModel(despesaRequestDto);

        DespesaModel salvarDespesa = despesaRepository.save(despesaModel);
        return receitaMapper.toDto(salvarDespesa);
    }
}
