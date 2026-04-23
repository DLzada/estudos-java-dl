package br.com.daniel.spring_produtos.controller;

import br.com.daniel.spring_produtos.database.model.ProdutoEntity;
import br.com.daniel.spring_produtos.dto.ProdutoDto;
import br.com.daniel.spring_produtos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoEntity> findAll(){
        return produtoService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntity createProduct(@RequestBody ProdutoDto produtoDto){
        return produtoService.createProduct(produtoDto);
    }
}
