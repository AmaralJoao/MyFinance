package com.br.MyFinance.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cartao")
public class CartaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nmCartao", nullable = false, length = 100)
    private String nome;

    @Column(name = "dsCartao", nullable = false, length = 255)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdContaCartao", nullable = false)
    private ContaBancaria contaBancaria;

    @Column(name = "idTipoCartao", nullable = false)
    private Integer tipoCartao;

    @Column(name = "idVigente", nullable = false)
    private Integer vigente;

    public CartaoModel() {
    }

    public CartaoModel(String nome, String descricao, ContaBancaria contaBancaria,
                  Integer tipoCartao, Integer vigente) {
        this.nome = Objects.requireNonNull(nome, "Nome não pode ser nulo");
        this.descricao = Objects.requireNonNull(descricao, "Descrição não pode ser nula");
        this.contaBancaria = Objects.requireNonNull(contaBancaria, "Conta bancária não pode ser nula");
        this.tipoCartao = Objects.requireNonNull(tipoCartao, "Tipo de cartão não pode ser nulo");
        this.vigente = Objects.requireNonNull(vigente, "Vigente não pode ser nulo");
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public Integer getTipoCartao() {
        return tipoCartao;
    }

    public Integer getVigente() {
        return vigente;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = Objects.requireNonNull(nome);
    }

    public void setDescricao(String descricao) {
        this.descricao = Objects.requireNonNull(descricao);
    }

    public void setTipoCartao(Integer tipoCartao) {
        this.tipoCartao = Objects.requireNonNull(tipoCartao);
    }

    public void setVigente(Integer vigente) {
        this.vigente = Objects.requireNonNull(vigente);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartaoModel cartao = (CartaoModel) o;
        return Objects.equals(id, cartao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipoCartao=" + tipoCartao +
                '}';
    }
}
