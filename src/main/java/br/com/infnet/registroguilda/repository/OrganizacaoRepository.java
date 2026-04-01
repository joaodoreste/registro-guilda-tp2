package br.com.infnet.registroguilda.repository;

import br.com.infnet.registroguilda.entity.Organizacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizacaoRepository extends JpaRepository<Organizacao, Long> {
}