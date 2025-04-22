package com.br.MyFinance.Repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class TipoDespesaRepository {
	
	@Inject
	private EntityManager entityManager;

	public List<Object[]> listarTiposDeDespesas() {

		try {

			String jpql = "SELECT td.cdTipoDespesa, td.descricao " 
					+ "FROM TipoDespesaModel td WHERE td.idVigente = 1";
			return entityManager.createQuery(jpql, Object[].class).getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
