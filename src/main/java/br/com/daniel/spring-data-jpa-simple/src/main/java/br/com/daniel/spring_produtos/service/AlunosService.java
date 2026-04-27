package br.com.daniel.spring_produtos.service;

import br.com.daniel.spring_produtos.database.model.AlunosEntity;
import br.com.daniel.spring_produtos.database.model.AvaliacoesFisicasEntity;
import br.com.daniel.spring_produtos.database.repository.IAlunosRespository;
import br.com.daniel.spring_produtos.dto.AlunoDto;
import br.com.daniel.spring_produtos.exception.BadRequestException;
import br.com.daniel.spring_produtos.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunosService {
    private final IAlunosRespository alunosRespository;

    public void criarAluno(AlunoDto alunoDto) throws BadRequestException{
        AlunosEntity aluno = alunosRespository.findByEmail(alunoDto.getEmail())
                .orElse(null);

        if(aluno != null){
            throw new BadRequestException("Aluno ja cadastrado com este email");
        }

        alunosRespository.save(AlunosEntity.builder()
                        .nome(alunoDto.getNome())
                        .email(alunoDto.getEmail())
                        .build());
    }

    public AvaliacoesFisicasEntity getAlunoAvaliacoes(Integer alunoId) throws NotFoundException {
        AlunosEntity aluno = alunosRespository.findById(alunoId)
                .orElseThrow(() -> new NotFoundException("Aluno nao encontrada"));

        AvaliacoesFisicasEntity avaliacao = aluno.getAvaliacaoFisica();
        if(avaliacao == null){
            throw new NotFoundException("Avaliacao fisica nao encontrada para este aluno");
        }
        return avaliacao;
    }
}
