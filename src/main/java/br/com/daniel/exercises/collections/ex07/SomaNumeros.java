package collections.ex07;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    /*
    Soma de Números
        Crie uma classe chamada "SomaNumeros" que possui uma lista de números inteiros como atributo. Implemente os seguintes métodos:

        adicionarNumero(int numero): Adiciona um número à lista de números.
        calcularSoma(): Calcula a soma de todos os números na lista e retorna o resultado.
        encontrarMaiorNumero(): Encontra o maior número na lista e retorna o valor.
        encontrarMenorNumero(): Encontra o menor número na lista e retorna o valor.
        exibirNumeros(): Retorna uma lista contendo todos os números presentes na lista.
    */

    private List<Integer> listaNumeros ;

    public SomaNumeros() {
        this.listaNumeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        this.listaNumeros.add(numero);
    }

    public int calcularSoma(){
        int soma = 0;
        for (Integer numero : listaNumeros)
            soma += numero;
        return soma;
    }

    public int encontrarMaiorNumero(){
        int maiorNumero = Integer.MIN_VALUE;
        if(!listaNumeros.isEmpty()){
            for (Integer numero : listaNumeros){
                if (numero >= maiorNumero){
                    maiorNumero = numero;
                }
            }
            return maiorNumero;
        }else {
            throw new RuntimeException("A lista esta vazia");
        }
    }

    public int encontrarMenorNumero(){
        int menorNumero = Integer.MAX_VALUE;
        if(!listaNumeros.isEmpty()){
            for (Integer numero : listaNumeros){
                if (numero <= menorNumero){
                    menorNumero = numero;
                }
            }
            return menorNumero;
        }else {
            throw new RuntimeException("A lista esta vazia");
        }
    }

    public void exibirNumeros(){
        if(!listaNumeros.isEmpty()){
            System.out.println(this.listaNumeros);
        }else {
            System.out.println("Hey bro, lista vazia");
        }
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionarNumero(5);
        somaNumeros.adicionarNumero(0);
        somaNumeros.adicionarNumero(0);
        somaNumeros.adicionarNumero(-2);
        somaNumeros.adicionarNumero(10);

        System.out.println("Números adicionados:");
        somaNumeros.exibirNumeros();

        System.out.println("Soma dos números = " + somaNumeros.calcularSoma());

        System.out.println("Maior número = " + somaNumeros.encontrarMaiorNumero());

        System.out.println("Menor número = " + somaNumeros.encontrarMenorNumero());
    }
}
