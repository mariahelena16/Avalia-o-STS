package com.avaliacaoProjeto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avaliacaoProjeto.Entities.Estoque;
import com.avaliacaoProjeto.Services.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private final EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estoque> buscarEstoqueId(@PathVariable Long id) {
        Estoque estoque = estoqueService.buscarEstoquePorId(id);

        if (estoque != null) {
            return ResponseEntity.ok(estoque);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Estoque>> buscarTodosEstoques() {
        List<Estoque> estoque = estoqueService.buscarTodosEstoques();
        return ResponseEntity.ok(estoque);
    }

    @PostMapping("/")
    public ResponseEntity<Estoque> salvaEstoque(@RequestBody Estoque estoque) {
        Estoque saveEstoque = estoqueService.salvarEstoque(estoque);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveEstoque);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estoque> alteraEstoque(@PathVariable Long id, @RequestBody Estoque estoque) {
        Estoque atualizaEstoque = estoqueService.atualizarEstoque(id, estoque);

        if (atualizaEstoque != null) {
            return ResponseEntity.ok(atualizaEstoque);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Estoque> apagaEstoque(@PathVariable Long id) {
        boolean apagaEstoque = estoqueService.apagarEstoque(id);

        if (apagaEstoque) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}