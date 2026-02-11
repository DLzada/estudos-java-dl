package br.com.daniel.modulo1;

public class StringMaster {
    public static void main(String[] args) {
        // LITERAL (Vai para o Pool)
        String nome1 = "Daniel";
        String nome2 = "Daniel"; 
        
        // NEW (Força criação na Heap, fora do Pool - Evite fazer isso)
        String nome3 = new String("Daniel");

        // PROVA REAL
        System.out.println(nome1 == nome2); // TRUE (O Java reaproveitou o mesmo espaço de memória)
        System.out.println(nome1 == nome3); // FALSE (Endereços diferentes)
        System.out.println(nome1.equals(nome3)); // TRUE (Conteúdo igual)

        // IMUTABILIDADE
        String texto = "Java";
        texto.concat(" é legal"); // Isso cria uma nova String e joga no lixo, pois não atribuímos a nada.
        
        System.out.println(texto); // Imprime "Java" (A original não mudou)
        
        texto = texto.concat(" 21"); // Agora sim, atualizamos a referência.
        System.out.println(texto); // Imprime "Java 21"
    }
}