package com.br.MyFinance.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "DadosUsuario")
public class DadosUsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdUsuario")
    private Long id;

    @OneToOne
    @JoinColumn(name = "login", nullable = false)
    private UsersModel usuario;

    @Column(name = "nmUsuario", nullable = false)
    private String nomeCompletoDoUsuario;

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

    public DadosUsuarioModel(Long id, UsersModel usuario, String nomeCompletoDoUsuario, String email, int dddUsuario, long telefoneUsuario, LocalDate dataDeNascimento, LocalDate dataCriacao) {
        this.id = id;
        this.usuario = usuario;
        this.nomeCompletoDoUsuario = nomeCompletoDoUsuario;
        this.email = email;
        this.dddUsuario = dddUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.dataDeNascimento = dataDeNascimento;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsersModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsersModel usuario) {
        this.usuario = usuario;
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
}
