package com.br.MyFinance.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/*@Entity
@Table(name = "despesa")*/
public class DespesaModel {
/*
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdTipoDespesa", nullable = false)
    private TipoDespesaModel tipoDespesa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdContaBancaria", nullable = false)
    private ContaBancaria contaBancaria;

    @Column(name = "observacoes", length = 500)
    private String observacoes;

    @Column(name = "idRepetir", nullable = false)
    private Boolean repetir;

    public DespesaModel() {
    }

    public DespesaModel(String descricao, BigDecimal valor, LocalDate data,
                   TipoDespesaModel tipoDespesa, ContaBancaria contaBancaria, Boolean repetir) {
        this.descricao = Objects.requireNonNull(descricao, "Descrição não pode ser nula");
        this.valor = Objects.requireNonNull(valor, "Valor não pode ser nulo");
        this.data = Objects.requireNonNull(data, "Data não pode ser nula");
        this.tipoDespesa = Objects.requireNonNull(tipoDespesa, "Tipo de despesa não pode ser nulo");
        this.contaBancaria = Objects.requireNonNull(contaBancaria, "Conta bancária não pode ser nula");
        this.repetir = Objects.requireNonNull(repetir, "Repetir não pode ser nulo");
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public TipoDespesaModel getTipoDespesa() {
        return tipoDespesa;
    }

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public Boolean getRepetir() {
        return repetir;
    }

    // Setters
    public void setDescricao(String descricao) {
        this.descricao = Objects.requireNonNull(descricao);
    }

    public void setValor(BigDecimal valor) {
        this.valor = Objects.requireNonNull(valor);
    }

    public void setData(LocalDate data) {
        this.data = Objects.requireNonNull(data);
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void setRepetir(Boolean repetir) {
        this.repetir = Objects.requireNonNull(repetir);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DespesaModel despesa = (DespesaModel) o;
        return Objects.equals(id, despesa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Despesa{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", data=" + data +
                '}';
    }*/
}