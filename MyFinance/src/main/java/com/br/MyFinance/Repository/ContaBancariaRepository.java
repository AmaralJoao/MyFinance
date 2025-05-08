package com.br.MyFinance.Repository;

import com.br.MyFinance.Dto.Response.ContaBancariaResponseDto;
import com.br.MyFinance.Model.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContaBancariaRepository extends JpaRepository<ContaBancariaResponseDto, Long> {
    Optional<List<ContaBancaria>>findBycdUsuario(long cdUsuario);
}
