package estruturasControle.ex04;

import java.util.Scanner;

public class Numeros {
    public static void main(String[] args) {
        /*
        Escreva um código onde o usuário informa um número inicial,
        posteriormente irá informar outros N números, a execução do
        código irá continuar até que o número informado dividido pelo
        primeiro número tenha resto diferente de 0 na divisão, números
        menores que o primeiro número devem ser ignorados
        */

        var scanner = new Scanner(System.in);

        System.out.println("Informe o número divisor: ");
        int numeroInicial = scanner.nextInt();

        while (true){
            System.out.println("Informe um novo numero: ");
            int numeroAtual = scanner.nextInt();

            if(numeroAtual < numeroInicial){
                System.out.println(" NUMERO IGNORADO - O numero precisa ser maior que o divisor ");
                continue;
            }

            if (numeroAtual % numeroInicial != 0){
                System.out.println("Execucao encerrado, o resto da divisao nao é zero");
                break;
            }

            System.out.println("O numero " + numeroAtual + " é disivel por" + numeroInicial + " .Continue ...");
        }

        scanner.close();
    }
}
