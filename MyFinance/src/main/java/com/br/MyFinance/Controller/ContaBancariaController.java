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
@RequestMapping(value = "/api/contaBancaria")
public class ContaBancariaController {

    @Autowired
    private ContaBancariaService contaBancariaService;

    @PostMapping
    public ResponseEntity<Void> criarConta(@RequestBody @Valid ContaBancariaRequestDto contaBancariaRequestDto) {
       return null;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> atualizarConta(@PathVariable Long id,
                                               @RequestBody @Valid ContaBancariaRequestDto contaBancariaRequestDto) {
        return null;
    }


    @GetMapping("/listar")
    public ResponseEntity<List<ContaBancariaResponseDto>> listarContasBancariasPorUsuario(@PathVariable long cdUsuario){

        return null;
    }

    public void editarContaBancaria(@RequestBody @Valid ContaBancariaRequestDto contaBancariaRequestDto){


    }
}
