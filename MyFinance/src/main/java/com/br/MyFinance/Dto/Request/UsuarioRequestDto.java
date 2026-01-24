package com.br.MyFinance.Dto.Request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

public class UsuarioRequestDto {

    @NotBlank(message = "Nome é obrigatorio!")
    @JsonProperty("nomeCompleto")
    private String nomeCompletoDoUsuario;

    @Email
    @NotBlank(message = "Email é obrigatorio!")
    @JsonProperty("email")
    private String email;

    @NotNull(message = "Data de nascimento é obrigatorio")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("dataDeNascimento")
    private LocalDate dataDeNascimento;

    @NotNull(message = "DDD é obrigatorio")
    private int dddUsuario;

    @NotNull(message = "Telefone é obrigatorio")
    private long telefoneUsuario;

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

    public String getNomeCompletoDoUsuario() {
        return nomeCompletoDoUsuario;
    }

    public void setNomeCompletoDoUsuario(String nomeCompletoDoUsuario) {
        this.nomeCompletoDoUsuario = nomeCompletoDoUsuario;
    }

    public int getDddUsuario() {
        return dddUsuario;
    }

    public void setDddUsuario(int dddUsuario) {
        this.dddUsuario = dddUsuario;
    }

    public long getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setTelefoneUsuario(long telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }
}
