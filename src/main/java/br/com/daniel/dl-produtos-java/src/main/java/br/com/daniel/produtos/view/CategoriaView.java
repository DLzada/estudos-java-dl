package br.com.daniel.produtos.view;

import br.com.daniel.produtos.model.Categoria;
import br.com.daniel.produtos.repository.CategoriaCollectionRepository;
import javax.swing.*;

public class CategoriaView {

    // Tornamos o repository estático para ser usado no método estático
    private static CategoriaCollectionRepository repository = new CategoriaCollectionRepository();

    public static Categoria select(Categoria categoria) {
        // @formatter:off
        Object[] opcoes = repository.findAll().toArray();

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
        // @formatter:on
    }

    public void sucesso(){
        JOptionPane.showMessageDialog(null, "Categoria foi salva com sucesso!");
    }

    public void sucesso(Categoria categoria){
        JOptionPane.showMessageDialog(null, "Categoria "+ categoria.getNome() + "  foi salva com sucesso!");
    }

    public static Categoria form(){
        String nome = JOptionPane.showInputDialog(null, "Informe o nome da Categoria ");
        return new Categoria(nome);
    }
}