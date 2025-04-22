package com.br.MyFinance.Service;

import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.br.MyFinance.Model.ReceitaModel;
import com.br.MyFinance.Repository.ReceitaRepository;

@ApplicationScoped
public class ReceitaService {

    @Inject
    private ReceitaRepository receitaRepository;

    public void salvar(ReceitaModel receita) {
        System.out.println("### ReceitaService.salvar() - Iniciando");
        try {
            // Verificação antes de enviar para o repository
            if (receita == null) {
                System.out.println("### ERRO: receita é null");
                throw new IllegalArgumentException("Receita não pode ser null");
            }
            
            if (receita.getTipoReceita() == null) {
                System.out.println("### ERRO: tipoReceita é null");
                throw new IllegalArgumentException("Tipo de receita não pode ser null");
            }
            
            if (receita.getContaReceita() == null) {
                System.out.println("### ERRO: contaReceita é null");
                throw new IllegalArgumentException("Conta bancária não pode ser null");
            }
            
            if (receita.getDataCriacao() == null) {
                System.out.println("### Definindo data de criação no service, estava null");
                receita.setDataCriacao(new Date());
            }
            
            System.out.println("### Enviando para repository: " + 
                              "tipoReceita=" + receita.getTipoReceita().getCdTipoRenda() + 
                              ", contaReceita=" + receita.getContaReceita().getId() + 
                              ", descricao=" + receita.getDescricao() + 
                              ", valorRenda=" + receita.getValorRenda() + 
                              ", dataRenda=" + receita.getDataRenda() + 
                              ", dataCriacao=" + receita.getDataCriacao());
                              
            receitaRepository.salvar(receita);
            System.out.println("### ReceitaService: Receita salva com sucesso!");
        } catch (Exception e) {
            System.out.println("### ERRO em ReceitaService.salvar(): " + e.getMessage());
            e.printStackTrace();
            throw e; // Re-lança a exceção para ser tratada no Bean
        }
    }

	public Double obterReceitasPorUsuario(Long cdUsuario) {
		try {
			return receitaRepository.calcularSomaReceitasPorUsuario(cdUsuario);
		} catch (Exception e) {
			System.err.println("Erro ao obter soma das receitas: " + e.getMessage());
			e.printStackTrace();
			return 0.0;
		}
	}

}
