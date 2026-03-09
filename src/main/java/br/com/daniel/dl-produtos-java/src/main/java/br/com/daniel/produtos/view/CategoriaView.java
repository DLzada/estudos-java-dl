package br.com.daniel.produtos.view;

import br.com.daniel.produtos.model.Categoria;
import br.com.daniel.produtos.repository.CategoriaCollectionRepository;
import javax.swing.*;

public class CategoriaView {

    private static CategoriaCollectionRepository repository = new CategoriaCollectionRepository();

    public static Categoria select(Categoria categoria) {
        Object[] opcoes = repository.findAll().toArray();

        if (opcoes.length == 0) {
            JOptionPane.showMessageDialog(null, "Nenhuma categoria cadastrada!");
            return null;
        }

        Categoria ret = (Categoria) JOptionPane.showInputDialog(
                null,
                "Selecione uma categoria",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                categoria
        );

        return ret;
    }

    public static void sucesso() {
        JOptionPane.showMessageDialog(null, "Categoria foi salva com sucesso!");
    }

    public static void sucesso(Categoria categoria) {
        JOptionPane.showMessageDialog(null, "Categoria " + categoria.getNome() + " foi salva com sucesso!");
    }

    public static Categoria form(Categoria categoria) {
        String nomeOriginal = (categoria != null) ? categoria.getNome() : "";

        String nome = JOptionPane.showInputDialog(null, "Informe o nome da Categoria ", nomeOriginal);

        if (nome == null) return null;

        return new Categoria(nome);
    }
}