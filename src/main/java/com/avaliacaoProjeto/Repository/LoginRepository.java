package com.avaliacaoProjeto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacaoProjeto.Entities.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
	Login findByUsername(String username);
}