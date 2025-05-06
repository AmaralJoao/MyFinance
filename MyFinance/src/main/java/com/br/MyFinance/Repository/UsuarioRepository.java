package com.br.MyFinance.Repository;

import com.br.MyFinance.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel,Long> {
    Optional<UsuarioModel> localizarPorEmail(String email);
}
