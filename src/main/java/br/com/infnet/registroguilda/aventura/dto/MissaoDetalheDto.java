package br.com.infnet.registroguilda.aventura.dto;

import java.time.OffsetDateTime;
import java.util.List;

public record MissaoDetalheDto(
        Long id,
        String titulo,
        String status,
        String nivelPerigo,
        OffsetDateTime createdAt,
        OffsetDateTime dataInicio,
        OffsetDateTime dataTermino,
        List<ParticipanteMissaoDto> participantes
) {
}