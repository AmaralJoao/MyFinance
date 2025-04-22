package com.br.MyFinance.Controller;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.MyFinance.Service.DespesaService;
import com.br.MyFinance.Service.ReceitaService;

@SessionScoped
@Named("indexBean")
public class IndexBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ReceitaService receitaService;
	@Inject
	private DespesaService despesaService;
	
	private Double totalReceitas;
	private BigDecimal totalDespesas;
	private int saldoGeral;
	private int contasPagar;
	private int maioresGastosAtuais;
	
	@PostConstruct
	public void init() {
		carregarTotalReceitas();
		carregarTotalDespesas();
	}
	
	public void carregarTotalReceitas() {
		
        Long cdUsuario = (Long) FacesContext.getCurrentInstance()
                .getExternalContext()
                .getSessionMap()
                .get("cdUsuario");
        
		totalReceitas = receitaService.obterReceitasPorUsuario(cdUsuario);
	}
	
	public void carregarTotalDespesas() {
		
        Long cdUsuario = (Long) FacesContext.getCurrentInstance()
                .getExternalContext()
                .getSessionMap()
                .get("cdUsuario");
        
		totalDespesas = despesaService.obterDespesasPorUsuario(cdUsuario);
	}
	
	
	public void BuscarSaldoGeral () {
		
	}

	public void BuscarTarefas () {
		
	}
	
	public void BuscarContasPagar() {
		
	}

	public void BuscarMaioresGastosAtuais() {
	
	}
	
	// Getters e Setters

	public Double getTotalReceitas() {
		return totalReceitas;
	}

	public void setTotalReceitas(Double totalReceitas) {
		this.totalReceitas = totalReceitas;
	}

	public BigDecimal getTotalDespesas() {
		return totalDespesas;
	}

	public void setTotalDespesas(BigDecimal totalDespesas) {
		this.totalDespesas = totalDespesas;
	}

	
	
}
