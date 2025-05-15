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
        ContaBancariaModel contaSalva = contaBancariaService.criarContaBancaria(contaBancariaRequestDto);
        return ResponseEntity.created(URI.create("/api/contaBancaria/" + contaSalva.getId())).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> atualizarConta(@PathVariable Long id,
                                               @RequestBody @Valid ContaBancariaRequestDto contaBancariaRequestDto) {
        if (!id.equals(contaBancariaRequestDto.getCdContaBancaria())) {
            throw new IllegalArgumentException("ID do path não corresponde ao ID do DTO");
        }

        contaBancariaService.editarContaBancaria(contaBancariaRequestDto);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/listar")
    public ResponseEntity<List<ContaBancariaResponseDto>> listarContasBancariasPorUsuario(@PathVariable long cdUsuario){

        List<ContaBancariaResponseDto> contaBancaria = contaBancariaService.listarContasDoUsuario(cdUsuario);

        return ResponseEntity.ok(contaBancaria);
    }

    public void editarContaBancaria(@RequestBody @Valid ContaBancariaRequestDto contaBancariaRequestDto){

        contaBancariaService.editarContaBancaria(contaBancariaRequestDto);
    }
}
