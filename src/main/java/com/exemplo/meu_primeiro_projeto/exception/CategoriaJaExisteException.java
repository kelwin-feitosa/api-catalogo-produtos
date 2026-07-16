package com.exemplo.meu_primeiro_projeto.exception;

public class CategoriaJaExisteException extends RuntimeException{
    public CategoriaJaExisteException(String mensagem) {
        super(mensagem);
    }
}
