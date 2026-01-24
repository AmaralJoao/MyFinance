package com.br.MyFinance.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "banco")
public class BancoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoBanco")
    private Long cdBanco;

    @Column(name = "nomeDoBanco", length = 100)
    private String nome;

    public BancoModel() {
    }

    public BancoModel(String nome) {
        this.nome = Objects.requireNonNull(nome, "Nome do banco não pode ser nulo");
    }

    // Getters
    public Long getCdBanco() {
        return cdBanco;
    }

    public String getNome() {
        return nome;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = Objects.requireNonNull(nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BancoModel banco = (BancoModel) o;
        return Objects.equals(cdBanco, banco.cdBanco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cdBanco);
    }

    @Override
    public String toString() {
        return "Banco{" +
                "id=" + cdBanco +
                ", nome='" + nome + '\'' +
                '}';
    }
}
