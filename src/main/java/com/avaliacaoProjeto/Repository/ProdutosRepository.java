package com.avaliacaoProjeto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacaoProjeto.Entities.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

}
