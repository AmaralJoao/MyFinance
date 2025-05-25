package com.br.MyFinance.Repository;

import com.br.MyFinance.Model.DadosUsuarioModel;
import com.br.MyFinance.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DadosUsuarioModelRepository extends JpaRepository<DadosUsuarioModel, Long> {
    Optional<DadosUsuarioModel> findByEmail(String email);
}
