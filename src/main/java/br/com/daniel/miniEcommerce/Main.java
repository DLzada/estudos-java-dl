package br.com.daniel.miniEcommerce;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Produto> lista = new ArrayList<>();

        //Adicionando produtos na loja
        lista.add(new Livro("Java Efetivo", 150.0, "Joshua Bloch"));
        lista.add(new Livro("Clean Code", 120, "Fulano de Tal"));
        lista.add(new Eletronico("Smartphone S24", 2000.0, "Samsung"));
        lista.add(new Eletronico("Notebook Dell", 4500.0, "Dell"));

        System.out.println("--- Processando Produtos ---");

        for (Produto p : lista) {
            System.out.println("Produto: " + p.getNome() + " | Preço Original: R$ "  + p.getPreco());

            // checando se o produto implementa a interface Descontavel
            if (p instanceof Descontavel d) {
                d.aplicarDesconto(10);
                System.out.println(" -> [DESCONTO APLICADO] Novo Preço: R$ " + p.getPreco());
            } else {
                System.out.println(" -> [SEM DESCONTO] Eletrônicos não são descontáveis.");
            }
        }
    }
}
