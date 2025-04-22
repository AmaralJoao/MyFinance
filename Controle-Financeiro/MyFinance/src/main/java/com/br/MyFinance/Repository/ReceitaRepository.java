package com.br.MyFinance.Repository;


import java.math.BigDecimal;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.br.MyFinance.Model.ContaBancariaModel;
import com.br.MyFinance.Model.ReceitaModel;
import com.br.MyFinance.Model.TiposRendaModel;

@ApplicationScoped
public class ReceitaRepository {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public void salvar(ReceitaModel receita) {
        System.out.println("### ReceitaRepository.salvar() - Iniciando");
        try {
            // Verifica se o EntityManager está válido
            if (entityManager == null) {
                System.out.println("### ERRO: entityManager é null");
                throw new RuntimeException("EntityManager não injetado corretamente");
            }
            
            System.out.println("### EntityManager injetado: " + entityManager.toString());
            
            // Verifica se os objetos relacionados são entidades gerenciadas
            if (receita.getTipoReceita() != null && 
                !entityManager.contains(receita.getTipoReceita())) {
                System.out.println("### TipoReceita não é uma entidade gerenciada, tentando referenciar");
                receita.setTipoReceita(entityManager.getReference(
                    TiposRendaModel.class, receita.getTipoReceita().getCdTipoRenda()));
            }
            
            if (receita.getContaReceita() != null && 
                !entityManager.contains(receita.getContaReceita())) {
                System.out.println("### ContaReceita não é uma entidade gerenciada, tentando referenciar");
                receita.setContaReceita(entityManager.getReference(
                    ContaBancariaModel.class, receita.getContaReceita().getId()));
            }
            
            System.out.println("### Tentando persistir receita");
            entityManager.persist(receita);
            System.out.println("### Receita persistida com sucesso!");
            
            // Força o flush para garantir que os erros apareçam aqui
            System.out.println("### Executando flush");
            entityManager.flush();
            System.out.println("### Flush executado com sucesso!");
            
        } catch (Exception e) {
            System.out.println("### ERRO em ReceitaRepository.salvar(): " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar receita: " + e.getMessage(), e);
        }
    }
	public Double calcularSomaReceitasPorUsuario(long cdUsuario) {
		
		try {
			TypedQuery<Double> query = entityManager.createQuery("SELECT COALESCE(SUM(r.valorRenda), 0) " +
					"FROM ReceitaModel r " + "JOIN r.contaReceita cb " + "WHERE cb.usuarioConta.id = :cdUsuario",Double.class);
			query.setParameter("cdUsuario", cdUsuario);
			return query.getSingleResult();
			
		} catch (Exception e) {
			System.err.print("Erro ao Calcular soma das Receitas" + e.getMessage());
			e.printStackTrace();
			return 0.0;
		}
	}
}
