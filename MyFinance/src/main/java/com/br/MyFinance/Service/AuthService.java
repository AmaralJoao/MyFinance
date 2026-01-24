package com.br.MyFinance.Service;

import com.br.MyFinance.Dto.Request.LoginRequestDto;
import com.br.MyFinance.Dto.Response.LoginResponseDto;
import com.br.MyFinance.Mapper.BaseMapper;
import com.br.MyFinance.Model.LoginModel;
import com.br.MyFinance.Repository.BaseRepository;
import com.br.MyFinance.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends BaseService<LoginModel,Long>{
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private TokenService tokenService;

    public AuthService(BaseRepository<LoginModel, Long> repository) {
        super(repository);
    }

    public String validarLogin(LoginModel login) {
        LoginModel usuario = loginRepository.findByLogin(login.getLogin())
                .orElseThrow(() -> new RuntimeException("Usuário ou senha inválidos"));

        if (!getEncoder().matches(login.getSenha(), usuario.getSenha())) {
            throw new RuntimeException("Usuário ou senha inválidos");
        }

        return tokenService.gerarToken(usuario);
    }

    public String novoLogin(LoginModel loginModel){
        LoginModel novo = loginRepository.save(loginModel);
        return tokenService.gerarToken(novo);
    }
}
