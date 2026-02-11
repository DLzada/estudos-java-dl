package br.com.daniel.mini-ecommerce;

class Eletronico extends Produto{
    private String marca;

    public Eletronico(String nome, double preco, String marca) {
        super(nome, preco);
        this.marca = marca;
    }
}
