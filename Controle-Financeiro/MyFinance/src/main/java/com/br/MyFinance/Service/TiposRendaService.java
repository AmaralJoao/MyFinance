package com.br.MyFinance.Service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.br.MyFinance.Model.TiposRendaModel;
import com.br.MyFinance.Repository.TipoRendaRepository;

@ApplicationScoped
public class TiposRendaService {

	@Inject
	private TipoRendaRepository tipoRendaRepository;

	public List<TiposRendaModel> listarTiposDeReceitas() {

		try {
			List<TiposRendaModel> rendas = tipoRendaRepository.listarTipoDeRendas();
			return rendas;
		} catch (Exception e) {
			System.err.println("ERRO ao listar contas do usuário: " + e.getMessage());
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	public TiposRendaModel buscarPorId(long cdReceita) {
		
		try {
            return tipoRendaRepository.buscarPorId(cdReceita);
        } catch (Exception e) {
            System.err.println("ERRO ao buscar tipo de renda: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
        
	}

}
