package com.br.MyFinance.Controller;

import com.br.MyFinance.Dto.Request.UsuarioRequestDto;
import com.br.MyFinance.Dto.Response.UsuarioResponseDto;
import com.br.MyFinance.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<UsuarioResponseDto> cadastrar(@RequestBody @Validated UsuarioRequestDto usuarioResquest){

        //UsuarioResponseDto usuarioResponse = usuarioService.cadastrar(usuarioResquest);

        return null;//ResponseEntity.status(201).body(usuarioResponse);
    }

    @PostMapping("/logar")
    public ResponseEntity<UsuarioResponseDto> logar(@RequestBody @Validated UsuarioRequestDto usuarioRequestDto) {
        //UsuarioResponseDto usuarioLogado = usuarioService.logar(usuarioRequestDto);
        return null; //ResponseEntity.ok(usuarioLogado);
    }
}
