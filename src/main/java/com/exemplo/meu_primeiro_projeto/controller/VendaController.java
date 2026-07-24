package com.exemplo.meu_primeiro_projeto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.meu_primeiro_projeto.dto.VendaResponse;
import com.exemplo.meu_primeiro_projeto.service.VendaService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService service;

    public VendaController(VendaService service) {
        this.service = service;
    }

    @PostMapping("{idCarrinho}")
    public ResponseEntity<VendaResponse> realizarVenda(@PathVariable Long idCarrinho) {
        return ResponseEntity.ok(service.realizarVenda(idCarrinho));
    }

    @GetMapping("{idVenda}")
    public ResponseEntity<VendaResponse> buscarVenda(@PathVariable Long idVenda) {
        return ResponseEntity.ok(service.buscarVenda(idVenda));
    }

    @GetMapping
    public ResponseEntity<List<VendaResponse>> listarVendas() {
        return ResponseEntity.ok(service.listarVendas());
    }

}
