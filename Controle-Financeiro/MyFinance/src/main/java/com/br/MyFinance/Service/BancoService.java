package com.br.MyFinance.Service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.br.MyFinance.Model.BancoModel;
import com.br.MyFinance.Repository.BancoRepository;

@ApplicationScoped
public class BancoService {
	
	@Inject
	private BancoRepository bancoRepository;
	
	public List<BancoModel> listarBancos(){
		return null;//bancoRepository.buscarTodosOsBancos();
	}

}
