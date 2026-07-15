package com.exemplo.meu_primeiro_projeto.dto;

import jakarta.validation.constraints.NotNull;

public record CarrinhoRequest(
    
    @NotNull(message = "O cliente é obrigatório.")
    Long clienteId
) {
}