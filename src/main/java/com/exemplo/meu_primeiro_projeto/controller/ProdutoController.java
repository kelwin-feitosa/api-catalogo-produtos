package com.exemplo.meu_primeiro_projeto.controller;

import org.springframework.web.bind.annotation.RestController;

import com.exemplo.meu_primeiro_projeto.model.Produto;
import com.exemplo.meu_primeiro_projeto.repository.ProdutoRepository;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    
    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/produtos")
    public List<Produto> obterProdutos() {
        return repository.findAll();
    }

    @PostMapping("/produto")
    public String criarProduto(@RequestBody Produto novoProduto) {
        repository.save(novoProduto);
        return "Produto recebido com sucesso: " + novoProduto.getNome() + " - R$" + novoProduto.getPreco();
    }

    @DeleteMapping("/produto/{id}")
    public void deletarProduto(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/produto/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        Produto produtoAntigo = repository.findById(id).orElseThrow();
        
        produtoAntigo.setNome(produtoAtualizado.getNome());
        produtoAntigo.setPreco(produtoAtualizado.getPreco());

        return repository.save(produtoAntigo);
    }
    
}

