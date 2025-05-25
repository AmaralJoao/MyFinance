package com.br.MyFinance.Dto.Request;

public class AccountCredenctialRequestDto {

    private String nomeDeusuario;
    private String senha;

    public AccountCredenctialRequestDto() {
    }

    public String getNomeDeusuario() {
        return nomeDeusuario;
    }

    public void setNomeDeusuario(String nomeDeusuario) {
        this.nomeDeusuario = nomeDeusuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
