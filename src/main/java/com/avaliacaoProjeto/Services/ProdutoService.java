package com.avaliacaoProjeto.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.avaliacaoProjeto.Entities.Produtos;
import com.avaliacaoProjeto.Repository.ProdutosRepository;

@Service
public class ProdutoService {
	final private ProdutosRepository produtosRepository;

	public ProdutoService(ProdutosRepository produtosRepository) {
		this.produtosRepository = produtosRepository;
	}

	public List<Produtos> buscarTodosProdutos() {
		return produtosRepository.findAll();
	}

	public Produtos buscarProdutosPorId(Long id) {
		Optional<Produtos> produtos = produtosRepository.findById(id);
		return produtos.orElse(null);
	}

	public Produtos salvarProdutos(Produtos atProdutos) {
		return produtosRepository.save(atProdutos);
	}

	public Produtos atualizarProdutos(Long id, Produtos atProdutos) {
		Optional<Produtos> exeProdutos = produtosRepository.findById(id);
		if (exeProdutos.isPresent()) {
			Produtos produtos = exeProdutos.get();
			BeanUtils.copyProperties(atProdutos, produtos, "id");
			return produtosRepository.save(produtos);
		}

		return null;

	}

	public Boolean apagarProdutos(Long id) {
		Optional<Produtos> exeProdutos = produtosRepository.findById(id);
		if (exeProdutos.isPresent()) {
			produtosRepository.deleteById(id);
			return true;
		}
		return false;
	}
}