package br.com.daniel.spring_data.service;

import br.com.daniel.spring_data.database.model.ExerciciosEntity;
import br.com.daniel.spring_data.database.repository.IExerciciosRespository;
import br.com.daniel.spring_data.dto.ExercicioDto;
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

    public List<ExerciciosEntity> getExerciciosByGrupoMuscular(String grupoMuscular){
        return exerciciosRespository.findAllByGrupoMuscular(grupoMuscular);
    }
}
