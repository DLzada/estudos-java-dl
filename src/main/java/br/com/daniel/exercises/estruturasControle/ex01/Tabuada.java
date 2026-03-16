package estruturasControle.ex01;

import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {
        //Escreva um codigo onde o usuario entra com um número e seja gerada a tabuada de 1 até 10 desse número

        var scanner = new Scanner(System.in);

        System.out.println("Digite um numero para saber sua tabuada: ");
        int numero = scanner.nextInt();
        var resultado = 0;

        for (int i = 0; i <= 10; i++) {
            resultado = numero * i;
            System.out.printf("%s x %s = %s \n", numero, i, resultado);
        }

        scanner.close();
    }
}
