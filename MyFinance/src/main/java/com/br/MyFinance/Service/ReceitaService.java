package com.br.MyFinance.Service;

import com.br.MyFinance.Dto.Request.ReceitaRequestDto;
import com.br.MyFinance.Dto.Response.ContaBancariaResponseDto;
import com.br.MyFinance.Dto.Response.ReceitaResponseDto;
import com.br.MyFinance.Mapper.ReceitaMapper;
import com.br.MyFinance.Model.ReceitaModel;
import com.br.MyFinance.Repository.ReceitaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;
    @Autowired
    private ReceitaMapper receitaMapper;

    public ReceitaResponseDto criarNovaReceita(ReceitaRequestDto receitaRequestDto){

        if (receitaRequestDto == null){
            throw new RuntimeException("Receita não pode ser vazia");
        }

        ReceitaModel receitaModel = receitaMapper.requestToModel(receitaRequestDto);
        receitaModel.setDataCriacao(LocalDate.now());

        ReceitaModel salvarReceita = receitaRepository.save(receitaModel);
        return receitaMapper.toDto(salvarReceita);
    }

    @Transactional(readOnly = true)
    public List<ReceitaResponseDto> listarReceitaPorUsuario(@Valid long cdUsuario){

        List<ReceitaModel> receitas = receitaRepository.findBycdUsuario(cdUsuario);

        if (receitas.isEmpty()) {
            throw new RuntimeException("Usuário não possui nenhuma receita cadastrada");
        }

        return receitas.stream().map(receitaMapper::toDto).collect(Collectors.toList());
    }

    public ReceitaResponseDto editarReceita(ReceitaRequestDto receitaRequestDto){

        if (receitaRequestDto == null){
            throw new RuntimeException("Receita não pode ser vazia");
        }

        ReceitaModel receitaModel = receitaMapper.requestToModel(receitaRequestDto);

        ReceitaModel salvarReceita = receitaRepository.save(receitaModel);
        return receitaMapper.toDto(salvarReceita);
    }
}
