package com.br.MyFinance.Dto.Request;

import com.br.MyFinance.Enum.TipoReceitaEnum;
import com.br.MyFinance.Model.ContaBancariaModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReceitaRequestDto {

    private Long contaBancariaId;

    @NotNull
    private TipoReceitaEnum tipoRenda;

    @NotBlank
    @Size(max = 100)
    private String descricao;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    private LocalDate data;

    @Size(max = 255)
    private String observacao;

    @NotNull
    private String repetir;

    public ReceitaRequestDto() {
    }

    public ReceitaRequestDto(Long contaBancariaId, TipoReceitaEnum tipoRenda, String descricao, BigDecimal valor, LocalDate data, String observacao, String repetir) {
        this.contaBancariaId = contaBancariaId;
        this.tipoRenda = tipoRenda;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.observacao = observacao;
        this.repetir = repetir;
    }

    public ReceitaRequestDto(TipoReceitaEnum tipoRenda, String descricao, BigDecimal valor, LocalDate data, String observacao, String repetir) {
        this.tipoRenda = tipoRenda;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.observacao = observacao;
        this.repetir = repetir;
    }

    // Getters e Setters
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