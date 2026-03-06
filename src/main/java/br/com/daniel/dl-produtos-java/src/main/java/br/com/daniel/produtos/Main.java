package br.com.daniel.produtos;
import br.com.daniel.produtos.model.Categoria;
import br.com.daniel.produtos.repository.CategoriaCollectionRepository;
import br.com.daniel.produtos.model.Produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {
        Categoria categoria = new Categoria();
        categoria.setNome("informatica");

//        Produto produto = new Produto();
//        produto.setId(1L)
//                .setNome("Batedeira")
//                .setDescricao("Bate Bem")
//                .setCategoria(categoria)
//                .setDataDeCadastro(LocalDateTime.now())
//                .setPreco(BigDecimal.valueOf(150));

        Categoria categoriaSalva = CategoriaCollectionRepository.save(categoria);

        System.out.println("Categoria:" + categoriaSalva);
//        System.out.println("Produto: " + produto);
    }
}