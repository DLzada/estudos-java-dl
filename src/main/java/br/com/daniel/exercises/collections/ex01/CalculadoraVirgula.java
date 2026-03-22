package collections.ex01;

//1 - Escreva um código que cria uma calculadora para as operações de soma e subtração, o usuário deve informar todos os números que serão usados na conta de uma só vez utilizando virgulas para separa-los.

import java.util.Scanner;

public class CalculadoraVirgula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Calculadora de Soma e Subtração ---");
        System.out.println("Digite os números separados por vírgula (ex: 10,5,2):");

        String entrada = scanner.nextLine();

        String[] numerosStr = entrada.split(",");

        double soma = 0;
        double subtracao = 0;
        boolean primeiroNumero = true;

        for (String s : numerosStr) {
            double num = Double.parseDouble(s.trim());

            soma += num;

            if (primeiroNumero) {
                subtracao = num;
                primeiroNumero = false;
            } else {
                subtracao -= num;
            }
        }

        System.out.println("\n--- Resultados ---");
        System.out.println("Total da Soma: " + soma);
        System.out.println("Total da Subtração: " + subtracao);

        scanner.close();
    }
}