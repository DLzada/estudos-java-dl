package br.com.daniel.modulo2.encapsulamento;

public class ContaBancaria {
    // 1. BLINDE OS DADOS (private)
    private double saldo;
    private String titular;

    // 2. CONSTRUTOR (Obriga a passar dados ao criar)
    public ContaBancaria(String titular, double depositoInicial) {
        if (depositoInicial < 0) {
            throw new IllegalArgumentException("Não pode abrir conta negativada!");
        }
        this.titular = titular;
        this.saldo = depositoInicial;
    }

    // 3. ACESSO CONTROLADO (Métodos públicos)
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    // Getter (Apenas leitura)
    public double getSaldo() {
        return saldo;
    }

    //Setter
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
   
}
