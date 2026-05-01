package br.com.daniel.spring_security_gym.database.repository;

import br.com.daniel.spring_security_gym.database.model.TreinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITreinosRespository extends JpaRepository<TreinosEntity, Integer> {
    Optional<TreinosEntity>findByNomeAndAlunoId(String nome, Integer alunoId);
}
