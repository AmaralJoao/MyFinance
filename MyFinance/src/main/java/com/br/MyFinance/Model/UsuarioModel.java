package com.br.MyFinance.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdUsuario")
    private Long cdUsuario;

    @Column(name = "nmUsuario", nullable = false)
    private String nomeDoUsuario;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "usuario", nullable = false, length = 50)
    private String usuario;

    @Column(name = "senha", nullable = false, length = 100)
    private String senha;

    @Column(name = "dtNascimento", nullable = false)
    private LocalDate dataDeNascimento;

    @CreationTimestamp
    @Column(name = "dtCriacao", nullable = false)
    private LocalDate dataCriacao;

    public UsuarioModel() {
    }

    public UsuarioModel(Long cdUsuario, String nomeDoUsuario, String email, String usuario, String senha, LocalDate dataDeNascimento) {
        this.cdUsuario = cdUsuario;
        this.nomeDoUsuario = nomeDoUsuario;
        this.email = email;
        this.usuario = usuario;
        this.senha = senha;
        this.dataDeNascimento = dataDeNascimento;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Long getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(Long cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public LocalDate getDataCriacao() {return dataCriacao;}

    public void setDataCriacao(LocalDate dataCriacao) {this.dataCriacao = dataCriacao;}

    public String getNomeDoUsuario() {return nomeDoUsuario;}

    public void setNomeDoUsuario(String nomeDoUsuario) {this.nomeDoUsuario = nomeDoUsuario;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}
}
