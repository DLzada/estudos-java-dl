package br.com.daniel.produtos;

import br.com.daniel.produtos.model.Categoria;
import br.com.daniel.produtos.repository.CategoriaCollectionRepository;
import br.com.daniel.produtos.view.Opcao;
import br.com.daniel.produtos.view.CategoriaView;
import br.com.daniel.produtos.view.OpcaoView;
import br.com.daniel.produtos.view.ProdutoView;

public class Main {
    public static void main(String[] args) {
        Opcao opcao = null;

        do {
            opcao = OpcaoView.select();

            switch (opcao) {
                case CADASTRAR_CATEGORIA -> cadastrarCategoria();
                case CADASTRAR_PRODUTO -> cadastrarProduto();
                case CONSULTAR_PRODUTO_POR_ID -> consultarProdutoPorId();
                case CONSULTAR_PRODUTO_POR_CATEGORIA -> consultarProdutoPorCategoria();
                case ENCERRAR_SISTEMA -> encerrarSistema();
            }
        } while (opcao != Opcao.ENCERRAR_SISTEMA);
    }

    private static void cadastrarCategoria() {
        CategoriaView view = new CategoriaView();
        Categoria categoria = view.form();
        CategoriaCollectionRepository.save(categoria);
        view.sucesso(categoria);
    }

    private static void cadastrarProduto() {

        Produto produto = ProdutoView.form(produto);
        ProdutoCollectionRepository.save(produto);
        ProdutoView.sucesso();
    }

    private static void consultarProdutoPorId() {
    }

    private static void consultarProdutoPorCategoria() {
    }

    private static void encerrarSistema(){
        System.exit(0);
    }
}