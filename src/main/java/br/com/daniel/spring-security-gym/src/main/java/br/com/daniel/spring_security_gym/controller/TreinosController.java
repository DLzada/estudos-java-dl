package br.com.daniel.spring_security_gym.controller;

import br.com.daniel.spring_security_gym.dto.TreinoDto;
import br.com.daniel.spring_security_gym.exception.BadRequestException;
import br.com.daniel.spring_security_gym.exception.NotFoundException;
import br.com.daniel.spring_security_gym.service.TreinoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/treinos")
@RequiredArgsConstructor
@Validated
public class TreinosController {

    private final TreinoService treinoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarTreino(@Valid @RequestBody TreinoDto treinoDto) throws NotFoundException, BadRequestException {
        treinoService.criarTreino(treinoDto);
    }
}
