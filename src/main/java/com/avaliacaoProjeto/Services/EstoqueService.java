package com.avaliacaoProjeto.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.avaliacaoProjeto.Entities.Estoque;
import com.avaliacaoProjeto.Repository.EstoqueRepository;

@Service
public class EstoqueService {

	private final EstoqueRepository estoqueRepository;

	public EstoqueService(EstoqueRepository estoqueRepository) {
		this.estoqueRepository = estoqueRepository;
	}

	public List<Estoque> buscarTodosEstoques() {
		return estoqueRepository.findAll();
	}

	public Estoque buscarEstoquePorId(Long id) {
		Optional<Estoque> estoque = estoqueRepository.findById(id);
		return estoque.orElse(null);
	}

	public Estoque salvarEstoque(Estoque atEstoque) {
		return estoqueRepository.save(atEstoque);
	}

	public Estoque atualizarEstoque(Long id, Estoque atEstoque) {
		Optional<Estoque> exeEstoque = estoqueRepository.findById(id);

		if (exeEstoque.isPresent()) {
			Estoque estoque = exeEstoque.get();
			BeanUtils.copyProperties(atEstoque, estoque, "id");
			return estoqueRepository.save(estoque);
		}

		return null;
	}

	public Boolean apagarEstoque(Long id) {
		Optional<Estoque> exeEstoque = estoqueRepository.findById(id);

		if (exeEstoque.isPresent()) {
			estoqueRepository.deleteById(id);
			return true;
		}

		return false;
	}
}