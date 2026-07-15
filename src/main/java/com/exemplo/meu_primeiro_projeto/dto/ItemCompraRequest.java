package com.exemplo.meu_primeiro_projeto.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ItemCompraRequest(

    @NotNull(message = "O produto é obrigatório.")
    Long produtoId,

    @NotNull(message = "A quantidade é obrigatória.")
    @Positive
    Integer quantidade,

    @NotNull(message = "O preço de compra é obrigatório.")
    @DecimalMin(value = "0.01")
    BigDecimal precoCompra
) {
}