package com.br.MyFinance.Repository;

import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import com.br.MyFinance.Model.UsuarioModel;

@ApplicationScoped
public class UsuarioRepository {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyFinancePU");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Transactional
	public Optional<UsuarioModel> buscarUsuarioPorNomeUsuario(String nomeUsuario) {
		EntityManager entityManager = getEntityManager();
		try {
			UsuarioModel usuarioModel = entityManager
					.createQuery("SELECT u FROM UsuarioModel u WHERE u.usuario = :nomeUsuario", UsuarioModel.class)
					.setParameter("nomeUsuario", nomeUsuario).getSingleResult();
			return Optional.ofNullable(usuarioModel);
		} catch (NoResultException e) {
			return Optional.empty();
		} finally {
			entityManager.close();
		}
	}
}