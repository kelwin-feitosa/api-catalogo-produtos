package com.exemplo.meu_primeiro_projeto.dto;

import java.math.BigDecimal;
import java.util.List;

public record CarrinhoResponse(
    Long id,
    BigDecimal valorTotal,
    List<ItemCarrinhoResponse> itens
) {
}