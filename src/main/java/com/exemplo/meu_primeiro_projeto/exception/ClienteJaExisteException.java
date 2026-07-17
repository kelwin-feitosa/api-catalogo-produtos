package com.exemplo.meu_primeiro_projeto.exception;

public class ClienteJaExisteException extends RuntimeException{
    public ClienteJaExisteException(String mensagem) {
        super(mensagem);
    }
}
