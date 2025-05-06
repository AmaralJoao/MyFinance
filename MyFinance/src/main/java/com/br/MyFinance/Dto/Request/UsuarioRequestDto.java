package com.br.MyFinance.Dto.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class UsuarioRequestDto {

    @NotBlank(message = "Nome é obrigatorio!")
    private String nomeDeUsuario;

    @NotBlank(message = "nome de usuario é obrigatorio!")
    private String usuario;

    @Email
    @NotBlank(message = "Email é obrigatorio!")
    private String email;

    @NotBlank(message = "Senha deve conter 8 ou mais caracteres!")
    private String senha;

    @NotBlank(message = "Data de nascimento é obrigatorio")
    private Date dataDeNascimento;

    public String getNomeDeUsuario() {
        return nomeDeUsuario;
    }

    public void setNomeDeUsuario(String nomeDeUsuario) {
        this.nomeDeUsuario = nomeDeUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
}
