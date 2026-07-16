package com.exemplo.meu_primeiro_projeto.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.meu_primeiro_projeto.dto.CategoriaRequest;
import com.exemplo.meu_primeiro_projeto.dto.CategoriaResponse;
import com.exemplo.meu_primeiro_projeto.service.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }
    
    @GetMapping
    public List<CategoriaResponse> listarCategorias() {
        return service.listarCategorias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaResponse> criarCategoria(@Valid @RequestBody CategoriaRequest categoriaNova) {
        CategoriaResponse resposta = service.criarCategoria(categoriaNova);

        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponse> editarCategoria(
        @PathVariable Long id, 
        @Valid @RequestBody CategoriaRequest categoriaAtualizada) {

        return ResponseEntity.ok(service.atualizarCategoria(id, categoriaAtualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        service.deletarCategoria(id);

        return ResponseEntity.noContent().build();
    }

}
