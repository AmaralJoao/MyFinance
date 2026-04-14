package com.br.MyFinance.Service;

import com.br.MyFinance.Model.DadosUsuarioModel;
import com.br.MyFinance.Repository.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends BaseService<DadosUsuarioModel, Long>{

    public UsuarioService(BaseRepository<DadosUsuarioModel, Long> repository) {
        super(repository);
    }
}
