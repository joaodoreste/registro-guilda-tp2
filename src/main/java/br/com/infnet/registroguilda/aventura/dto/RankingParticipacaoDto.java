package br.com.infnet.registroguilda.aventura.dto;

public class RankingParticipacaoDto {

    private final Long aventureiroId;
    private final String nomeAventureiro;
    private final Long totalParticipacoes;
    private final Double totalRecompensas;
    private final Long totalDestaques;

    public RankingParticipacaoDto(
            Long aventureiroId,
            String nomeAventureiro,
            Long totalParticipacoes,
            Number totalRecompensas,
            Number totalDestaques
    ) {
        this.aventureiroId = aventureiroId;
        this.nomeAventureiro = nomeAventureiro;
        this.totalParticipacoes = totalParticipacoes;
        this.totalRecompensas = totalRecompensas != null ? totalRecompensas.doubleValue() : 0.0;
        this.totalDestaques = totalDestaques != null ? totalDestaques.longValue() : 0L;
    }

    public Long getAventureiroId() {
        return aventureiroId;
    }

    public String getNomeAventureiro() {
        return nomeAventureiro;
    }

    public Long getTotalParticipacoes() {
        return totalParticipacoes;
    }

    public Double getTotalRecompensas() {
        return totalRecompensas;
    }

    public Long getTotalDestaques() {
        return totalDestaques;
    }
}