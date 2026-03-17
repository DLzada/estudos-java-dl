package herancaPolimorfismo.ex01;

public abstract class Ingresso {
    private String nomeFilme;
    private double valorBase;
    private boolean dublado;

    public Ingresso(String nomeFilme, double valorBase, boolean dublado) {
        this.nomeFilme = nomeFilme;
        this.valorBase = valorBase;
        this.dublado = dublado;
    }

    public abstract double valorReal();

    public double getValorBase() {
        return valorBase;
    }

    public String getInfoFilme() {
        String tipo = dublado ? "Dublado" : "Legendado";
        return nomeFilme + " (" + tipo + ")";
    }
}