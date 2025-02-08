package com.br.MyFinance.Controller;

import java.io.Serializable;

public class IndexBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int receitas;
	private int despesas;
	private int saldoGeral;
	private int contasPagar;
	private int maioresGastosAtuais;
	
	public void BuscarReceitas() {
		
	}
	
	public void BuscarDespesas() {
		
	}
	
	public void BuscarSaldoGeral () {
		
	}

	public void BuscarTarefas () {
		
	}
	
	public void BuscarContasPagar() {
		
	}

	public void BuscarMaioresGastosAtuais() {
	
	}

	public int getDespesas() {
		return despesas;
	}

	public void setDespesas(int despesas) {
		this.despesas = despesas;
	}

	public void setReceitas(int receitas) {
		this.receitas = receitas;
	}

	public void setSaldoGeral(int saldoGeral) {
		this.saldoGeral = saldoGeral;
	}

	public void setContasPagar(int contasPagar) {
		this.contasPagar = contasPagar;
	}

	public void setMaioresGastosAtuais(int maioresGastosAtuais) {
		this.maioresGastosAtuais = maioresGastosAtuais;
	}
	
	
}
