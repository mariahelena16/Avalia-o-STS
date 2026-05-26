package com.avaliacaoProjeto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avaliacaoProjeto.Entities.Produtos;
import com.avaliacaoProjeto.Services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoService produtosService;

    
    @GetMapping("/{id}")
    public ResponseEntity<Produtos> buscarProdutosId(@PathVariable Long id) {

        Produtos produtos = produtosService.buscarProdutosPorId(id);

        if (produtos != null) {
            return ResponseEntity.ok(produtos);
        }

        return ResponseEntity.notFound().build();
    }

    
    @GetMapping
    public ResponseEntity<List<Produtos>> buscarTodosProdutos() {

        List<Produtos> produtos = produtosService.buscarTodosProdutos();

        return ResponseEntity.ok(produtos);
    }

    
    @PostMapping
    public ResponseEntity<Produtos> salvarProdutos(@RequestBody Produtos produtos) {

        Produtos novoProduto = produtosService.salvarProdutos(produtos);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Produtos> alteraProdutos(@PathVariable Long id,
                                                   @RequestBody Produtos produtos) {

        Produtos atualizaProdutos = produtosService.atualizarProdutos(id, produtos);

        if (atualizaProdutos != null) {
            return ResponseEntity.ok(atualizaProdutos);
        }

        return ResponseEntity.notFound().build();
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagaProdutos(@PathVariable Long id) {

        boolean apagaProdutos = produtosService.apagarProdutos(id);

        if (apagaProdutos) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}