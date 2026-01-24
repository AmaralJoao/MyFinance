package com.br.MyFinance.Service;

import com.br.MyFinance.Mapper.BaseMapper;
import com.br.MyFinance.Repository.BaseRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BaseService <MODEL, ID>{


    protected final BaseRepository<MODEL, ID> repository;

    public BaseService(BaseRepository<MODEL, ID> repository) {
        this.repository = repository;
    }

    public MODEL cadastrar(MODEL objeto){
        if (objeto == null){
            return objeto;
        }
        try {
            return repository.save(objeto);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao realizar cadastro" + e);
        }
    }

    public boolean validaSeNull(Object... objs) {
        if (objs == null) return true;

        for (Object obj : objs) {
            if (obj == null) {
                return true;
            }
        }
        return false;
    }


    protected BCryptPasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }


}
