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
}
