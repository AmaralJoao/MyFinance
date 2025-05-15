package com.br.MyFinance.Model;

import com.br.MyFinance.Enum.TipoDespesaEnum;
import com.br.MyFinance.Enum.TipoReceitaEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "receita")
public class ReceitaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdReceita")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdContaBancaria", nullable = false)
    private ContaBancariaModel contaBancaria;

    @Column(name = "cdTipoReceita", nullable = false)
    private TipoReceitaEnum tipoReceita;

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

    public ReceitaModel(ContaBancariaModel contaBancaria, TipoReceitaEnum tipoReceita, String descricao, BigDecimal valor, LocalDate data, String observacao, String repetir, LocalDate dataCriacao) {
        this.contaBancaria = contaBancaria;
        this.tipoReceita = tipoReceita;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.observacao = observacao;
        this.repetir = repetir;
        this.dataCriacao = dataCriacao;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContaBancariaModel getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancariaModel contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public TipoReceitaEnum getTipoRenda() {
        return tipoReceita;
    }

    public void setTipoRenda(TipoReceitaEnum tipoReceita) {
        this.tipoReceita = tipoReceita;
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

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
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
    }
}
