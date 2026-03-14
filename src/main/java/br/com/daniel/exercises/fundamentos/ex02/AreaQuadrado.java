package ex02;

import java.util.Scanner;

public class AreaQuadrado {
    public static void main(String[] args) {
        // Escreva um código que receba o tamanho do lado de um quadrado, caldule sua área e exiba na tela:
        // Formula: area = lado x lado

        var scanner = new Scanner(System.in);

        System.out.println("Informe o valor de um lado do quadrado: ");
        var lado = scanner.nextFloat();
        float area = (float) Math.pow(lado, 2);

        System.out.printf("A area do quadrado é: %s \n", area);
    }
}
