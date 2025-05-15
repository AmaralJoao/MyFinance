package com.br.MyFinance.Service;

import com.br.MyFinance.Dto.Request.ReceitaRequestDto;
import com.br.MyFinance.Dto.Response.ContaBancariaResponseDto;
import com.br.MyFinance.Dto.Response.ReceitaResponseDto;
import com.br.MyFinance.Repository.ReceitaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;


    public List<ReceitaResponseDto> listarReceitaPorUsuario(@Valid long cdUsuario){

        return receitaRepository.findBycdUsuario(cdUsuario)
                .orElse(List.of()).stream()
                .map(ReceitaResponseDto::new)
                .collect(Collectors.toList());

    }
}
