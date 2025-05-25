package com.br.MyFinance.Repository;

import com.br.MyFinance.Model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<UsersModel, Long> {

    @Query("SELECT u FROM UserModel u WHERE u.nomeDeUsuario = :nomeDeUsuario")
    UsersModel findByNomeDeUsuario(@Param("nomeDeUsuario") String nomeDeUsuario);

}
