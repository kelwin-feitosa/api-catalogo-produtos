package com.exemplo.meu_primeiro_projeto.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClienteRequest(

    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    String nome,

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "E-mail inválido.")
    String email,

    @NotBlank(message = "O telefone é obrigatório.")
    @Size(min = 10, max = 11, message = "Telefone inválido.") //min 10 (sem o 9) max 11 (com o 9)
    String telefone

) {
}