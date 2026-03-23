package collections.ex02;

import java.util.Scanner;

public class FormatadorTelefone {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número (pode conter letras, símbolos ou estar sem formatação):");
        String entrada = scanner.nextLine();

        processarEntrada(entrada);

        scanner.close();
    }

    public static void processarEntrada(String entrada){
        String apenasNumeros = entrada.replaceAll("\\D", "");
        int qtd = apenasNumeros.length();

        if (estaFormatadoCorretamente(entrada, qtd)){
            System.out.println("Entrada ha estava formatada corretamente.");
            System.out.println("Tipo: " + indetificarTipo(qtd));
            System.out.println("Resultado: " + entrada);
            return;
        }

        switch (qtd) {
            case 8:
                exibirResultado("Telefone Fixo (sem DDD)", formatar(apenasNumeros, "####-####"));
                break;
            case 10:
                exibirResultado("Telefone Fixo (com DDD)", formatar(apenasNumeros, "(##)####-####"));
                break;
            case 9:
                exibirResultado("Celular (sem DDD)", formatar(apenasNumeros, "#####-####"));
                break;
            case 11:
                exibirResultado("Celular (com DDD)", formatar(apenasNumeros, "(##)#####-####"));
                break;
            default:
                System.out.println("Erro: A entrada contém " + qtd + " números, o que não corresponde a um padrão válido.");
        }
    }

    public static boolean estaFormatadoCorretamente(String entrada, int qtd){
        if (qtd == 8) return entrada.matches("\\d{4}-\\d{4}");
        if (qtd == 10) return entrada.matches("\\(\\d{2}\\)\\d{4}-\\d{4}");
        if (qtd == 9) return entrada.matches("\\d{5}-\\d{4}");
        if (qtd == 11) return entrada.matches("\\(\\d{2}\\)\\d{5}-\\d{4}");
        return false;
    }

    private static String indetificarTipo(int qtd){
        if (qtd == 8 || qtd == 10) return "Telefone Fixo";
        if (qtd == 9 || qtd == 11) return "Celular";
        return "Desconhecido";
    }

    private static String formatar(String numeros, String mascara){
        StringBuilder resultado = new StringBuilder();
        int k = 0;
        for (char m: mascara.toCharArray()){
            if (m == '#'){
                resultado.append(numeros.charAt(k));
                k++;
            } else {
                resultado.append(m);
            }
        }
        return resultado.toString();
    }

    private static void exibirResultado(String tipo, String formatado){
        System.out.println("Detectado " + tipo);
        System.out.println("Resultado Formatado: " + formatado);
    }
}
