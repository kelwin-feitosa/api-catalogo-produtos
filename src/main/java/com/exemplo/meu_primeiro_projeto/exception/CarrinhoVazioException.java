package com.exemplo.meu_primeiro_projeto.exception;

public class CarrinhoVazioException extends RuntimeException{
    public CarrinhoVazioException(String mensagem) {
        super(mensagem);
    }
}
