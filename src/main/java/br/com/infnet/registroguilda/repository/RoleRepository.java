package br.com.infnet.registroguilda.repository;

import br.com.infnet.registroguilda.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}