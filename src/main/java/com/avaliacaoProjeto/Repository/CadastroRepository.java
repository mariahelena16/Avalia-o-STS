package com.avaliacaoProjeto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacaoProjeto.Entities.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
	Cadastro findByUsername(String username);
}