package com.exemplo.meu_primeiro_projeto.dto;

import jakarta.validation.constraints.NotNull;

public record CompraRequest(

    @NotNull(message = "O fornecedor é obrigatório.")
    Long fornecedorId
) {
}