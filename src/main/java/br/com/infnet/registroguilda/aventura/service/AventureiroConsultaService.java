package br.com.infnet.registroguilda.aventura.service;

import br.com.infnet.registroguilda.aventura.dto.AventureiroPerfilDto;
import br.com.infnet.registroguilda.aventura.dto.AventureiroResumoDto;
import br.com.infnet.registroguilda.aventura.entity.Aventureiro;
import br.com.infnet.registroguilda.aventura.entity.ParticipacaoMissao;
import br.com.infnet.registroguilda.aventura.repository.AventureiroRepository;
import br.com.infnet.registroguilda.aventura.repository.ParticipacaoMissaoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
@RequiredArgsConstructor
public class AventureiroConsultaService {

    private final AventureiroRepository aventureiroRepository;
    private final ParticipacaoMissaoRepository participacaoMissaoRepository;

    public Page<AventureiroResumoDto> listar(Boolean ativo, String classe, Integer nivelMinimo, Pageable pageable) {
        Page<Aventureiro> pagina;

        if (ativo != null && classe != null && nivelMinimo != null) {
            pagina = aventureiroRepository.findByAtivoAndClasseIgnoreCaseAndNivelGreaterThanEqual(
                    ativo, classe, nivelMinimo, pageable
            );
        } else if (ativo != null) {
            pagina = aventureiroRepository.findByAtivo(ativo, pageable);
        } else if (classe != null) {
            pagina = aventureiroRepository.findByClasseIgnoreCase(classe, pageable);
        } else if (nivelMinimo != null) {
            pagina = aventureiroRepository.findByNivelGreaterThanEqual(nivelMinimo, pageable);
        } else {
            pagina = aventureiroRepository.findAll(pageable);
        }

        return pagina.map(a -> new AventureiroResumoDto(
                a.getId(),
                a.getNome(),
                a.getClasse(),
                a.getNivel(),
                a.getAtivo()
        ));
    }

    public Page<AventureiroResumoDto> buscarPorNome(String nome, Pageable pageable) {
        return aventureiroRepository.findByNomeContainingIgnoreCase(nome, pageable)
                .map(a -> new AventureiroResumoDto(
                        a.getId(),
                        a.getNome(),
                        a.getClasse(),
                        a.getNivel(),
                        a.getAtivo()
                ));
    }

    @Transactional
    public AventureiroPerfilDto buscarPerfil(Long id) {
        Aventureiro aventureiro = aventureiroRepository.findById(id).orElseThrow();

        long totalParticipacoes = participacaoMissaoRepository.countByAventureiroId(id);

        String ultimaMissao = aventureiro.getParticipacoes().stream()
                .max(Comparator.comparing(ParticipacaoMissao::getDataRegistro))
                .map(p -> p.getMissao().getTitulo())
                .orElse(null);

        String nomeCompanheiro = aventureiro.getCompanheiro() != null ? aventureiro.getCompanheiro().getNome() : null;
        String especieCompanheiro = aventureiro.getCompanheiro() != null ? aventureiro.getCompanheiro().getEspecie() : null;

        return new AventureiroPerfilDto(
                aventureiro.getId(),
                aventureiro.getNome(),
                aventureiro.getClasse(),
                aventureiro.getNivel(),
                aventureiro.getAtivo(),
                nomeCompanheiro,
                especieCompanheiro,
                totalParticipacoes,
                ultimaMissao
        );
    }
}