package br.com.daniel.produtos.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Produto {
    Long id;
    String nome;
    String descricao;
    BigDecimal preco;
    LocalDateTime dataDeCadastro;
    Categoria categoria;

    public Produto(){
    }

    public Produto(Long id, String nome, String descricao, BigDecimal preco, LocalDateTime dataDeCadastro, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.dataDeCadastro = dataDeCadastro;
        this.categoria = categoria;
    }

    public Produto(Categoria categoria, LocalDateTime dataDeCadastro, String descricao, String nome, BigDecimal preco) {
        this.categoria = categoria;
        this.dataDeCadastro = dataDeCadastro;
        this.descricao = descricao;
        this.nome = nome;
        this.preco = preco;
    }

    
}
