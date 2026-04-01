package br.com.infnet.registroguilda.aventura.dto;

public record AventureiroResumoDto(
        Long id,
        String nome,
        String classe,
        Integer nivel,
        Boolean ativo
) {
}