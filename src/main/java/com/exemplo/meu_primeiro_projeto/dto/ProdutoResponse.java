package com.exemplo.meu_primeiro_projeto.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProdutoResponse(
    Long id,
    String nome,
    BigDecimal preco,
    String descricao,
    Integer quantidadeEstoque,
    Long categoriaId,
    LocalDateTime dataCadastro
) {
}