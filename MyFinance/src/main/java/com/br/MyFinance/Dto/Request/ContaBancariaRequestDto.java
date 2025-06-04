package com.br.MyFinance.Dto.Request;

import com.br.MyFinance.Model.BancoModel;
import com.br.MyFinance.Model.ContaBancariaModel;
import com.br.MyFinance.Model.DadosUsuarioModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ContaBancariaRequestDto {

    @JsonProperty("id")
    private Long cdContaBancaria;

    @NotBlank(message = "O nome da conta é obrigatório.")
    @JsonProperty("nomeDaConta")
    private String nome;

    @NotNull(message = "O tipo da conta é obrigatório.")
    @JsonProperty("idTipoDaConta")
    private Integer tipoConta;

    @JsonProperty("codigoDoBanco")
    private Long cdBanco;

    @NotNull(message = "O ID do usuário é obrigatório.")
    @JsonProperty("codigoDoUsuario")
    private Long cdUsuario;

    public Long getCdContaBancaria() {
        return cdContaBancaria;
    }

    public void setCdContaBancaria(Long cdContaBancaria) {
        this.cdContaBancaria = cdContaBancaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(Integer tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Long getCdBanco() {
        return cdBanco;
    }

    public void setCdBanco(Long cdBanco) {
        this.cdBanco = cdBanco;
    }

    public Long getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(Long cdUsuario) {
        this.cdUsuario = cdUsuario;
    }
}
