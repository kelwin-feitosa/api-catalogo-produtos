package com.exemplo.meu_primeiro_projeto.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record ProdutoRequest(
    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    String nome,

    @NotNull(message = "O preço é obrigatório.")
    @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero.")
    BigDecimal preco,

    @NotBlank(message = "A descrição é obrigatória.")
    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres.")
    String descricao,

    @NotNull(message = "A quantidade em estoque é obrigatória.")
    @PositiveOrZero(message = "O estoque não pode ser negativo.")
    Integer quantidadeEstoque,

    @NotNull(message = "A categoria é obrigatória.")
    Long categoriaId
) {
}