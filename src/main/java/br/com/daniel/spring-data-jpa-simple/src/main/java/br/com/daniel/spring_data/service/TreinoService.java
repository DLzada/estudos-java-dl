package br.com.daniel.spring_data.service;

import br.com.daniel.spring_data.database.model.AlunosEntity;
import br.com.daniel.spring_data.database.model.ExerciciosEntity;
import br.com.daniel.spring_data.database.model.TreinosEntity;
import br.com.daniel.spring_data.database.repository.IAlunosRespository;
import br.com.daniel.spring_data.database.repository.IExerciciosRespository;
import br.com.daniel.spring_data.database.repository.ITreinosRespository;
import br.com.daniel.spring_data.dto.TreinoDto;
import br.com.daniel.spring_data.exception.BadRequestException;
import br.com.daniel.spring_data.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TreinoService {

    private final IAlunosRespository alunosRespository;
    private final IExerciciosRespository exerciciosRespository;
    private final ITreinosRespository treinosRespository;

    public void criarTreino(TreinoDto treinoDto) throws NotFoundException, BadRequestException{
        Set<ExerciciosEntity> exercicios = new HashSet<>();
        AlunosEntity aluno = alunosRespository.findById(treinoDto.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Aluno nao encontrado"));

        TreinosEntity treino = treinosRespository.findByNomeAndAlunoId(treinoDto.getNome(), treinoDto.getAlunoId())
                .orElse(null);

        if(treino != null){
            throw new BadRequestException("Ja existe um treino com esse nome para esse aluno");
        }

        for(Integer exercicioId : treinoDto.getExerciciosIds()){
            ExerciciosEntity exercicio = exerciciosRespository.findById(exercicioId)
                    .orElseThrow(() -> new NotFoundException(String.format("Exercicio %s nao encontrado", exercicioId)));

            exercicios.add(exercicio);
        }

        treino = TreinosEntity.builder()
                .nome(treinoDto.getNome())
                .aluno(aluno)
                .exercicios(exercicios)
                .build();

        treinosRespository.save(treino);

    }
}
