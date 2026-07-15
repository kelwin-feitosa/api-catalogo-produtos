package com.exemplo.meu_primeiro_projeto.dto;

import java.math.BigDecimal;

public record ItemVendaResponse(
    Long id,
    Long produtoId,
    String nomeProduto,
    Integer quantidade,
    BigDecimal precoUnitario,
    BigDecimal subtotal
) {
}