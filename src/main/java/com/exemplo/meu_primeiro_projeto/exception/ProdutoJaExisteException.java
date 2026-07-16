package com.exemplo.meu_primeiro_projeto.exception;

public class ProdutoJaExisteException extends RuntimeException{
    public ProdutoJaExisteException(String mensagem) {
        super(mensagem);
    }
}
