package herancaPolimorfismo.ex01;

public class MeiaEntrada extends Ingresso {

    public MeiaEntrada(String nomeFilme, double valorBase, boolean dublado) {
        super(nomeFilme, valorBase, dublado);
    }

    @Override
    public double valorReal() {
        return getValorBase() * 0.5;
    }
}
