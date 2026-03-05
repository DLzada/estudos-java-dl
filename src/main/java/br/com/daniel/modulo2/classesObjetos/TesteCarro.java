package br.com.daniel.modulo2.classesObjetos;

public class TesteCarro {
    public static void main(String[] args) {
        // 'c1' é uma REFERÊNCIA na Stack.
        // 'new Carro()' aloca memória na HEAP.
        Carro c1 = new Carro();
        c1.modelo = "Fusca";
        
        Carro c2 = new Carro();
        c2.modelo = "Civic";
        
        // CUIDADO: Atribuição de referência, não cópia de objeto!
        Carro c3 = c1; 
        c3.modelo = "Brasilia"; 
        
        // O que imprime aqui?
        System.out.println(c1.modelo); // "Brasilia" (Porque c1 e c3 apontam para o MESMO objeto)
    }
}
