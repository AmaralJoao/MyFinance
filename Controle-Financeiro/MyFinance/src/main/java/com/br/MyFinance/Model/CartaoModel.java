package com.br.MyFinance.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cartao")
public class CartaoModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cdCartao")
	private long id;
	
	@Column(name = "nmCartao", nullable = false)
	private String nomeCartao;
	
	@Column(name = "dsCartao", nullable = false)
	private String descricaoCartao;
	
	@JoinColumn(name = "cdContaCartao", nullable = false)
	private ContaBancariaModel contaCartao;
	
	@Column(name = "idTipoCartao", nullable = false)
	private int tipoCartao;
	
	@Column(name = "idVigente", nullable = false)
	private int cartaoAtivo;
	
	public CartaoModel() {
		
	}

	public CartaoModel(long id, String nomeCartao, String descricaoCartao, ContaBancariaModel contaCartao,
			int tipoCartao, int cartaoAtivo) {
		super();
		this.id = id;
		this.nomeCartao = nomeCartao;
		this.descricaoCartao = descricaoCartao;
		this.contaCartao = contaCartao;
		this.tipoCartao = tipoCartao;
		this.cartaoAtivo = cartaoAtivo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeCartao() {
		return nomeCartao;
	}

	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}

	public String getDescricaoCartao() {
		return descricaoCartao;
	}

	public void setDescricaoCartao(String descricaoCartao) {
		this.descricaoCartao = descricaoCartao;
	}

	public ContaBancariaModel getContaCartao() {
		return contaCartao;
	}

	public void setContaCartao(ContaBancariaModel contaCartao) {
		this.contaCartao = contaCartao;
	}

	public int getTipoCartao() {
		return tipoCartao;
	}

	public void setTipoCartao(int tipoCartao) {
		this.tipoCartao = tipoCartao;
	}

	public int getCartaoAtivo() {
		return cartaoAtivo;
	}

	public void setCartaoAtivo(int cartaoAtivo) {
		this.cartaoAtivo = cartaoAtivo;
	}

	@Override
	public String toString() {
		return "CartaoModel [id=" + id + ", nomeCartao=" + nomeCartao + ", descricaoCartao=" + descricaoCartao
				+ ", contaCartao=" + contaCartao + ", tipoCartao=" + tipoCartao + ", cartaoAtivo=" + cartaoAtivo + "]";
	}
	
	

}
