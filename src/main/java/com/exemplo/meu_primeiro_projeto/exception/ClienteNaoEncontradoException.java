package com.exemplo.meu_primeiro_projeto.exception;

public class ClienteNaoEncontradoException extends RuntimeException{
    public ClienteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
