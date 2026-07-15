package com.exemplo.meu_primeiro_projeto.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record CompraResponse(
    Long id,
    Long fornecedorId,
    LocalDateTime dataCompra,
    BigDecimal valorTotal,
    List<ItemCompraResponse> itens
) {
}