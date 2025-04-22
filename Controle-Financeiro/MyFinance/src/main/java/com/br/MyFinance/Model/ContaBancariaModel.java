package com.br.MyFinance.Model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "contaBancaria")
public class ContaBancariaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdContaBancaria")
    private long id;

    @Column(name = "nmContaBancaria", nullable = false, length = 50)
    private String nomeDaContaBancaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdUsuarioConta", nullable = false)
    private UsuarioModel usuarioConta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdBanco")
    private BancoModel bancoContaBancaria;

    public ContaBancariaModel() {}
    
    public ContaBancariaModel(long id, String nomeDaContaBancaria) {
    	this.id = id;
    	this.nomeDaContaBancaria = nomeDaContaBancaria;
    }

    public ContaBancariaModel(long id, String nomeDaContaBancaria, UsuarioModel usuarioConta,
            BancoModel bancoContaBancaria) {
        this.id = id;
        this.nomeDaContaBancaria = nomeDaContaBancaria;
        this.usuarioConta = usuarioConta;
        this.bancoContaBancaria = bancoContaBancaria;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeDaContaBancaria() {
        return nomeDaContaBancaria;
    }

    public void setNomeDaContaBancaria(String nomeDaContaBancaria) {
        this.nomeDaContaBancaria = nomeDaContaBancaria;
    }

    public UsuarioModel getUsuarioConta() {
        return usuarioConta;
    }

    public void setUsuarioConta(UsuarioModel usuarioConta) {
        this.usuarioConta = usuarioConta;
    }

    public BancoModel getBancoContaBancaria() {
        return bancoContaBancaria;
    }

    public void setBancoContaBancaria(BancoModel bancoContaBancaria) {
        this.bancoContaBancaria = bancoContaBancaria;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ContaBancariaModel that = (ContaBancariaModel) obj;
        return id != 0 && id == that.id;
    }

    @Override
    public int hashCode() {
        return id != 0 ? Objects.hash(id) : super.hashCode();
    }

    public String toDetailedString() {
        return "ContaBancariaModel [id=" + id 
                + ", nomeDaContaBancaria=" + nomeDaContaBancaria 
                + ", usuarioConta=" + (usuarioConta != null ? usuarioConta.getCdUsuario() : "null") 
                + ", bancoContaBancaria=" + (bancoContaBancaria != null ? bancoContaBancaria.getCodigoBanco() : "null") 
                + "]";
    }

    
}
