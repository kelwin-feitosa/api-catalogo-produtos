package com.exemplo.meu_primeiro_projeto.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ItemVendaRequest(
    
    @NotNull(message = "O produto é obrigatório.")
    Long produtoId,

    @NotNull(message = "A quantidade é obrigatória.")
    @Positive
    Integer quantidade
) {
}