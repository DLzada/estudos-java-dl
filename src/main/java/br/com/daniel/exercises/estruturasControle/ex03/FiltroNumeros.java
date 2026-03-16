package estruturasControle.ex03;

import java.util.Scanner;

public class FiltroNumeros {
    public static void main(String[] args) {
        /*
        Escreva um código que o usuário entre com um primeiro número,
        um segundo número maior que o primeiro e escolhe entre a opção
        par e impar, com isso o código deve informar todos os números
        pares ou ímpares (de acordo com a seleção inicial) no intervalo
        de números informados, incluindo os números informados e em ordem decrescente;
        */

        var scanner = new Scanner(System.in);

        System.out.println("Informe o primeiro numero(menor): ");
        int n1 = scanner.nextInt();

        System.out.println("Informe o segundo numero(maior que o primeiro): ");
        int n2 = scanner.nextInt();

        if(n1 > n2){
            System.out.println("Erro: O numero 2 tem que ser maior que o numero 1!");
            return;
        }

        System.out.println("Escolha se quer selecionar par(1) impar(2):");
        int opcao = scanner.nextInt();

        System.out.println("\nResultados em ordem decrescente:");

        for (int i = n2; i >= n1 ; i--) {
            if (opcao == 1){
                if (i % 2 == 0){
                    System.out.println(i + " ");
                }
            } else if (opcao == 2) { // Se escolheu ÍMPAR
                if (i % 2 != 0) {
                    System.out.print(i + " ");
                }
            } else {
                System.out.println("Erro: opcao invalida");
            }
        }

        scanner.close();
    }
}
