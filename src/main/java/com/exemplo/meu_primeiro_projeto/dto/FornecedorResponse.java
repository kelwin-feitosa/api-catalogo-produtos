package com.exemplo.meu_primeiro_projeto.dto;

public record FornecedorResponse(
    Long id,
    String nome,
    String cnpj,
    String telefone
) {
}