package ex04;

import java.util.Scanner;

public class DiferencaIdades {
    public static void main(String[] args) {
        // Escreva um codigo que receba o nome e a idade de 2 pessoas e imprima a diferença de idade entre elas
        var scanner = new Scanner(System.in);

        System.out.println("Informe o nome da pessoa 1: ");
        var nome1 = scanner.next();

        System.out.println("Informe idade da pessoa 1: ");
        int idade1 = scanner.nextInt();

        System.out.println("Informe o nome da pessoa 2: ");
        var nome2 = scanner.next();

        System.out.println("Informe idade da pessoa 2: ");
        int idade2 = scanner.nextInt();

        var diferencaIdades = Math.abs(idade1 - idade2);

        System.out.printf("A diferenca das idades é: %s \n", diferencaIdades);
    }
}
