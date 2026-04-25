package br.com.daniel.spring_produtos.database.repository;

import br.com.daniel.spring_produtos.database.model.ExerciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IExerciciosRespository extends JpaRepository<ExerciciosEntity, Integer> {
}
