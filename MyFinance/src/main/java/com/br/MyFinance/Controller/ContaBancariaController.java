package com.br.MyFinance.Controller;

import com.br.MyFinance.Dto.Request.ContaBancariaRequestDto;
import com.br.MyFinance.Dto.Response.ContaBancariaResponseDto;
import com.br.MyFinance.Service.ContaBancariaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/contaBancaria")
public class ContaBancariaController {

    @Autowired
    private ContaBancariaService contaBancariaService;

    @PostMapping("/criarCOnta")
    public void criarContaBancaria(@RequestBody @Valid ContaBancariaRequestDto contaBancariaRequestDto){

        contaBancariaService.criarContaBancaria(contaBancariaRequestDto);
    }


    @GetMapping("/listar")
    public ResponseEntity<List<ContaBancariaResponseDto>> listarContasBancarias(@PathVariable long cdUsuario){

        List<ContaBancariaResponseDto> contaBancaria = contaBancariaService.listarContasDoPorUsuario(cdUsuario);

        return ResponseEntity.ok(contaBancaria);
    }

    public void editarContaBancaria(@RequestBody @Valid ContaBancariaRequestDto contaBancariaRequestDto){

        contaBancariaService.editarContaBancaria(contaBancariaRequestDto);
    }
}
