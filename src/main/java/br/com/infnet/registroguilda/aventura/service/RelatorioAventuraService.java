package br.com.infnet.registroguilda.aventura.service;

import br.com.infnet.registroguilda.aventura.dto.RankingParticipacaoDto;
import br.com.infnet.registroguilda.aventura.dto.RelatorioMissaoDto;
import br.com.infnet.registroguilda.aventura.repository.ParticipacaoMissaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RelatorioAventuraService {

    private final ParticipacaoMissaoRepository participacaoMissaoRepository;

    public List<RankingParticipacaoDto> gerarRanking(OffsetDateTime inicio, OffsetDateTime fim) {
        return participacaoMissaoRepository.gerarRanking(inicio, fim);
    }

    public List<RelatorioMissaoDto> gerarRelatorioMissoes(OffsetDateTime inicio, OffsetDateTime fim) {
        return participacaoMissaoRepository.gerarRelatorioMissoes(inicio, fim);
    }
}