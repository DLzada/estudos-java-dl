package br.com.daniel.spring_produtos.database.repository;

import br.com.daniel.spring_produtos.database.model.ExerciciosEntity;
import br.com.daniel.spring_produtos.database.model.TreinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITreinosRespository extends JpaRepository<TreinosEntity, Integer> {
}
