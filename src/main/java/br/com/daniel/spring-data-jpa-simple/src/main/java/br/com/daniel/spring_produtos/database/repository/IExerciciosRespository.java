package br.com.daniel.spring_produtos.database.repository;

import br.com.daniel.spring_produtos.database.model.ExerciciosEntity;
import jakarta.persistence.NamedNativeQuery;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.lang.annotation.Native;
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
