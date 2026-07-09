package com.exemplo.meu_primeiro_projeto.exception;

import java.time.LocalDateTime;

public record RespostaErro(
    String mensagem,
    String detalhes,
    LocalDateTime timestamp
) { }
