package com.br.MyFinance.Controller;

import com.br.MyFinance.Dto.Request.UsuarioRequestDto;
import com.br.MyFinance.Dto.Response.UsuarioResponseDto;
import com.br.MyFinance.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/auth/usuario")
public class UsuarioController extends BaseController{

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<?> cadastrar(@RequestBody @Validated UsuarioRequestDto usuarioResquest){


        usuarioService.cadastrarUsuario(usuarioResquest);

        return ResponseEntity.ok(200);
    }
}
