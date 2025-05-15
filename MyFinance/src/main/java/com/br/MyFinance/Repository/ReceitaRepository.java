package com.br.MyFinance.Repository;

import com.br.MyFinance.Model.ReceitaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReceitaRepository extends JpaRepository<ReceitaModel, Long> {
    Optional<List<ReceitaModel>> findBycdUsuario(Long cdUsuario);
}
