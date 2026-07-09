package com.exemplo.meu_primeiro_projeto.exception;

public class ProdutoNaoEncontradoException extends RuntimeException {
    public ProdutoNaoEncontradoException (String mensagem) {
        super(mensagem);
    }
}
