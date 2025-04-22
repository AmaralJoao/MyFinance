package com.br.MyFinance.Repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.br.MyFinance.Model.TiposRendaModel;


@ApplicationScoped
public class TipoRendaRepository {

	@Inject
	private EntityManager entityManager;

	@Transactional
	public List<TiposRendaModel> listarTipoDeRendas() {
		try {
			String jpql = "SELECT tr " + "FROM TiposRendaModel tr WHERE tr.idVigente = 1";

			return entityManager.createQuery(jpql, TiposRendaModel.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	

    public TiposRendaModel buscarPorId(Long id) {
        return entityManager.find(TiposRendaModel.class, id);
    }
}