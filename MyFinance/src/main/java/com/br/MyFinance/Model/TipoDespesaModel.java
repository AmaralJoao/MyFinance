package com.br.MyFinance.Model;

import jakarta.persistence.*;

import java.util.Objects;
/*
@Entity
@Table(name = "tipoDespesa")*/
public class TipoDespesaModel {
/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdTipoDespesa")
    private Long id;

    @Column(name = "dsDespesa", nullable = false, length = 50)
    private String descricao;

    @Column(name = "idVigente", nullable = false)
    private Integer vigente;

    public TipoDespesaModel() {
    }

    public TipoDespesaModel(String descricao, Integer vigente) {
        this.descricao = Objects.requireNonNull(descricao, "Descrição não pode ser nula");
        this.vigente = Objects.requireNonNull(vigente, "Vigente não pode ser nulo");
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getVigente() {
        return vigente;
    }

    // Setters
    public void setDescricao(String descricao) {
        this.descricao = Objects.requireNonNull(descricao);
    }

    public void setVigente(Integer vigente) {
        this.vigente = Objects.requireNonNull(vigente);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoDespesaModel that = (TipoDespesaModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TipoDespesa{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", vigente=" + vigente +
                '}';
    }*/
}
