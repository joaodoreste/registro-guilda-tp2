package br.com.infnet.registroguilda.aventura.repository;

import br.com.infnet.registroguilda.aventura.entity.Companheiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanheiroRepository extends JpaRepository<Companheiro, Long> {
}