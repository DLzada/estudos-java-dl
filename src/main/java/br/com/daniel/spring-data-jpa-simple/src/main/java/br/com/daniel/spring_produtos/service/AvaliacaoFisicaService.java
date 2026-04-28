package br.com.daniel.spring_produtos.service;

import br.com.daniel.spring_produtos.database.model.AlunosEntity;
import br.com.daniel.spring_produtos.database.model.AvaliacoesFisicasEntity;
import br.com.daniel.spring_produtos.database.repository.IAlunosRespository;
import br.com.daniel.spring_produtos.database.repository.IAvaliacoesFisicasRespository;
import br.com.daniel.spring_produtos.dto.AvaliacaoFisicaDto;
import br.com.daniel.spring_produtos.dto.AvaliacoesFisicasProjection;
import br.com.daniel.spring_produtos.exception.BadRequestException;
import br.com.daniel.spring_produtos.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaoFisicaService {
   private final IAlunosRespository alunosRespository;
   private final IAvaliacoesFisicasRespository avaliacoesFisicasRepository;

   public void criarAvaliacaoFisica(AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException{
       AlunosEntity aluno = alunosRespository.findById(avaliacaoFisicaDto.getAlunoId())
               .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

       AvaliacoesFisicasEntity avaliacaoFisica = aluno.getAvaliacaoFisica();
       if(avaliacaoFisica !=null){
           throw new BadRequestException("Avaliação fisica já cadastrada para este aluno");
       }

       avaliacaoFisica = AvaliacoesFisicasEntity.builder()
               .peso(avaliacaoFisicaDto.getPeso())
               .altura(avaliacaoFisicaDto.getAltura())
               .porcentagemGorduraCorporal(avaliacaoFisicaDto.getPorcentagemGorduraCorporal())
               .build();

       aluno.setAvaliacaoFisica(avaliacaoFisica);
       alunosRespository.save(aluno);
   }

   public List<AvaliacoesFisicasProjection> getAllAvaliacoes(){
       return avaliacoesFisicasRepository.getAllAvaliacoes();
   }

    public Page<AvaliacoesFisicasProjection> getAllAvaliacoesPageable(Integer page, Integer size){
        return avaliacoesFisicasRepository.getAllAvaliacoesPageable(PageRequest.of(page, size));
    }
}
