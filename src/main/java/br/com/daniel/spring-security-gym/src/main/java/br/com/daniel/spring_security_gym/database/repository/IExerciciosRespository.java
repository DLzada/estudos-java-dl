package br.com.daniel.spring_security_gym.database.repository;

import br.com.daniel.spring_security_gym.database.model.ExerciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IExerciciosRespository extends JpaRepository<ExerciciosEntity, Integer> {
    List<ExerciciosEntity> findAllByGrupoMuscular(String grupoMuscular);

//    @Query(value = """
//            SELECT e
//            FROM ExerciciosEntity e
//            WHERE UPPER(e.grupoMuscular) = UPPER(:grupoMuscular)
//            """)
//    List<ExerciciosEntity> findAllByGrupoMuscularJpql(@Param("gruposMuscular") String grupoMuscular);

}
