package br.com.daniel.mini-ecommerce;

public abstract class Produto {
    protected String nome;
    protected double preco;

    public Produto(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
}
