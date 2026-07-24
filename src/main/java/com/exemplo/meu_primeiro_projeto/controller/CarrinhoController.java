package com.exemplo.meu_primeiro_projeto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.meu_primeiro_projeto.dto.CarrinhoResponse;
import com.exemplo.meu_primeiro_projeto.dto.ItemCarrinhoRequest;
import com.exemplo.meu_primeiro_projeto.service.CarrinhoService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {
    private final CarrinhoService service;
    
    public CarrinhoController(CarrinhoService service) {
        this.service = service;
    }

    @PostMapping("/{idCliente}")
    public ResponseEntity<CarrinhoResponse> criarCarrinho(@PathVariable Long idCliente) {
        CarrinhoResponse resposta = service.criarCarrinho(idCliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @PostMapping("/itens")
    public ResponseEntity<CarrinhoResponse> adicionarItem(@Valid @RequestBody ItemCarrinhoRequest request) {
        return ResponseEntity.ok(service.adicionarItem(request));
    }

    @PutMapping("/itens")
    public ResponseEntity<CarrinhoResponse> alterarItem(@Valid @RequestBody ItemCarrinhoRequest request) {
        return ResponseEntity.ok(service.alterarQuantidade(request));
    }

    @DeleteMapping("/itens")
    public ResponseEntity<Void> removerItem(@Valid @RequestBody ItemCarrinhoRequest request) {
        service.removerItem(request);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{idCarrinho}")
    public ResponseEntity<CarrinhoResponse> limparCarrinho(@PathVariable Long idCarrinho) {
        CarrinhoResponse resposta = service.limparCarrinho(idCarrinho);

        return ResponseEntity.ok(resposta);
    }
}
