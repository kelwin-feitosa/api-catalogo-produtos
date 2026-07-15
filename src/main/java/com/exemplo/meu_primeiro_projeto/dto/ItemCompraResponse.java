package com.exemplo.meu_primeiro_projeto.dto;

import java.math.BigDecimal;

public record ItemCompraResponse(
    Long id,
    Long produtoId,
    String nomeProduto,
    Integer quantidade,
    BigDecimal precoCompra,
    BigDecimal subtotal
) {
}