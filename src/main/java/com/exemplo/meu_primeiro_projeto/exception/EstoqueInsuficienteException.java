package com.exemplo.meu_primeiro_projeto.exception;

public class EstoqueInsuficienteException extends RuntimeException{
    public EstoqueInsuficienteException(String mensagem) {
        super(mensagem);
    }
}
