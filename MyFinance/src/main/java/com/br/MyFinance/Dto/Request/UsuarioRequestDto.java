package com.br.MyFinance.Dto.Request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

public class UsuarioRequestDto {

    @NotBlank(message = "Nome é obrigatorio!")
    @JsonProperty("nomeCompleto")
    private String nomeDoUsuario;

    @NotBlank(message = "nome de usuario é obrigatorio!")
    @JsonProperty("login")
    private String usuario;

    @Email
    @NotBlank(message = "Email é obrigatorio!")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "Senha deve conter 8 ou mais caracteres!")
    @JsonProperty("senha")
    private String senha;

    @NotNull(message = "Data de nascimento é obrigatorio")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("dataDeNascimento")
    private LocalDate dataDeNascimento;

    public String getNomeDoUsuario() {
        return nomeDoUsuario;
    }

    public void setNomeDoUsuario(String nomeDeUsuario) {
        this.nomeDoUsuario = nomeDeUsuario;
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

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
}
