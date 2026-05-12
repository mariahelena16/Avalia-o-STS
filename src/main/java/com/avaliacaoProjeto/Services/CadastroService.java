package com.avaliacaoProjeto.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.avaliacaoProjeto.Entities.Cadastro;
import com.avaliacaoProjeto.Repository.CadastroRepository;

@Service
public class CadastroService {

    private final CadastroRepository cadastroRepository;

    public CadastroService(CadastroRepository cadastroRepository) {
        this.cadastroRepository = cadastroRepository;
    }

    public List<Cadastro> buscarTodosCadastro() {
        return cadastroRepository.findAll();
    }

    public Cadastro buscarCadastroPorId(Long id) {
        Optional<Cadastro> cadastro = cadastroRepository.findById(id);
        return cadastro.orElse(null);
    }

    public Cadastro salvarCadastro(Cadastro atCadastro) {
        return cadastroRepository.save(atCadastro);
    }

    public Cadastro atualizarCadastro(Long id, Cadastro atCadastro) {
        Optional<Cadastro> exeCadastro = cadastroRepository.findById(id);

        if (exeCadastro.isPresent()) {
            Cadastro cadastro = exeCadastro.get();
            BeanUtils.copyProperties(atCadastro, cadastro, "id");
            return cadastroRepository.save(cadastro);
        }

        return null;
    }

    public Boolean apagarCadastro(Long id) {
        Optional<Cadastro> exeCadastro = cadastroRepository.findById(id);

        if (exeCadastro.isPresent()) {
            cadastroRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public Cadastro authenticate(String username, String password) {
        Cadastro user = cadastroRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}