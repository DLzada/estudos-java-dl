package collections.ex03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Campo> listaDeCampos = new ArrayList<>();

        System.out.println("=== Conversor de Dados Multi-Formato ===");
        System.out.println("Digite no padrão: NOME;VALOR;TIPO");
        System.out.println("Exemplo: idade;25;inteiro");
        System.out.println("Digite 'FIM' para gerar os arquivos.\n");

        while (true) {
            System.out.print("Entrada: ");
            String linha = scanner.nextLine();

            if (linha.equalsIgnoreCase("fim")) break;

            String[] partes = linha.split(";");
            if (partes.length == 3) {
                listaDeCampos.add(new Campo(partes[0].trim(), partes[1].trim(), partes[2].trim()));
            } else {
                System.out.println("[!] Erro: Formato inválido. Use NOME;VALOR;TIPO");
            }
        }

        if (!listaDeCampos.isEmpty()) {
            System.out.println("\n--- RESULTADO JSON ---");
            System.out.println(GeradorFormatos.paraJson(listaDeCampos));

            System.out.println("\n--- RESULTADO XML ---");
            System.out.println(GeradorFormatos.paraXml(listaDeCampos));

            System.out.println("\n--- RESULTADO YAML ---");
            System.out.println(GeradorFormatos.paraYaml(listaDeCampos));
        }

        scanner.close();
    }
}
