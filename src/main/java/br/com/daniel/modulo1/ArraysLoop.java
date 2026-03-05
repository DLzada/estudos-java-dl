package br.com.daniel.modulo1;

public class ArraysLoop {
    public static void main(String[] args) {
        // Declaração explícita com tamanho fixo (3 posições)
        String[] stack = new String[3];
        stack[0] = "Java";
        stack[1] = "Spring";
        stack[2] = "Docker";
        // stack[3] = "Erro"; // Isso daria ArrayIndexOutOfBoundsException

        // Declaração literal (Já sabe o tamanho e conteúdo)
        int[] numeros = {10, 20, 30, 40};

        // FOR ENAHNCED (O "for-of" do Java) - Use sempre que puder
        for (String tech : stack) {
            System.out.println("Estudando: " + tech);
        }

        // VAR (Java 10+) - Inferência de tipo (Parecido com let/const, mas tipado)
        var mensagem = "O compilador sabe que isso é String";
        // mensagem = 123; // ERRO: Uma vez String, sempre String.
    }
}