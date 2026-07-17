package com.exemplo.meu_primeiro_projeto.exception;

public class FornecedorNaoEncontradoException extends RuntimeException{
    public FornecedorNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
