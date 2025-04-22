package com.br.MyFinance.Model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "usuario")
public class UsuarioModel implements Serializable {

 
	private static final long serialVersionUID = 1L;

	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "cdUsuario")
    private Long cdUsuario;

    @Column(name = "usuario", nullable = false, length = 50) 
    private String usuario;

    @Column(name = "senha", nullable = false, length = 100) 
    private String senha;

    @Column(name = "dataDeNascimento", nullable = false) 
    private Date dataDeNascimento;

    
    public UsuarioModel() {
    }

    public UsuarioModel(String usuario, String senha, Date dataDeNascimento) {
        this.usuario = usuario;
        this.senha = senha;
        this.dataDeNascimento = dataDeNascimento;
    }

   
    public Long getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(Long cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    @Override
    public String toString() {
        return "UsuarioModel{" +
                "cdUsuario=" + cdUsuario +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                '}';
    }
}