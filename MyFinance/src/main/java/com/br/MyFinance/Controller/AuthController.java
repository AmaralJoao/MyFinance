package com.br.MyFinance.Controller;

import com.br.MyFinance.Dto.Request.LoginRequestDto;
import com.br.MyFinance.Dto.Response.LoginResponseDto;
import com.br.MyFinance.Mapper.BaseMapper;
import com.br.MyFinance.Model.LoginModel;
import com.br.MyFinance.Service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController extends BaseController<LoginRequestDto,LoginResponseDto,LoginModel>{

    @Autowired
    private AuthService authService;

    public AuthController(BaseMapper<LoginRequestDto, LoginResponseDto, LoginModel> mapper) {
        super(mapper);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginRequestDto dto) {
        return ResponseEntity.ok(new LoginResponseDto(authService.validarLogin(super.requestToModel(dto))));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<LoginResponseDto> cadastra(@RequestBody @Valid LoginRequestDto dto) {
        return ResponseEntity.ok(new LoginResponseDto(authService.novoLogin(super.requestToModel(dto))));
    }

}
