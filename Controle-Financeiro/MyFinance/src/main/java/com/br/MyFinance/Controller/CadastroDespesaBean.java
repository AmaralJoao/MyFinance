package com.br.MyFinance.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.MyFinance.Model.ContaBancariaModel;
import com.br.MyFinance.Model.DespesaModel;
import com.br.MyFinance.Service.ContaBancariaService;
import com.br.MyFinance.Service.TipoDespesaService;

@SessionScoped
@Named("cadastroDespesaBean")
public class CadastroDespesaBean implements Serializable {

	static final long serialVersionUID = 1L;
	
	@Inject
	private TipoDespesaService tipoDespesaService;
	@Inject
	private ContaBancariaService contaBancariaService;

	private List<ContaBancariaModel> contaBancaria;
	private List<Object[]> tipoDespesa;

	private DespesaModel despesaModel = new DespesaModel();

	@PostConstruct
	public void init() {
		listaContaBancariaUsuario();
		listaTiposDeDespesa();

	}

	public void salvar() {

	}

	public void listaContaBancariaUsuario() {

		Long cdUsuario = (Long) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cdUsuario");

		if (cdUsuario == null) {
			contaBancaria = new ArrayList<>();
			return;
		}

		contaBancaria = contaBancariaService.listarContasDoUsuario(cdUsuario);
	}

	public void listaTiposDeDespesa() {

		tipoDespesa = tipoDespesaService.listarTiposDeDespesas();
	}

	public DespesaModel getDespesaModel() {
		return despesaModel;
	}

	public void setDespesaModel(DespesaModel despesaModel) {
		this.despesaModel = despesaModel;
	}

	public List<ContaBancariaModel> getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(List<ContaBancariaModel> contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public List<Object[]> getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(List<Object[]> tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
	
	

}
