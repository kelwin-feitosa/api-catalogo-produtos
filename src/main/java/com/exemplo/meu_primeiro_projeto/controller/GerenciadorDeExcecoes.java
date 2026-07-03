package com.exemplo.meu_primeiro_projeto.controller;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RespostaErro> tratarErroValidacao(MethodArgumentNotValidException ex) {
        String mensagem = ex.getBindingResult().getFieldError().getDefaultMessage();
        
        var erro = new RespostaErro(
            "Dados enviados não passam nas regras de validação.",
            mensagem,
            LocalDateTime.now()
        );

        return ResponseEntity.badRequest().body(erro);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<RespostaErro> tratarJsonErro(HttpMessageNotReadableException ex) {
        var erro = new RespostaErro(
          "Corpo da requisição inválido (JSON malformado).",
          "Certifique-se de que o JSON enviado está com a sintaxe correta.",
          LocalDateTime.now()
        );

        return ResponseEntity.badRequest().body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RespostaErro> tratarErroGenerico (Exception ex) {
        var erro = new RespostaErro (
            "Erro interno no servidor",
            "Ocorreu uma falha inesperada no backend",
            LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }

}
