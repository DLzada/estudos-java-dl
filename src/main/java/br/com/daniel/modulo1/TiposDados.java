package br.com.daniel.modulo1;

public class TiposDados {
    public static void main(String[] args) {

        // --- PRIMITIVOS (Performance e Segurança) ---
        // int idadeNula = null; // ERRO: Primitivo não aceita null.
        // Padrão de nomear variáveis -> camelCase

        // ====== Podemos criar mais de uma variavel apenas com uma declaraçao de tipo, só separar por vírgula  =======

         byte idade = 22, quantidadeDeDependentes = 6;
         short ano = 2026, mes = 12, dia = 12; 
         int quantidade = 77;
         long numeroDeVendas = 313;   
         float tamanho = 1.78f;
         double valor = 19.99;
         boolean ativo = true;
         char sexo = 'M';     
        
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