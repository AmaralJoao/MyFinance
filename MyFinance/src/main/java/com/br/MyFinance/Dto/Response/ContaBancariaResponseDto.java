package com.br.MyFinance.Dto.Response;

import com.br.MyFinance.Model.BancoModel;
import com.br.MyFinance.Model.ContaBancaria;
import com.br.MyFinance.Model.UsuarioModel;
import jakarta.persistence.*;

public class ContaBancariaResponseDto {


    private String nomeDaConta;

    private Integer tipoConta;

    private long cdBanco;

    public ContaBancariaResponseDto(ContaBancaria contaBancaria) {

        this.nomeDaConta = contaBancaria.getNome();
        this.tipoConta = contaBancaria.getTipoConta();
        this.cdBanco = (contaBancaria.getBanco() != null) ? contaBancaria.getBanco().getId() : null;

    }

    public ContaBancariaResponseDto() {
    }

    public String getNomeDaConta() {
        return nomeDaConta;
    }

    public void setNomeDaConta(String nomeDaConta) {
        this.nomeDaConta = nomeDaConta;
    }

    public Integer getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(Integer tipoConta) {
        this.tipoConta = tipoConta;
    }

    public long getCdBanco() {
        return cdBanco;
    }

    public void setCdBanco(long cdBanco) {
        this.cdBanco = cdBanco;
    }
}
