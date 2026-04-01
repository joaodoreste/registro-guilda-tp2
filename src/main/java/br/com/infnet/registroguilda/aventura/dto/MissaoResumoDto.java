package br.com.infnet.registroguilda.aventura.dto;

import java.time.OffsetDateTime;

public record MissaoResumoDto(
        Long id,
        String titulo,
        String status,
        String nivelPerigo,
        OffsetDateTime dataInicio,
        OffsetDateTime dataTermino
) {
}