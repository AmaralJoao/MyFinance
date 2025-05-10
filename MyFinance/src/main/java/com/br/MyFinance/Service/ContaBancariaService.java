package com.br.MyFinance.Service;

import com.br.MyFinance.Dto.Request.ContaBancariaRequestDto;
import com.br.MyFinance.Dto.Response.ContaBancariaResponseDto;
import com.br.MyFinance.Model.ContaBancaria;
import com.br.MyFinance.Repository.ContaBancariaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContaBancariaService {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    public List<ContaBancariaResponseDto> listarContasDoPorUsuario(@Valid long cdUsuario) {

        return contaBancariaRepository.findBycdUsuario(cdUsuario)
                .orElse(List.of())
                .stream()
                .map(conta -> new ContaBancariaResponseDto(conta)).collect(Collectors.toList());

    }

    public void criarContaBancaria(@Valid ContaBancariaRequestDto contaBancariaRequestDto) {
    }

    public void editarContaBancaria(@Valid ContaBancariaRequestDto contaBancariaRequestDto) {
    }
}
