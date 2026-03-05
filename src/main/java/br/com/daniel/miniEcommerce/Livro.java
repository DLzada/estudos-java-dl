package br.com.daniel.miniEcommerce;

public class Livro extends Produto implements Descontavel {
    private String autor;

    public Livro(String nome, double preco, String autor) {
        super(nome, preco);
        this.autor = autor;
    }

    @Override
    public void aplicarDesconto(double porcentagem) {
        this.preco -= this.preco * (porcentagem / 100);
    }
}
