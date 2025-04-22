package com.br.MyFinance.Service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.br.MyFinance.Repository.TipoDespesaRepository;
import com.br.MyFinance.Repository.TipoRendaRepository;

@ApplicationScoped
public class TipoDespesaService {
	
	@Inject
	private TipoDespesaRepository tipoDespesaRepository;

	public List<Object[]> listarTiposDeDespesas(){
		
		try {
			List<Object[]> rendas = tipoDespesaRepository.listarTiposDeDespesas();
			return rendas;
		} catch (Exception e) {
			System.err.println("ERRO ao listar contas do usuário: " + e.getMessage());
			e.printStackTrace();
			return new ArrayList<>();
		}
		
	}
	
}
