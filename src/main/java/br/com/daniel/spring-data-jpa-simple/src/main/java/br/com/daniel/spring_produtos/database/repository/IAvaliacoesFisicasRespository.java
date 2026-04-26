package br.com.daniel.spring_produtos.database.repository;

import br.com.daniel.spring_produtos.database.model.AvaliacoesFisicasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAvaliacoesFisicasRespository extends JpaRepository<AvaliacoesFisicasEntity, Integer> {
}
