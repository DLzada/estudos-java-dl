package collections.ex09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    /*
    Ordenação de Números
        Crie uma classe chamada "OrdenacaoNumeros" que possui uma lista de números inteiros como atributo. Implemente os seguintes métodos:

        adicionarNumero(int numero): Adiciona um número à lista.
        ordenarAscendente(): Ordena os números da lista em ordem ascendente usando a interface Comparable e a class Collections.
        ordenarDescendente(): Ordena os números da lista em ordem descendente usando um Comparable e a class Collections.
     */

    private List<Integer> listaNumeros ;

    public OrdenacaoNumeros() {
        this.listaNumeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        this.listaNumeros.add(numero);
    }

    public List<Integer> ordenarAscendente(){
        List<Integer> numerosAscendentes = new ArrayList<>(this.listaNumeros);

        if(!numerosAscendentes.isEmpty()){
            Collections.sort(numerosAscendentes);
            return numerosAscendentes;
        }else {
            throw new RuntimeException("A lista esta vazia");
        }
    }

    public List<Integer> ordenarDescendente(){
        List<Integer> numerosAscendente = new ArrayList<>(this.listaNumeros);

        if(!numerosAscendente.isEmpty()){
            numerosAscendente.sort(Collections.reverseOrder());
            return numerosAscendente;
        }else {
            throw new RuntimeException("A lista esta vazia");
        }
    }

    public void exibirNumeros() {
        if (!listaNumeros.isEmpty()) {
            System.out.println(this.listaNumeros);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        OrdenacaoNumeros numeros = new OrdenacaoNumeros();

        numeros.adicionarNumero(2);
        numeros.adicionarNumero(5);
        numeros.adicionarNumero(4);
        numeros.adicionarNumero(1);
        numeros.adicionarNumero(99);

        numeros.exibirNumeros();

        System.out.println(numeros.ordenarAscendente());

        numeros.exibirNumeros();

        System.out.println(numeros.ordenarDescendente());

        numeros.exibirNumeros();
    }
}
