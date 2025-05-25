package com.br.MyFinance.Dto.Request;

import com.br.MyFinance.Enum.TipoDespesaEnum;
import com.br.MyFinance.Enum.TipoReceitaEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DespesaRequestDto {

    @JsonProperty("idContaBancaria")
    private Long contaBancariaId;

    @JsonProperty("idTipoDespesa")
    private TipoDespesaEnum tipoRenda;

    @NotBlank
    @Size(max = 100)
    @JsonProperty("descricaoDespesa")
    private String descricao;

    @Positive
    @JsonProperty("valorDespesa")
    private BigDecimal valor;


    @JsonProperty("dataPagamentoDespesa")
    private LocalDate dataDoPagamento;

    @JsonProperty("dataVencimentoDespesa")
    private LocalDate dataDoVencimento;

    @Size(max = 255)
    @JsonProperty("observacaoDaDespesa")
    private String observacao;

    @JsonProperty("idRepetir")
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

    public LocalDate getDataDoPagamento() {
        return dataDoPagamento;
    }

    public void setDataDoPagamento(LocalDate dataDoPagamento) {
        this.dataDoPagamento = dataDoPagamento;
    }

    public LocalDate getDataDoVencimento() {
        return dataDoVencimento;
    }

    public void setDataDoVencimento(LocalDate dataDoVencimento) {
        this.dataDoVencimento = dataDoVencimento;
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
