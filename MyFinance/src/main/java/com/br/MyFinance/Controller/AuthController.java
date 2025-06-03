package com.br.MyFinance.Controller;

import com.br.MyFinance.Dto.Request.AccountCredenctialRequestDto;
import com.br.MyFinance.Dto.Response.TokenResponseDto;
import com.br.MyFinance.Service.AuthService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(AccountCredenctialRequestDto credential){
        if (credentialsIsNull(credential)){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Usuario ou senha não pode ser null");
        }
        var token = authService.signIn(credential);
        if (token == null) ResponseEntity.status(HttpStatus.FORBIDDEN).body("requisição invalida");
        return ResponseEntity.ok().body(token);
    }

    private static boolean credentialsIsNull(AccountCredenctialRequestDto credential) {
        return credential == null || StringUtils.isBlank(credential.getNomeDeusuario()) || StringUtils.isBlank(credential.getSenha());
    }
}
