package br.com.daniel.dl-produtos-java;
import br.com.daniel.produtos.model.Categoria;
import br.com.daniel.produtos.model.Produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Categoria categoria = new Categoria();
        categoria.setId(1L).setNome("Eletronicos");

        Produto produto = new Produto();
        produto.setId(1L)
                .setNome("Batedeira")
                .setDescricao("Bate Bem")
                .setCategoria(categoria)
                .setDataDeCadastro(LocalDateTime.now())
                .setPreco(BigDecimal.valueOf(150));

        System.out.println("Categoria:" + categoria);
        System.out.println("Produto: " + produto);
    }
}