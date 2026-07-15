package com.exemplo.meu_primeiro_projeto.dto;

public record ClienteResponse(
    Long id,
    String nome,
    String email,
    String telefone
) {
}