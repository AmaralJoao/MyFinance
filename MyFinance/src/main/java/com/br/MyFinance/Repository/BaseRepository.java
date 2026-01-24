package com.br.MyFinance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<MODEL, ID> extends JpaRepository<MODEL, ID> {
}
