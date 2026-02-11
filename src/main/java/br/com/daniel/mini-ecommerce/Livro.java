package br.com.daniel.mini-ecommerce;

public class Livro extends Produto implements Descontavel{
    private String autor;

    public Livro(String autor, String nome, double preco) {
        super(nome, preco);
        this.autor = autor;
    }

    @Override
    public void aplicarDesconto(double porcentagem) {
        this.preco -= this.preco * (porcentagem / 100);
    }
}
