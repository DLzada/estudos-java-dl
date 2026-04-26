package br.com.daniel.spring_produtos.database.repository;

import br.com.daniel.spring_produtos.database.model.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAlunosRespository extends JpaRepository<AlunosEntity, Integer> {
    Optional<AlunosEntity> findByEmail(String email);
}
