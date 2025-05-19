package com.br.MyFinance.Controller;

import com.br.MyFinance.Dto.Request.ContaBancariaRequestDto;
import com.br.MyFinance.Dto.Response.ContaBancariaResponseDto;
import com.br.MyFinance.Model.ContaBancariaModel;
import com.br.MyFinance.Service.ContaBancariaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/contaBancaria")
public class ContaBancariaController {

    @Autowired
    private ContaBancariaService contaBancariaService;

    @PostMapping("criar")
    public ResponseEntity<ContaBancariaResponseDto> criarConta(@RequestBody @Valid ContaBancariaRequestDto contaBancariaRequestDto) {
       ContaBancariaResponseDto novaConta = contaBancariaService.criarContaBancaria(contaBancariaRequestDto);
       return ResponseEntity.ok(novaConta);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ContaBancariaResponseDto> atualizarConta(@RequestBody @Valid ContaBancariaRequestDto contaBancariaRequestDto) {
        ContaBancariaResponseDto atualizarConta = contaBancariaService.editarContaBancaria(contaBancariaRequestDto);
        return ResponseEntity.ok(atualizarConta);
    }


    @GetMapping("/listar")
    public ResponseEntity<List<ContaBancariaResponseDto>> listarContasBancariasPorUsuario(@PathVariable long cdUsuario){

        List<ContaBancariaResponseDto> contas = contaBancariaService.listarContasDoUsuario(cdUsuario);
        return ResponseEntity.ok(contas);
    }
}
