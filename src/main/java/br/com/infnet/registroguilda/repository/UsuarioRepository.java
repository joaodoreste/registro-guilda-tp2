package br.com.infnet.registroguilda.repository;

import br.com.infnet.registroguilda.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}