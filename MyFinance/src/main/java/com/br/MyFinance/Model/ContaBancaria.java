package com.br.MyFinance.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "contaBancaria")
public class ContaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdContaBancaria")
    private Long id;

    @Column(name = "nmContaBancaria", nullable = false, length = 50)
    private String nome;

    @Column(name = "idTipoDaConta", nullable = false)
    private Integer tipoConta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdUsuarioConta", nullable = false)
    private UsuarioModel usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdBanco")
    private BancoModel banco;

    public ContaBancaria() {
    }

    public ContaBancaria(String nome, Integer tipoConta, UsuarioModel usuario) {
        this.nome = Objects.requireNonNull(nome, "Nome da conta não pode ser nulo");
        this.tipoConta = Objects.requireNonNull(tipoConta, "Tipo da conta não pode ser nulo");
        this.usuario = Objects.requireNonNull(usuario, "Usuário não pode ser nulo");
    }

    public ContaBancaria(String nome, Integer tipoConta, UsuarioModel usuario, BancoModel banco) {
        this(nome, tipoConta, usuario);
        this.banco = banco;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getTipoConta() {
        return tipoConta;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public BancoModel getBanco() {
        return banco;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = Objects.requireNonNull(nome);
    }

    public void setTipoConta(Integer tipoConta) {
        this.tipoConta = Objects.requireNonNull(tipoConta);
    }

    public void setBanco(BancoModel banco) {
        this.banco = banco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaBancaria that = (ContaBancaria) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipoConta=" + tipoConta +
                '}';
    }
}
