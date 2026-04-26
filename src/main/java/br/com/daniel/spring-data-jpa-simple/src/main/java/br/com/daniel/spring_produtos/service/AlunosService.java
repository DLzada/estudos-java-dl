package br.com.daniel.spring_produtos.service;

import br.com.daniel.spring_produtos.database.repository.IAlunosRespository;
import br.com.daniel.spring_produtos.dto.AlunoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunosService {
    private final IAlunosRespository alunosRespository;

    public void criarAluno(AlunoDto alunoDto){
    }
}
