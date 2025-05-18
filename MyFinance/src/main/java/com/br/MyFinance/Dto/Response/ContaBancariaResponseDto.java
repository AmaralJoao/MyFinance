package com.br.MyFinance.Dto.Response;

import com.br.MyFinance.Model.ContaBancariaModel;
import com.br.MyFinance.Model.ReceitaModel;

public class ContaBancariaResponseDto {


    private String nomeDaConta;

    private Integer tipoConta;

    private long cdBanco;

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
