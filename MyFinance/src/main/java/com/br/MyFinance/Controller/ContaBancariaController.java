package com.br.MyFinance.Controller;

import com.br.MyFinance.Dto.Request.ContaBancariaRequestDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/contaBancaria")
public class ContaBancariaController {

    @Autowired
    private ContaBancariaService contaBancariaService;

    public void criarContaBancaria(@RequestBody @Valid ContaBancariaRequestDto contaBancariaResponseDto){


    }
}
