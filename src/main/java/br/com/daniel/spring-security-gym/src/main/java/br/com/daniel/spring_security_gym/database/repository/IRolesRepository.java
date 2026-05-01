package br.com.daniel.spring_security_gym.database.repository;

import br.com.daniel.spring_security_gym.database.model.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolesRepository extends JpaRepository<RolesEntity, Integer> {
}
