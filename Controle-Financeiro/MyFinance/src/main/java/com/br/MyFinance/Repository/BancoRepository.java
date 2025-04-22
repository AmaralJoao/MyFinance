package com.br.MyFinance.Repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import com.br.MyFinance.Model.BancoModel;

@ApplicationScoped
public class BancoRepository {

	/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyFinancePU");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	@Transactional
	public List<BancoModel> buscarTodosOsBancos() {
		EntityManager entityManager = getEntityManager();
		try {
			return entityManager
					.createQuery("SELECT b FROM bancos b;", BancoModel.class).getResultList();
		} catch (Exception e) {
			
			throw new RuntimeException("Erro ao buscar bancos");
		}finally {
			entityManager.close();
		}
	}*/
}
