package com.exemplo.meu_primeiro_projeto.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GerenciadorDeExcecoes {

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<RespostaErro> tratarProdutoNaoEncontrado(ProdutoNaoEncontradoException ex) {
        RespostaErro erro = new RespostaErro(
            "Produto não encontrado.",
            ex.getMessage(),
            LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(CategoriaNaoEncontradaException.class)
    public ResponseEntity<RespostaErro> tratarCategoriaNaoEncontrada(CategoriaNaoEncontradaException ex) {
        RespostaErro erro = new RespostaErro(
            "Categoria não encontrada",
            ex.getMessage(),
            LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RespostaErro> tratarErroValidacao(MethodArgumentNotValidException ex) {
        var campoErro = ex.getBindingResult().getFieldError();
        
        String mensagem = campoErro != null ? campoErro.getDefaultMessage() : "Dados inválidos.";
        
        RespostaErro erro = new RespostaErro(
            "Dados enviados não passam nas regras de validação.",
            mensagem,
            LocalDateTime.now()
        );

        return ResponseEntity.badRequest().body(erro);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<RespostaErro> tratarJsonErro(HttpMessageNotReadableException ex) {
        RespostaErro erro = new RespostaErro(
          "Corpo da requisição inválido (JSON malformado).",
          "Certifique-se de que o JSON enviado está com a sintaxe correta.",
          LocalDateTime.now()
        );

        return ResponseEntity.badRequest().body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RespostaErro> tratarErroGenerico (Exception ex) {
        RespostaErro erro = new RespostaErro (
            "Erro interno no servidor",
            "Ocorreu uma falha inesperada no backend",
            LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }

}
