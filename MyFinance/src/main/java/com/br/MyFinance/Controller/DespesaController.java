package com.br.MyFinance.Controller;

import com.br.MyFinance.Dto.Request.DespesaRequestDto;
import com.br.MyFinance.Dto.Request.ReceitaRequestDto;
import com.br.MyFinance.Dto.Response.DespesaResponseDto;
import com.br.MyFinance.Dto.Response.ReceitaResponseDto;
import com.br.MyFinance.Service.DespesaService;
import com.br.MyFinance.Service.ReceitaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/despesas")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @PostMapping("/nova")
    public ResponseEntity<DespesaResponseDto> criarReceita(@RequestBody @Valid DespesaRequestDto despesaRequestDto){
        DespesaResponseDto novaDespesa = despesaService.criarNovaReceita(despesaRequestDto);
        return ResponseEntity.ok(novaDespesa);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<DespesaResponseDto>> listarReceitasDoUsuario(@PathVariable @Valid long cdUsuario){
        List<DespesaResponseDto> listaDeDespesas = despesaService.listarReceitaPorUsuario(cdUsuario);
        return ResponseEntity.ok(listaDeDespesas);
    }

    @PutMapping("/editar")
    public ResponseEntity<DespesaResponseDto> editarReceita(@RequestBody @Valid DespesaRequestDto despesaRequestDto){
        DespesaResponseDto editarDespesa = despesaService.editarReceita(despesaRequestDto);
        return ResponseEntity.ok(editarDespesa);
    }
}
