package ex3;

import java.util.Scanner;

public class AreaRetangulo {
    public static void main(String[] args) {
        // Escreva um código que receba a base e altura de um retangulo, e calcule sua área e exia na tela
        // formula: area = base x altura

        var scanner = new Scanner(System.in);

        System.out.println("Digite a base: ");
        int base = scanner.nextInt();

        System.out.println("Digite a altura: ");
        int altura = scanner.nextInt();

        int area = base * altura;

        System.out.printf("A area do retangulo é: %s \n", area);
    }
}
