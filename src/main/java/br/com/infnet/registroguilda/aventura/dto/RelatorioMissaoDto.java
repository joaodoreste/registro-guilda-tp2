package br.com.infnet.registroguilda.aventura.dto;

public class RelatorioMissaoDto {

    private final Long missaoId;
    private final String titulo;
    private final String status;
    private final String nivelPerigo;
    private final Long quantidadeParticipantes;
    private final Double totalRecompensas;

    public RelatorioMissaoDto(
            Long missaoId,
            String titulo,
            String status,
            String nivelPerigo,
            Long quantidadeParticipantes,
            Number totalRecompensas
    ) {
        this.missaoId = missaoId;
        this.titulo = titulo;
        this.status = status;
        this.nivelPerigo = nivelPerigo;
        this.quantidadeParticipantes = quantidadeParticipantes;
        this.totalRecompensas = totalRecompensas != null ? totalRecompensas.doubleValue() : 0.0;
    }

    public Long getMissaoId() {
        return missaoId;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getStatus() {
        return status;
    }

    public String getNivelPerigo() {
        return nivelPerigo;
    }

    public Long getQuantidadeParticipantes() {
        return quantidadeParticipantes;
    }

    public Double getTotalRecompensas() {
        return totalRecompensas;
    }
}