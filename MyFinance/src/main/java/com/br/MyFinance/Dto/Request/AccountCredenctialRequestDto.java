package com.br.MyFinance.Dto.Request;

public class AccountCredenctialRequestDto {

    private String nomeDeUsuario;
    private String senha;

    public AccountCredenctialRequestDto() {
    }

    public String getnomeDeUsuario() {
        return nomeDeUsuario;
    }

    public void setnomeDeUsuario(String nomeDeUsuario) {
        this.nomeDeUsuario = nomeDeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
