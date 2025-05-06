package com.br.MyFinance.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/*@Entity
@Table(name = "receita")*/
public class ReceitaModel {
/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdReceita")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdContaBancaria", nullable = false)
    private ContaBancaria contaBancaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdTipoReceita", nullable = false)
    private TipoRendaModel tipoRenda;

    @Column(name = "dsReceita", nullable = false, length = 100)
    private String descricao;

    @Column(name = "valorRenda", nullable = false)
    private BigDecimal valor;

    @Column(name = "dataRenda", nullable = false)
    private LocalDate data;

    @Column(name = "observacaoRenda", length = 255)
    private String observacao;

    @Column(name = "repetir", nullable = false, length = 1)
    private String repetir;

    @Column(name = "dataCriacao", nullable = false)
    private LocalDate dataCriacao;

    public ReceitaModel() {
    }

    public ReceitaModel(ContaBancaria contaBancaria, TipoRendaModel tipoRenda, String descricao,
                   BigDecimal valor, LocalDate data, String repetir) {
        this.contaBancaria = Objects.requireNonNull(contaBancaria, "Conta bancária não pode ser nula");
        this.tipoRenda = Objects.requireNonNull(tipoRenda, "Tipo de renda não pode ser nulo");
        this.descricao = Objects.requireNonNull(descricao, "Descrição não pode ser nula");
        this.valor = Objects.requireNonNull(valor, "Valor não pode ser nulo");
        this.data = Objects.requireNonNull(data, "Data não pode ser nula");
        this.repetir = Objects.requireNonNull(repetir, "Repetir não pode ser nulo");
        this.dataCriacao = LocalDate.now();
    }

    // Getters
    public Long getId() {
        return id;
    }

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public TipoRendaModel getTipoRenda() {
        return tipoRenda;
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

    public String getObservacao() {
        return observacao;
    }

    public String getRepetir() {
        return repetir;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
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

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setRepetir(String repetir) {
        this.repetir = Objects.requireNonNull(repetir);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceitaModel receita = (ReceitaModel) o;
        return Objects.equals(id, receita.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Receita{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", data=" + data +
                '}';
    }*/
}
