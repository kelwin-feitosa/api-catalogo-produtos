package com.exemplo.meu_primeiro_projeto.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record ProdutoRequisicao(
    @NotBlank(message = "O nome não pode ficar em branco!")
    String nome,

    @NotNull(message = "O preço é obrigatório")
    @Positive(message = "O preço deve ser maior que zero!")
    BigDecimal preco,

    String descricao,

    @NotNull(message = "O estoque é obrigatório")
    @PositiveOrZero(message = "O estoque não pode ser negativo!")
    Integer quantidadeEstoque
) { }
