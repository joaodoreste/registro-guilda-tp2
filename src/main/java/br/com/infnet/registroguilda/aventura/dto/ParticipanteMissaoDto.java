package br.com.infnet.registroguilda.aventura.dto;

import java.math.BigDecimal;

public record ParticipanteMissaoDto(
        Long aventureiroId,
        String nomeAventureiro,
        String papelNaMissao,
        BigDecimal recompensaOuro,
        Boolean destaque
) {
}