package br.com.daniel.produtos.repository;

import br.com.daniel.produtos.model.Produto;
import br.com.daniel.produtos.repository.CategoriaCollectionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

public class ProdutoCollectionRepository {
    private static List<Produto> produtos;

    static {
        produtos = new Vector<>();
        Produto celular = new Produto();
        celular.setNome("Iphone 11")
                .setDescricao("Celular da Apple")
                .setCategoria(CategoriaCollectionRepository.findById(2L))
                .setDataDeCadastro(LocalDateTime.now())
                .setPreco(BigDecimal.valueOf(1202));

        save(celular);
    }

    public static Produto save(Produto produto) {
        if(!produtos.contains(produto)){
            produto.setId((long)produtos.size() + 1);
            produtos.add(produto);

            return produto;
        }else {
            JOptionPane.showMessageDialog(null, "Ja existe um produto com o nome informado! ");
            return null;
        }
    }
}
