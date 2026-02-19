package br.com.daniel.modulo1;

public class TiposDados {
    public static void main(String[] args) {

        // --- PRIMITIVOS (Performance e Segurança) ---
        // int idadeNula = null; // ERRO: Primitivo não aceita null.
        // Padrão de nomear variáveis -> camelCase

         byte idade;
         short ano;
         int quantidade;
         long numeroDeVendas;   
         float tamanho;
         double valor;
         boolean ativo;
         char sexo;     
        
        // --- WRAPPERS (Flexibilidade e Null) ---
        String nome;

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