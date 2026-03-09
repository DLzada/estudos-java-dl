package br.com.daniel.produtos.view;

import br.com.daniel.produtos.model.Categoria;
import br.com.daniel.produtos.model.Produto;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProdutoView {
    public static Produto form() {

        Categoria categoria = null;
        do{
            categoria = CategoriaView.form();
        }while (categoria==null);

        String nome = "";
        do{
            nome = JOptionPane.showInputDialog(null, "Informe o nome do produto");
        }while (nome.equals(""));


        String descricao = "";
        do{
            descricao = JOptionPane.showInputDialog(null, "Informe a descrição do produto");
        }while (descricao.equals(""));


        double preco = 0;
        do{
            try {
                preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o preço do produto"));
            }catch (Exception e){
              preco = 0;
            }
        }while (preco<=0);

        Produto ret = new Produto();
        ret.setCategoria(categoria)
                .setNome(nome)
                .setDescricao(descricao)
                .setDataDeCadastro(LocalDateTime.now())
                .setPreco(BigDecimal.valueOf(preco));

        return ret;
    }

    public void sucesso(){
        JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
    }

    public void sucesso(Produto produto){
        JOptionPane.showMessageDialog(null, "Produto "+ produto.getNome() + " salvo com sucesso!");
    }

    public static Produto select(Produto produto) {
        // @formatter:off
        Object[] opcoes = repository.findAll().toArray();

        Produto ret = (Produto) JOptionPane.showInputDialog(
                null,
                "Selecione uma produto",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                produto
        );

        return ret;
        // @formatter:on
    }
}
