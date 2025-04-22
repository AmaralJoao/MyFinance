package com.br.MyFinance.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bancos")
public class BancoModel implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cdBanco")
	private long codigoBanco;
	@Column(name = "nmBanco")
	private String nomeDoBanco;
	
	public BancoModel() {
		
	}
	
	public BancoModel(long codigoBanco, String nomeDoBanco) {
		this.codigoBanco = codigoBanco;
		this.nomeDoBanco = nomeDoBanco;
	}
	public long getCodigoBanco() {
		return codigoBanco;
	}
	public void setCodigoBanco(long codigoBanco) {
		this.codigoBanco = codigoBanco;
	}
	public String getNomeDoBanco() {
		return nomeDoBanco;
	}
	public void setNomeDoBanco(String nomeDoBanco) {
		this.nomeDoBanco = nomeDoBanco;
	}

	@Override
	public String toString() {
		return "BancoModel [codigoBanco=" + codigoBanco + ", nomeDoBanco=" + nomeDoBanco + "]";
	}
	
	
	
}
