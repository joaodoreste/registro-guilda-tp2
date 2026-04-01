package br.com.infnet.registroguilda.repository;

import br.com.infnet.registroguilda.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}