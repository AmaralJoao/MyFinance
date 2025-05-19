package com.br.MyFinance.Repository;

import com.br.MyFinance.Model.ContaBancariaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContaBancariaRepository extends JpaRepository<ContaBancariaModel, Long> {
    Optional<List<ContaBancariaModel>>findByCdUsuarioConta(long cdUsuario);

    boolean existsByIdAndUsuarioId(Long contaId, Long usuarioId);
}
