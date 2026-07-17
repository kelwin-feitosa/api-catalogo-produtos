package com.exemplo.meu_primeiro_projeto.exception;

public class ClienteEmailJaExisteException extends RuntimeException{
    public ClienteEmailJaExisteException(String mensagem) {
        super(mensagem);
    }
}

