package com.exemplo.meu_primeiro_projeto.exception;

public class CarrinhoNaoEncontradoException extends RuntimeException{
    public CarrinhoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
