package com.br.MyFinance.Model;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "receita")
public class ReceitaModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cdReceita")
	private long cdReceita;
	
	@ManyToOne
	@JoinColumn(name = "cdContaBancaria", nullable = false)
	private ContaBancariaModel contaReceita;
	
	@ManyToOne
	@JoinColumn(name = "cdTipoReceita", nullable = false)
	private TiposRendaModel tipoReceita;
	
	@Column(name = "dsReceita", nullable = false, length = 100)
	private String descricao;
	
	@Column(name = "valorRenda", nullable = false)
	private Double valorRenda;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataRenda", nullable = false)
	private Date dataRenda;
	
	@Column(name = "observacaoRenda", length = 255)
	private String observacoes;
	
	@Column(name = "repetir", nullable = false, length = 1)
	private String repetir; 
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataCriacao", nullable = false)
	private Date dataCriacao;
	
	// Método para inicializar dataCriacao automaticamente antes de persistir
	@PrePersist
	protected void onCreate() {
		if (dataCriacao == null) {
			dataCriacao = new Date();
		}
	}
	
	public ReceitaModel() {
		// Inicializa dataCriacao no construtor vazio também
		this.dataCriacao = new Date();
	}
	
	public ReceitaModel(long cdReceita, ContaBancariaModel contaReceita, TiposRendaModel tipoReceita, String descricao,
			Double valorRenda, Date dataRenda, String observacoes, String repetir) {
		super();
		this.cdReceita = cdReceita;
		this.contaReceita = contaReceita;
		this.tipoReceita = tipoReceita;
		this.descricao = descricao;
		this.valorRenda = valorRenda;
		this.dataRenda = dataRenda;
		this.observacoes = observacoes;
		this.repetir = repetir;
		this.dataCriacao = new Date();
	}
	
	public long getCdReceita() {
		return cdReceita;
	}
	
	public void setCdReceita(long cdReceita) {
		this.cdReceita = cdReceita;
	}
	
	public ContaBancariaModel getContaReceita() {
		return contaReceita;
	}
	
	public void setContaReceita(ContaBancariaModel contaReceita) {
		this.contaReceita = contaReceita;
	}
	
	public TiposRendaModel getTipoReceita() {
		return tipoReceita;
	}
	
	public void setTipoReceita(TiposRendaModel tipoReceita) {
		this.tipoReceita = tipoReceita;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Double getValorRenda() {
		return valorRenda;
	}
	
	public void setValorRenda(Double valorRenda) {
		this.valorRenda = valorRenda;
	}
	
	public Date getDataRenda() {
		return dataRenda;
	}
	
	public void setDataRenda(Date dataRenda) {
		this.dataRenda = dataRenda;
	}
	
	public String getObservacoes() {
		return observacoes;
	}
	
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	public String getRepetir() {
		return repetir;
	}
	
	public void setRepetir(String repetir) {
		this.repetir = repetir;
	}
	
	public Date getDataCriacao() {
		return dataCriacao;
	}
	
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}