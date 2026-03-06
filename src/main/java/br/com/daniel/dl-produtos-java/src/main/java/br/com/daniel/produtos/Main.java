package br.com.daniel.produtos;
import br.com.daniel.produtos.model.Categoria;
import br.com.daniel.produtos.repository.CategoriaCollectionRepository;
import br.com.daniel.produtos.repository.ProdutoCollectionRepository;
import br.com.daniel.produtos.model.Produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {
//        Categoria categoria = new Categoria();
//        categoria.setNome("informatica");
//
//        Categoria categoriaSalva = CategoriaCollectionRepository.save(categoria);
//
//        System.out.println("Categoria:" + categoriaSalva);

        Produto produto = new Produto();
        produto .setNome("Kindle")
                .setDescricao("Somente Leitura")
                .setCategoria(CategoriaCollectionRepository.findByNome("eletrônicos").get(0))
                .setDataDeCadastro(LocalDateTime.now())
                .setPreco(BigDecimal.valueOf(150));

        Produto produto1 = ProdutoCollectionRepository.save(produto);

        System.out.println("ID: " + produto1.getId() + " Produto: " + produto1.getNome());
    }
}