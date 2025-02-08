package com.br.MyFinance.Controller;

import java.io.Serializable;
import java.sql.Date;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@ManagedBean
@SessionScoped
@Named("cadastroReceitaBean")
public class CadastroReceitaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String descricao; 
	private Double valorRenda;
	private Date dataRenda;
	private String observações;
	private char repetir;
	
	public void SalvarReceita() {
		
		
	}
	
	public void limpar() {
		String descricao = null; 
		Double valorRenda = null;
		Date dataRenda = null;
		String observações = null;
		char repetir;
	}
	
	
}
