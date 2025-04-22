package com.br.MyFinance.Util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EntityManagerProducer {

	@PersistenceContext(unitName = "MyFinancePU")
	private EntityManagerFactory emf;

	public EntityManagerProducer() {
		// Inicializar o EntityManagerFactory durante a inicialização da aplicação
		emf = Persistence.createEntityManagerFactory("MyFinancePU");
		System.out.println("EntityManagerFactory inicializado: " + (emf != null));
	}

	@Produces
	@Dependent
	public EntityManager produceEntityManager() {
		if (emf == null) {
			System.err.println("ERRO: EntityManagerFactory é null!");
			return null;
		}

		EntityManager em = emf.createEntityManager();
		System.out.println("EntityManager produzido: " + (em != null));
		return em;
	}
}
