package com.br.MyFinance.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "DadosUsuario")
public class DadosUsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdDadosUsuario")
    private Long cdDadosUsuario;

    @Column(name = "nmUsuario", nullable = false)
    private String nomeCompletoDoUsuario;

    @JoinColumn(name = "login")
    @OneToOne
    private LoginModel login;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "ddd")
    private int dddUsuario;

    @Column(name = "telefone")
    private long telefoneUsuario;

    @Column(name = "dtNascimento", nullable = false)
    private LocalDate dataDeNascimento;

    @CreationTimestamp
    @Column(name = "dtCriacao", nullable = false)
    private LocalDate dataCriacao;

    public DadosUsuarioModel() {
    }

    public DadosUsuarioModel(Long cdDadosUsuario, String nomeCompletoDoUsuario, String email, int dddUsuario, long telefoneUsuario, LocalDate dataDeNascimento, LocalDate dataCriacao) {
        this.cdDadosUsuario = cdDadosUsuario;
        this.nomeCompletoDoUsuario = nomeCompletoDoUsuario;
        this.email = email;
        this.dddUsuario = dddUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.dataDeNascimento = dataDeNascimento;
        this.dataCriacao = dataCriacao;
    }

    public DadosUsuarioModel(Long cdDadosUsuario, String nomeCompletoDoUsuario, LoginModel login, String email, int dddUsuario, long telefoneUsuario, LocalDate dataDeNascimento, LocalDate dataCriacao) {
        this.cdDadosUsuario = cdDadosUsuario;
        this.nomeCompletoDoUsuario = nomeCompletoDoUsuario;
        this.login = login;
        this.email = email;
        this.dddUsuario = dddUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.dataDeNascimento = dataDeNascimento;
        this.dataCriacao = dataCriacao;
    }

    public Long getCdDadosusuario() {
        return cdDadosUsuario;
    }

    public void setCdDadosusuario(Long cdDadosusuario) {
        this.cdDadosUsuario = cdDadosusuario;
    }

    public String getNomeCompletoDoUsuario() {
        return nomeCompletoDoUsuario;
    }

    public void setNomeCompletoDoUsuario(String nomeCompletoDoUsuario) {
        this.nomeCompletoDoUsuario = nomeCompletoDoUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDddUsuario() {
        return dddUsuario;
    }

    public void setDddUsuario(int dddUsuario) {
        this.dddUsuario = dddUsuario;
    }

    public long getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setTelefoneUsuario(long telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LoginModel getLogin() {
        return login;
    }

    public void setLogin(LoginModel login) {
        this.login = login;
    }
}
