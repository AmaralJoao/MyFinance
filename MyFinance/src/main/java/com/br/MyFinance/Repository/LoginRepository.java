package com.br.MyFinance.Repository;

import com.br.MyFinance.Model.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends BaseRepository<LoginModel, Long> {
    Optional<LoginModel> findByLogin(String login);
}
