package br.com.daniel.spring_produtos.service;

import br.com.daniel.spring_produtos.database.repository.IAlunosRespository;
import br.com.daniel.spring_produtos.database.repository.IExerciciosRespository;
import br.com.daniel.spring_produtos.database.repository.ITreinosRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TreinoService {

    private final IAlunosRespository alunosRespository;
    private final IExerciciosRespository exerciciosRespository;
    private final ITreinosRespository treinosRespository;

}
