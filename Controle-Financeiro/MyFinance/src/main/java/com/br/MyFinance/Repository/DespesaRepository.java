package com.br.MyFinance.Repository;

import java.math.BigDecimal;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@ApplicationScoped
public class DespesaRepository {

	@Inject
	private EntityManager entityManager;
	
	public BigDecimal calcularSomaDespesaPorUsuario(Long cdUsuario) {
		try {
			TypedQuery<BigDecimal> query = entityManager.createQuery( "SELECT COALESCE(SUM(d.valorDespesa), 0) " +
	                "FROM DespesaModel d " + 
	                "JOIN d.contaDespesa cb " + 
	                "WHERE cb.usuarioConta.id = :cdUsuario",BigDecimal.class);
			query.setParameter("cdUsuario", cdUsuario);
			return query.getSingleResult();
		} catch (Exception e) {
			System.err.print("Erro ao somar despesas: " + e.getMessage());
			e.printStackTrace();
			return BigDecimal.ZERO;
		}
	}
}
