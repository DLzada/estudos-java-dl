package br.com.daniel.spring_produtos.controller;

import br.com.daniel.spring_produtos.database.model.AvaliacoesFisicasEntity;
import br.com.daniel.spring_produtos.database.model.ExerciciosEntity;
import br.com.daniel.spring_produtos.dto.AlunoDto;
import br.com.daniel.spring_produtos.dto.ExercicioDto;
import br.com.daniel.spring_produtos.exception.BadRequestException;
import br.com.daniel.spring_produtos.exception.NotFoundException;
import br.com.daniel.spring_produtos.service.AlunosService;
import br.com.daniel.spring_produtos.service.ExerciciosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
