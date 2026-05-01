package br.com.daniel.spring_data.controller;

import br.com.daniel.spring_data.database.model.AvaliacoesFisicasEntity;
import br.com.daniel.spring_data.dto.AlunoDto;
import br.com.daniel.spring_data.exception.BadRequestException;
import br.com.daniel.spring_data.exception.NotFoundException;
import br.com.daniel.spring_data.service.AlunosService;
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
