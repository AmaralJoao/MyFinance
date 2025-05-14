package com.br.MyFinance.Repository;

import com.br.MyFinance.Model.BancoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoRepository extends JpaRepository<BancoModel,Long> {

}
