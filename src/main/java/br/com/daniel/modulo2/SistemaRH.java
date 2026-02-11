package br.com.daniel.modulo2;

// Classe Pai (Genérica)
abstract class Funcionario {
    protected String nome;
    protected double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    // Método que SERÁ sobrescrito
    public double calcularBonus() {
        return this.salario * 0.1; // Bônus padrão de 10%
    }
}

// Classe Filha (Específica)
class Gerente extends Funcionario {
    public Gerente(String nome, double salario) {
        super(nome, salario); // Chama construtor do Pai
    }

    @Override
    public double calcularBonus() {
        // Gerente ganha bônus padrão + 1000
        return super.calcularBonus() + 1000.0;
    }
}

public class SistemaRH {
    public static void main(String[] args) {
        // POLIMORFISMO: Referência genérica (Funcionario) apontando para objeto específico (Gerente)
        Funcionario f1 = new Gerente("Daniel", 1000);
        
        // O Java sabe em tempo de execução qual método chamar (o do Gerente)
        System.out.println("Bonus: " + f1.calcularBonus()); 
    }
}