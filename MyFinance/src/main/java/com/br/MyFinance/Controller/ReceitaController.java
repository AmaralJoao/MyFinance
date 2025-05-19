package com.br.MyFinance.Controller;

import com.br.MyFinance.Dto.Request.ReceitaRequestDto;
import com.br.MyFinance.Dto.Response.ContaBancariaResponseDto;
import com.br.MyFinance.Dto.Response.ReceitaResponseDto;
import com.br.MyFinance.Service.ReceitaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @PostMapping("/nova")
    public ResponseEntity<ReceitaResponseDto> criarReceita(@RequestBody @Valid ReceitaRequestDto receitaRequestDto){
        ReceitaResponseDto novaReceita = receitaService.criarNovaReceita(receitaRequestDto);
        return ResponseEntity.ok(novaReceita);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ReceitaResponseDto>> listarReceitasDoUsuario(@PathVariable @Valid long cdUsuario){
        List<ReceitaResponseDto> receitaResponseDto = receitaService.listarReceitaPorUsuario(cdUsuario);
        return ResponseEntity.ok(receitaResponseDto);
    }

    @PutMapping("/editar")
    public ResponseEntity<ReceitaResponseDto> editarReceita(@RequestBody @Valid ReceitaRequestDto receitaRequestDto){
        ReceitaResponseDto editarReceita = receitaService.editarReceita(receitaRequestDto);
        return ResponseEntity.ok(editarReceita);
    }
}
