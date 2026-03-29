package collections.ex05;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    /*
    Carrinho de Compras:
        Crie uma classe chamada "CarrinhoDeCompras" que representa um carrinho de compras online. O carrinho deve ser implementado como uma lista de itens. Cada item é representado por uma classe chamada "Item" que possui atributos como nome, preço e quantidade. Implemente os seguintes métodos:

        adicionarItem(String nome, double preco, int quantidade): Adiciona um item ao carrinho com o nome, preço e quantidade especificados.
        removerItem(String nome): Remove um item do carrinho com base no seu nome.
        calcularValorTotal(): Calcula e retorna o valor total do carrinho, levando em consideração o preço e a quantidade de cada item.
        exibirItens(): Exibe todos os itens presentes no carrinho, mostrando seus nomes, preços e quantidades.
    */

    private List<Item> listaItens;

    public CarrinhoDeCompras() {
        this.listaItens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        listaItens.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> itemParaRemover = new ArrayList<>();
        for (Item i: listaItens){
            if(i.getNome().equalsIgnoreCase(nome)){
                itemParaRemover.add(i);
            }
        }
        listaItens.removeAll(itemParaRemover);
    }

    public double calcularValorTotal(){
        double total = 0;
        for (Item item: listaItens){
            total += item.getPreco() * item.getQuantidade();
        }
        return total;
    }

    public void exibirItens(){
        if(listaItens.isEmpty()){
            System.out.println("O carrinho esta vazio!");
        }else {
            for (Item item: listaItens){
                System.out.println(item.toString());
            }
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        carrinho.adicionarItem("Celular", 1000.0, 2);
        System.out.println("O valor Total do carrinho é: " + carrinho.calcularValorTotal()  );
        carrinho.exibirItens();
    }
}
