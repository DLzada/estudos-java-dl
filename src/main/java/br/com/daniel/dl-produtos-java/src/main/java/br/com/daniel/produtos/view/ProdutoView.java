package br.com.daniel.produtos.view;

import br.com.daniel.produtos.model.Categoria;
import br.com.daniel.produtos.model.Produto;
import java.util.List;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProdutoView {

    public static Produto form(Produto produto) {
        if (produto == null) produto = new Produto();

        Categoria categoria = null;
        do {
            categoria = CategoriaView.form(produto.getCategoria());
        } while (categoria == null);

        String nome = "";
        do {
            nome = JOptionPane.showInputDialog(null, "Informe o nome do produto", produto.getNome());
            if (nome == null) return null;
        } while (nome.trim().isEmpty());

        String descricao = "";
        do {
            descricao = JOptionPane.showInputDialog(null, "Informe a descrição do produto", produto.getDescricao());
            if (descricao == null) return null;
        } while (descricao.trim().isEmpty());

        double preco = 0;
        do {
            try {
                String inputPreco = JOptionPane.showInputDialog(null, "Informe o preço do produto", produto.getPreco());
                if (inputPreco == null) return null;
                preco = Double.parseDouble(inputPreco);
            } catch (Exception e) {
                preco = 0;
            }
        } while (preco <= 0);

        Produto ret = new Produto();
        ret.setCategoria(categoria)
                .setNome(nome)
                .setDescricao(descricao)
                .setDataDeCadastro(LocalDateTime.now())
                .setPreco(BigDecimal.valueOf(preco));

        return ret;
    }

    public static void sucesso() {
        JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
    }

    public static void sucesso(Produto produto) {
        JOptionPane.showMessageDialog(null, "Produto " + produto.getNome() + " salvo com sucesso!");
    }

    public static Produto select(List<Produto> produtos) {
        if (produtos == null || produtos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum produto encontrado.");
            return null;
        }

        Object[] opcoes = produtos.toArray();

        return (Produto) JOptionPane.showInputDialog(
                null,
                "Selecione um produto",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );
    }

    public static void update(Produto produto) {
        Produto atualizado = form(produto);
        if (atualizado != null) {
            sucesso(atualizado);
            show(atualizado);
        }
    }

    private static void show(Produto p) {
        String textoFormatado = String.format(
                "Produto: %s%n" +
                        "Descrição: %s%n" +
                        "Categoria: %s%n" +
                        "Preço: R$ %,.2f",
                p.getNome(),
                p.getDescricao(),
                p.getCategoria() != null ? p.getCategoria().toString() : "N/A",
                p.getPreco()
        );

        JOptionPane.showMessageDialog(null, textoFormatado);
    }
}