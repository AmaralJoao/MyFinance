package com.br.MyFinance.Service;

import java.math.BigDecimal;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.br.MyFinance.Repository.DespesaRepository;

@ApplicationScoped
public class DespesaService {
	
	@Inject
	private DespesaRepository despesaRepository;

	public void salvar() {

	}

	public BigDecimal obterDespesasPorUsuario(Long cdUsuario) {
		try {
			return despesaRepository.calcularSomaDespesaPorUsuario(cdUsuario);
		} catch (Exception e) {
			System.err.println("Erro ao obter soma das despesas: " + e.getMessage());
			e.printStackTrace();
			return BigDecimal.ZERO;
		}
	}

}
