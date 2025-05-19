package com.br.MyFinance.Repository;

import com.br.MyFinance.Model.ReceitaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReceitaRepository extends JpaRepository<ReceitaModel, Long> {
    @Query("SELECT r FROM ReceitaModel r JOIN r.contaBancaria c WHERE c.usuario.id = :usuarioId")
    List<ReceitaModel> findByUsuarioId(@Param("usuarioId") Long usuarioId);
}
