package com.exemplo.meu_primeiro_projeto.controller;

import org.springframework.web.bind.annotation.RestController;

import com.exemplo.meu_primeiro_projeto.dto.ProdutoRequisicao;
import com.exemplo.meu_primeiro_projeto.dto.ProdutoResposta;
import com.exemplo.meu_primeiro_projeto.service.ProdutoService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProdutoResposta> obterProdutos() {
        return service.listarProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResposta> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ProdutoResposta> criarProduto(@Valid @RequestBody ProdutoRequisicao novoProduto) {
        
        ProdutoResposta resposta = service.criarProduto(novoProduto);

        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @PutMapping("/{id}")
    public ProdutoResposta atualizarProduto(@PathVariable Long id, @Valid @RequestBody ProdutoRequisicao produtoAtualizado) {
        return service.atualizarProduto(id, produtoAtualizado);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        service.deletarProduto(id);

        return ResponseEntity.noContent().build();
    }

    
    
}

