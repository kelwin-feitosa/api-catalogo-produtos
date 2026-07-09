package com.exemplo.meu_primeiro_projeto.dto;

import java.math.BigDecimal;

public record ProdutoResposta(
    Long id,
    String nome,
    BigDecimal preco,
    String descricao,
    Integer quantidadeEstoque
) {

}
