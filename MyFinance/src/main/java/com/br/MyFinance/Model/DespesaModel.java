package com.br.MyFinance.Model;

import com.br.MyFinance.Enum.TipoDespesaEnum;
import com.br.MyFinance.Enum.TipoReceitaEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "despesa")
public class DespesaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dsDespesa", nullable = false, length = 255)
    private String descricao;

    @Column(name = "valorDespesa", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "dataDespesa", nullable = false)
    private LocalDate data;

    @Column(name = "cdTipoDespesa", nullable = false)
    private TipoDespesaEnum tipoDespesa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdContaBancaria", nullable = false)
    private ContaBancariaModel contaBancaria;

    @Column(name = "observacoes", length = 500)
    private String observacoes;

    @Column(name = "idRepetir", nullable = false)
    private Boolean repetir;

    public DespesaModel() {
    }

    public DespesaModel(Long id, String descricao, BigDecimal valor, LocalDate data, TipoDespesaEnum tipoDespesa, ContaBancariaModel contaBancaria, String observacoes, Boolean repetir) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.tipoDespesa = tipoDespesa;
        this.contaBancaria = contaBancaria;
        this.observacoes = observacoes;
        this.repetir = repetir;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public TipoDespesaEnum getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(TipoDespesaEnum tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public ContaBancariaModel getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancariaModel contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Boolean getRepetir() {
        return repetir;
    }

    public void setRepetir(Boolean repetir) {
        this.repetir = repetir;
    }
}