package br.com.daniel.spring_security_gym.controller;

import br.com.daniel.spring_security_gym.database.model.AvaliacoesFisicasEntity;
import br.com.daniel.spring_security_gym.dto.AlunoDto;
import br.com.daniel.spring_security_gym.exception.BadRequestException;
import br.com.daniel.spring_security_gym.exception.NotFoundException;
import br.com.daniel.spring_security_gym.service.AlunosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/alunos")
@RequiredArgsConstructor
@Validated
public class AlunosController {

    private final AlunosService alunosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAluno(@Valid @RequestBody AlunoDto alunoDto) throws BadRequestException  {
        alunosService.criarAluno(alunoDto);
    }

    @GetMapping("/{alunoId}/avaliacao")
    @ResponseStatus(HttpStatus.OK)
    public AvaliacoesFisicasEntity getAvaliacaoFisica(@PathVariable Integer alunoId) throws NotFoundException {
        return alunosService.getAlunoAvaliacoes(alunoId);
    }


    @DeleteMapping("/{alunoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAluno(@PathVariable Integer alunoId) throws NotFoundException{
        alunosService.deletarAluno(alunoId);
    }
}
