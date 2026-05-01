package br.com.daniel.spring_data.database.repository;

import br.com.daniel.spring_data.database.model.AvaliacoesFisicasEntity;
import br.com.daniel.spring_data.dto.AvaliacoesFisicasProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IAvaliacoesFisicasRespository extends JpaRepository<AvaliacoesFisicasEntity, Integer> {

    @Query(value = """
    SELECT a.id as idAluno, 
           a.nome as nomeAluno, 
           af.id as idAvaliacao, 
           af.peso, 
           af.altura, 
           af.percentual_gordura_corporal as percentualGorduraCorporal
    FROM avaliacoes_fisicas af
    INNER JOIN alunos a ON a.avaliacao_fisica_id = af.id
    """, nativeQuery = true)
    List<AvaliacoesFisicasProjection> getAllAvaliacoes();

    @Query(value = "SELECT " +
            "a.id AS idAluno, " +
            "a.nome AS nomeAluno, " +
            "af.id AS idAvaliacao, " +
            "af.peso AS peso, " +
            "af.altura AS altura, " +
            "af.porcentagemGorduraCorporal AS percentualGorduraCorporal " +
            "FROM AlunosEntity a " +
            "JOIN a.avaliacaoFisica af",
            countQuery = "SELECT count(a) FROM AlunosEntity a JOIN a.avaliacaoFisica af")
    Page<AvaliacoesFisicasProjection> getAllAvaliacoesPageable(Pageable pageable);
}
