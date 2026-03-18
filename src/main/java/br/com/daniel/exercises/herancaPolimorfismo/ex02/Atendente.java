package herancaPolimorfismo.ex02;

public class Atendente extends Usuario{
    private double valorEmCaixa;

    public Atendente(String nome, String email, String senha) {
        super(nome, email, senha, false);
        this.valorEmCaixa = 0.0;
    }

    public void receberPagamento(double valor){
        this.valorEmCaixa += valor;
        System.out.println("Pagamento de R$" + valor + " recebido");
    }

    public void fecharCaixa(){
        System.out.println("Caixa Fechado com o valor total de: R$" + valorEmCaixa);
        this.valorEmCaixa = 0.0;
    }

    public double getValorEmCaixa(){
        return valorEmCaixa;
    }
}
