package br.com.daniel.spring_produtos.service;

import br.com.daniel.spring_produtos.database.model.ExerciciosEntity;
import br.com.daniel.spring_produtos.database.repository.IExerciciosRespository;
import br.com.daniel.spring_produtos.dto.ExercicioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciciosService {
    private final IExerciciosRespository exerciciosRespository;
    
    public List<ExerciciosEntity> findAll(){
        return exerciciosRespository.findAll();
    }

    public void save(ExercicioDto exercicioDto){
        ExerciciosEntity exercicio = ExerciciosEntity.builder()
                .nome(exercicioDto.getNome())
                .grupoMuscular(exercicioDto.getGrupoMuscular())
                .build();

        exerciciosRespository.save(exercicio);
    }
}
