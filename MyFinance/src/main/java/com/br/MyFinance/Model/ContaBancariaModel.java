package com.br.MyFinance.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "contaBancaria")
public class ContaBancariaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdContaBancaria")
    private Integer cdContaBancaria;

    @Column(name = "nmContaBancaria", nullable = false, length = 50)
    private String nmContaBancaria;

    @Column(name = "idTipoDaConta", nullable = false)
    private Integer idTipoConta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdUsuarioConta", nullable = false)
    private DadosUsuarioModel usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdBanco")
    private BancoModel banco;

    public ContaBancariaModel() {
    }

    public ContaBancariaModel(String nome, Integer tipoConta, DadosUsuarioModel usuario) {
        this.nmContaBancaria = Objects.requireNonNull(nome, "Nome da conta não pode ser nulo");
        this.idTipoConta = Objects.requireNonNull(tipoConta, "Tipo da conta não pode ser nulo");
        this.usuario = Objects.requireNonNull(usuario, "Usuário não pode ser nulo");
    }

    public ContaBancariaModel(String nome, Integer tipoConta, DadosUsuarioModel usuario, BancoModel banco) {
        this(nome, tipoConta, usuario);
        this.banco = banco;
    }

    public void atualizarDados(String nome, Integer tipoConta, DadosUsuarioModel usuario, BancoModel banco) {
        this.nmContaBancaria = nome;
        this.idTipoConta = tipoConta;
        this.usuario = usuario;
        this.banco = banco;
    }

    public Integer getCdContaBancaria() {
        return cdContaBancaria;
    }

    public void setCdContaBancaria(Integer cdContaBancaria) {
        this.cdContaBancaria = cdContaBancaria;
    }

    public String getNmContaBancaria() {
        return nmContaBancaria;
    }

    public void setNmContaBancaria(String nmContaBancaria) {
        this.nmContaBancaria = nmContaBancaria;
    }

    public Integer getIdTipoConta() {
        return idTipoConta;
    }

    public void setIdTipoConta(Integer idTipoConta) {
        this.idTipoConta = idTipoConta;
    }

    public DadosUsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(DadosUsuarioModel usuario) {
        this.usuario = usuario;
    }

    public BancoModel getBanco() {
        return banco;
    }

    public void setBanco(BancoModel banco) {
        this.banco = banco;
    }
}
