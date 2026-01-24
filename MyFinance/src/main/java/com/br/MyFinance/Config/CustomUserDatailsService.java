package com.br.MyFinance.Config;

import com.br.MyFinance.Model.LoginModel;
import com.br.MyFinance.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomUserDatailsService implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginModel usuario = this.loginRepository.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException("erro ai"));

        return new org.springframework.security.core.userdetails.User(usuario.getLogin(), usuario.getSenha(), new ArrayList<>());
    }
}
