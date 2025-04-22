package com.br.MyFinance.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipoDespesa")
public class TipoDespesaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdTipoDespesa") 
    private Long cdTipoDespesa; 

    @Column(name = "dsDespesa", nullable = false, length = 50) 
    private String descricaoDespesa;

    @Column(name = "idVigente", nullable = false)
    private int idVigente;
    
    public TipoDespesaModel() {
    	
    }
    
    public TipoDespesaModel(Long cdTipoDespesa, String descricaoDespesa) {
    	super();
    	this.cdTipoDespesa = cdTipoDespesa;
    	this.descricaoDespesa = descricaoDespesa;
    }

	public TipoDespesaModel(Long cdTipoDespesa, String descricaoDespesa, int idVigente) {
		super();
		this.cdTipoDespesa = cdTipoDespesa;
		this.descricaoDespesa = descricaoDespesa;
		this.idVigente = idVigente;
	}


	public Long getCdTipoDespesa() {
		return cdTipoDespesa;
	}

	public void setCdTipoDespesa(Long cdTipoDespesa) {
		this.cdTipoDespesa = cdTipoDespesa;
	}

	public String getDescricaoDespesa() {
		return descricaoDespesa;
	}

	public void setDescricaoDespesa(String descricaoDespesa) {
		this.descricaoDespesa = descricaoDespesa;
	}

	public int getIdVigente() {
		return idVigente;
	}

	public void setIdVigente(int idVigente) {
		this.idVigente = idVigente;
	}
    
    
}