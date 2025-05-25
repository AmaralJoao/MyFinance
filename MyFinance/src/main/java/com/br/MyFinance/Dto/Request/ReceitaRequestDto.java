package com.br.MyFinance.Dto.Request;

import com.br.MyFinance.Enum.TipoReceitaEnum;
import com.br.MyFinance.Model.ContaBancariaModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReceitaRequestDto {

    @JsonProperty("idContaBancaria")
    private Long contaBancariaId;

    @NotNull
    @JsonProperty("idTipoRenda")
    private TipoReceitaEnum tipoRenda;

    @NotBlank
    @Size(max = 100)
    @JsonProperty("descricaoReceita")
    private String descricao;

    @NotNull
    @Positive
    @JsonProperty("valorReceita")
    private BigDecimal valor;

    @NotNull
    @JsonProperty("dataRecebimentoDespesa")
    private LocalDate data;

    @Size(max = 255)
    @JsonProperty("observacaoDaRenda")
    private String observacao;

    @NotNull
    @JsonProperty("idRepetir")
    private String repetir;

    public ReceitaRequestDto() {
    }

    public Long getContaBancariaId() {
        return contaBancariaId;
    }

    public void setContaBancariaId(Long contaBancariaId) {
        this.contaBancariaId = contaBancariaId;
    }

    public TipoReceitaEnum getTipoRenda() {
        return tipoRenda;
    }

    public void setTipoRenda(TipoReceitaEnum tipoRenda) {
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