package br.com.infnet.registroguilda.aventura.dto;

public record AventureiroPerfilDto(
        Long id,
        String nome,
        String classe,
        Integer nivel,
        Boolean ativo,
        String nomeCompanheiro,
        String especieCompanheiro,
        Long totalParticipacoes,
        String ultimaMissao
) {
}