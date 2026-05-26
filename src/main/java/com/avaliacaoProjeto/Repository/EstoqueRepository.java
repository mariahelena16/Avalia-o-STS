package com.avaliacaoProjeto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacaoProjeto.Entities.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

}