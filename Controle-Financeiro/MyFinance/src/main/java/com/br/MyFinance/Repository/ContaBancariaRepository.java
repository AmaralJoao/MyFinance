package com.br.MyFinance.Repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import javax.transaction.Transactional;

import com.br.MyFinance.Model.ContaBancariaModel;


@ApplicationScoped
public class ContaBancariaRepository {

	@Inject
	private EntityManager entityManager;

	@Transactional
	public List<ContaBancariaModel> listarContasPorUsuario(Long cdUsuario) {
	    try {
	        String jpql = "SELECT cb FROM ContaBancariaModel cb "
	                    + "JOIN FETCH cb.usuarioConta u "
	                    + "LEFT JOIN FETCH cb.bancoContaBancaria b "
	                    + "WHERE u.cdUsuario = :cdUsuario";

	        return entityManager.createQuery(jpql, ContaBancariaModel.class)
	                .setParameter("cdUsuario", cdUsuario)
	                .getResultList();
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw e;
	    }
	}

	
    public ContaBancariaModel buscarPorId(Long id) {
        return entityManager.find(ContaBancariaModel.class, id);
    }

}