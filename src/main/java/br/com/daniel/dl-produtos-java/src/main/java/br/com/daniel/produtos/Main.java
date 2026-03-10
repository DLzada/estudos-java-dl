package br.com.daniel.produtos;

import br.com.daniel.produtos.model.Categoria;
import br.com.daniel.produtos.model.Produto;
import br.com.daniel.produtos.repository.CategoriaCollectionRepository;
import br.com.daniel.produtos.repository.ProdutoCollectionRepository;
import br.com.daniel.produtos.view.Opcao;
import br.com.daniel.produtos.view.CategoriaView;
import br.com.daniel.produtos.view.OpcaoView;
import br.com.daniel.produtos.view.ProdutoView;

public class Main {
    public static void main(String[] args) {
        Opcao opcao = null;

        do {
            opcao = OpcaoView.select();

            if (opcao == null) break;

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
        Categoria categoria = CategoriaView.form(new Categoria());

        if (categoria != null) {
            CategoriaCollectionRepository.save(categoria);
            CategoriaView.sucesso(categoria);
        }
    }

    private static void cadastrarProduto() {

        Produto produto = ProdutoView.form(new Produto());

        if (produto != null) {
            ProdutoCollectionRepository.save(produto);
            ProdutoView.sucesso(produto);
        }
    }

    private static void consultarProdutoPorId() {}

    private static void consultarProdutoPorCategoria() {}

    private static void encerrarSistema(){
        System.exit(0);
    }
}