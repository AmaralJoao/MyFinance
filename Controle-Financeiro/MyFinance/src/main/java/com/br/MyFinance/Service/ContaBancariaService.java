package com.br.MyFinance.Service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.br.MyFinance.Model.ContaBancariaModel;
import com.br.MyFinance.Repository.ContaBancariaRepository;

@ApplicationScoped
public class ContaBancariaService {

	@Inject
	private ContaBancariaRepository contaBancariaRepository;

	public List<ContaBancariaModel> listarContasDoUsuario(Long cdUsuario) {

		if (cdUsuario != null) {
			try {
				List<ContaBancariaModel> contas = contaBancariaRepository.listarContasPorUsuario(cdUsuario);
				return contas;
			} catch (Exception e) {
				System.err.println("ERRO ao listar contas do usuário: " + e.getMessage());
				e.printStackTrace();
				return new ArrayList<>();
			}
		} else {
			return new ArrayList<>();
		}
	}

	public ContaBancariaModel buscarPorId(long cdReceita) {
		try {
            return contaBancariaRepository.buscarPorId(cdReceita);
        } catch (Exception e) {
            System.err.println("ERRO ao buscar conta: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
	}

}
