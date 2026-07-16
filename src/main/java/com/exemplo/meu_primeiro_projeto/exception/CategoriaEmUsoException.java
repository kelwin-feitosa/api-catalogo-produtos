package com.exemplo.meu_primeiro_projeto.exception;

public class CategoriaEmUsoException extends RuntimeException{
    public CategoriaEmUsoException(String mensagem) {
        super(mensagem);
    }
}
