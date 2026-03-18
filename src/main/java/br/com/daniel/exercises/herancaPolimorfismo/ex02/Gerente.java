package herancaPolimorfismo.ex02;

public class Gerente extends Usuario{
    public Gerente(String nome, String email, String senha) {
        super(nome, email, senha, true);
    }

    public void gerarRelatorioFinanceiro(){
        System.out.println("Gerando relatoria completo do sistema);
    }

    public void consultarVendas(){
        System.out.println("Consultando todas as vendas da loja");
    }
}
