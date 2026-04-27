package br.com.daniel.spring_produtos.database.repository;

import br.com.daniel.spring_produtos.database.model.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IAlunosRespository extends JpaRepository<AlunosEntity, Integer> {
    Optional<AlunosEntity> findByEmail(String email);

    @Query("SELECT a FROM AlunosEntity a JOIN FETCH a.avaliacaoFisica WHERE a.id = :alunoId")
    Optional<AlunosEntity> findByIdFetch(@Param("alunoId") Integer alunoId);
}
