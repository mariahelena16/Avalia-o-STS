package com.avaliacaoProjeto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacaoProjeto.Entities.Cadastro;
import com.avaliacaoProjeto.Services.CadastroService;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

	@Autowired
	private final CadastroService cadastroService;

	public CadastroController(CadastroService cadastroService) {
		this.cadastroService = cadastroService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cadastro> buscarCadastroId(@PathVariable Long id) {
		Cadastro cadastro = cadastroService.buscarCadastroPorId(id);

		if (cadastro != null) {
			return ResponseEntity.ok(cadastro);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Cadastro>> buscarTodosCadastro() {
		List<Cadastro> cadastro = cadastroService.buscarTodosCadastro();
		return ResponseEntity.ok(cadastro);
	}

	@PostMapping("/")
	public ResponseEntity<Cadastro> salvaCadastro(@RequestBody Cadastro cadastro) {
		Cadastro saveCadastro = cadastroService.salvarCadastro(cadastro);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveCadastro);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cadastro> alteraCadastro(@PathVariable Long id, @RequestBody Cadastro cadastro) {
		Cadastro atualizaCadastro = cadastroService.atualizarCadastro(id, cadastro);

		if (atualizaCadastro != null) {
			return ResponseEntity.ok(atualizaCadastro);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Cadastro> apagaCadastro(@PathVariable Long id) {
		boolean apagaCadastro = cadastroService.apagarCadastro(id);

		if (apagaCadastro) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/auth")
	public ResponseEntity<Cadastro> authenticate(@RequestBody Cadastro cadastroDetails) {

		Cadastro authenticatedUser = cadastroService.authenticate(cadastroDetails.getUsername(),
				cadastroDetails.getPassword());

		if (authenticatedUser != null) {
			authenticatedUser.setPassword(null);
			return ResponseEntity.ok(authenticatedUser);
		}

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
}