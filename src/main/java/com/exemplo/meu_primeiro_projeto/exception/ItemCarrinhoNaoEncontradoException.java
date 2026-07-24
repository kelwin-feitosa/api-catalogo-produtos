package com.exemplo.meu_primeiro_projeto.exception;

public class ItemCarrinhoNaoEncontradoException extends RuntimeException {

    public ItemCarrinhoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}