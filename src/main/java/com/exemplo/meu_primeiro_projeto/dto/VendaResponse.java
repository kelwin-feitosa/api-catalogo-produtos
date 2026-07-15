package com.exemplo.meu_primeiro_projeto.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record VendaResponse(
    Long id,
    Long clienteId,
    LocalDateTime dataVenda,
    BigDecimal valorTotal,
    List<ItemVendaResponse> itens
) {
}