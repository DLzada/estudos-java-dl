import java.util.Scanner;

public class Saudacoes {
    public static void main(String[] args) {
        // Escreva um código que receba o nome e o ano de nascimento de alguém e imprima na tela a seguinte mensagem: "Olá 'Fulano' voce tem 'X' anos"

        var scanner = new Scanner(System.in);

        System.out.println("Digite seu nome:");
        var nome = scanner.next();

        System.out.println("Digite sua idade: ");
        var idade = scanner.nextInt();

        System.out.printf("Olá %s você tem %s anos \n", nome, idade);
    }
}
