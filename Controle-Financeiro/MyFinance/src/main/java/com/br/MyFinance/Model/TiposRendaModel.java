package com.br.MyFinance.Model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipoRenda")
public class TiposRendaModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cdTipoRenda")
	private long cdTipoRenda;

	@Column(name = "dsRenda", nullable = false, length = 50)
	private String descricaoRenda;

	@Column(name = "idVigente", nullable = false)
	private int idVigente;

	public TiposRendaModel() {
	}
	
	public TiposRendaModel(long cdTipoRenda, String descricaoRenda) {
		super();
		this.cdTipoRenda = cdTipoRenda;
		this.descricaoRenda = descricaoRenda;
	}
	public TiposRendaModel(long cdTipoRenda, String descricaoRenda, int idVigente) {
		super();
		this.cdTipoRenda = cdTipoRenda;
		this.descricaoRenda = descricaoRenda;
		this.idVigente = idVigente;
	}

	public long getCdTipoRenda() {
		return cdTipoRenda;
	}

	public void setCdTipoRenda(long cdTipoRenda) {
		this.cdTipoRenda = cdTipoRenda;
	}

	public String getDescricaoRenda() {
		return descricaoRenda;
	}

	public void setDescricaoRenda(String descricaoRenda) {
		this.descricaoRenda = descricaoRenda;
	}

	public int getIdVigente() {
		return idVigente;
	}

	public void setIdVigente(int idVigente) {
		this.idVigente = idVigente;
	}

	@Override
	public String toString() {
	    return "TiposRendaModel [cdTipoRenda=" + cdTipoRenda + 
	           ", descricaoRenda=" + descricaoRenda + 
	           ", idVigente=" + idVigente + "]";
	}

	@Override
	public int hashCode() {
	    return Objects.hash(cdTipoRenda);
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    
	    TiposRendaModel other = (TiposRendaModel) obj;
	    return cdTipoRenda == other.cdTipoRenda;
	}
}