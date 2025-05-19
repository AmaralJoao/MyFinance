package com.br.MyFinance.Repository;

import com.br.MyFinance.Model.DespesaModel;
import com.br.MyFinance.Model.ReceitaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DespesaRepository extends JpaRepository<DespesaModel, Long> {
    @Query("SELECT r FROM DespesaModel r JOIN r.contaBancaria c WHERE c.usuario.id = :usuarioId ")
    List<DespesaModel> findByUsuarioId(@Param("usuarioId") Long usuarioId);
}
