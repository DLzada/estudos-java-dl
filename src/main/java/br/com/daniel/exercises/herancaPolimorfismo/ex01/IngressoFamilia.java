package herancaPolimorfismo.ex01;

public class IngressoFamilia extends Ingresso{
    private int numeroPessoas;

    public IngressoFamilia(String nomeFilme, double valorBase, boolean dublado, int numeroPessoas) {
        super(nomeFilme, valorBase, dublado);
        this.numeroPessoas = numeroPessoas;
    }

    @Override
    public double valorReal() {
        double total = getValorBase() * numeroPessoas;
        if(numeroPessoas > 3){
            total = total * 0.95;
        }
        return total;
    }
}
