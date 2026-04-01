package br.com.infnet.registroguilda.aventura.service;

import br.com.infnet.registroguilda.aventura.dto.MissaoDetalheDto;
import br.com.infnet.registroguilda.aventura.dto.MissaoResumoDto;
import br.com.infnet.registroguilda.aventura.dto.ParticipanteMissaoDto;
import br.com.infnet.registroguilda.aventura.entity.Missao;
import br.com.infnet.registroguilda.aventura.entity.ParticipacaoMissao;
import br.com.infnet.registroguilda.aventura.repository.MissaoRepository;
import br.com.infnet.registroguilda.aventura.repository.ParticipacaoMissaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MissaoConsultaService {

    private final MissaoRepository missaoRepository;
    private final ParticipacaoMissaoRepository participacaoMissaoRepository;

    public Page<MissaoResumoDto> listar(String status, String nivelPerigo, OffsetDateTime inicio, OffsetDateTime fim, Pageable pageable) {
        Page<Missao> pagina;

        if (status != null && nivelPerigo != null) {
            pagina = missaoRepository.findByStatusIgnoreCaseAndNivelPerigoIgnoreCase(status, nivelPerigo, pageable);
        } else if (status != null) {
            pagina = missaoRepository.findByStatusIgnoreCase(status, pageable);
        } else if (nivelPerigo != null) {
            pagina = missaoRepository.findByNivelPerigoIgnoreCase(nivelPerigo, pageable);
        } else if (inicio != null && fim != null) {
            pagina = missaoRepository.findByDataInicioBetween(inicio, fim, pageable);
        } else {
            pagina = missaoRepository.findAll(pageable);
        }

        return pagina.map(m -> new MissaoResumoDto(
                m.getId(),
                m.getTitulo(),
                m.getStatus(),
                m.getNivelPerigo(),
                m.getDataInicio(),
                m.getDataTermino()
        ));
    }

    public MissaoDetalheDto detalhar(Long id) {
        Missao missao = missaoRepository.findById(id).orElseThrow();

        List<ParticipanteMissaoDto> participantes = participacaoMissaoRepository.findByMissaoId(id)
                .stream()
                .map(this::mapearParticipante)
                .toList();

        return new MissaoDetalheDto(
                missao.getId(),
                missao.getTitulo(),
                missao.getStatus(),
                missao.getNivelPerigo(),
                missao.getCreatedAt(),
                missao.getDataInicio(),
                missao.getDataTermino(),
                participantes
        );
    }

    private ParticipanteMissaoDto mapearParticipante(ParticipacaoMissao participacao) {
        return new ParticipanteMissaoDto(
                participacao.getAventureiro().getId(),
                participacao.getAventureiro().getNome(),
                participacao.getPapelNaMissao(),
                participacao.getRecompensaOuro(),
                participacao.getDestaque()
        );
    }
}