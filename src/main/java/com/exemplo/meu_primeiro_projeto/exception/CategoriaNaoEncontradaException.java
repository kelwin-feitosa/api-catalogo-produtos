package com.exemplo.meu_primeiro_projeto.exception;

public class CategoriaNaoEncontradaException extends RuntimeException{
    public CategoriaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
