package br.com.daniel.modulo1;

public class TiposMemoria{
    public static void main(String[] args) {
        // --- PRIMITIVOS (Performance e Segurança) ---
        int idadePrimitiva = 25;
        // int idadeNula = null; // ERRO: Primitivo não aceita null.
        
        // --- WRAPPERS (Flexibilidade e Null) ---
        Integer idadeWrapper = 25; // Autoboxing (Java converte int para Integer sozinho)
        Integer idadeNula = null;  // Permitido. Usado em Bancos de Dados quando o campo é opcional.

        // --- O PERIGO DA COMPARAÇÃO ---
        int a = 1000;
        int b = 1000;
        System.out.println(a == b); // TRUE (Compara valor: 1000 == 1000)

        Integer c = 1000;
        Integer d = 1000;
        System.out.println(c == d); // FALSE! (Compara endereço de memória de dois objetos diferentes)
        System.out.println(c.equals(d)); // TRUE (Jeito certo: Compara o CONTEÚDO do objeto)
    }
}