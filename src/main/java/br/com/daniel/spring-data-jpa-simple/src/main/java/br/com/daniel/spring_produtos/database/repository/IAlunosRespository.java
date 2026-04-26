package br.com.daniel.spring_produtos.database.repository;

import br.com.daniel.spring_produtos.database.model.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlunosRespository extends JpaRepository<AlunosEntity, Integer> {
}
