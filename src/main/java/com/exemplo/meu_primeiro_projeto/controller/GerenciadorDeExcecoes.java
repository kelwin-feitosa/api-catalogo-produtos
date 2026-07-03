package com.exemplo.meu_primeiro_projeto.controller;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.exemplo.meu_primeiro_projeto.dto.RespostaErro;

@ControllerAdvice
public class GerenciadorDeExcecoes {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<RespostaErro> tratarNaoEncontrado(NoSuchElementException ex) {
        var erro = new RespostaErro(
            "Produto não encontrado.",
            "O ID informado não corresponde a nenhum produto no catálogo.",
            LocalDateTime.now()
        );
        return ResponseEntity.status(404).body(erro);
    }

}
