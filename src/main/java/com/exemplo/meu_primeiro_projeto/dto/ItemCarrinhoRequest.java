package com.exemplo.meu_primeiro_projeto.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ItemCarrinhoRequest(
    
    @NotNull(message = "O produto é obrigatório.")
    Long produtoId,

    @NotNull(message = "A quantidade é obrigatória.")
    @Positive(message = "A quantidade deve ser maior que zero.")
    Integer quantidade
) {
}