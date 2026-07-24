package com.exemplo.meu_primeiro_projeto.exception;

public class VendaNaoEncontradaException extends RuntimeException{
    public VendaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
