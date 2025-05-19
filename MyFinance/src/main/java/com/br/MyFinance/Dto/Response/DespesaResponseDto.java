package com.br.MyFinance.Dto.Response;

import com.br.MyFinance.Enum.TipoDespesaEnum;
import com.br.MyFinance.Enum.TipoReceitaEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DespesaResponseDto {

    private Long contaBancariaId;

    private TipoDespesaEnum tipoRenda;

    private String descricao;

    private BigDecimal valor;

    private LocalDate data;

    private String observacao;

    private String repetir;

    public Long getContaBancariaId() {
        return contaBancariaId;
    }

    public void setContaBancariaId(Long contaBancariaId) {
        this.contaBancariaId = contaBancariaId;
    }

    public TipoDespesaEnum getTipoRenda() {
        return tipoRenda;
    }

    public void setTipoRenda(TipoDespesaEnum tipoRenda) {
        this.tipoRenda = tipoRenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getRepetir() {
        return repetir;
    }

    public void setRepetir(String repetir) {
        this.repetir = repetir;
    }
}
