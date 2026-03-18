package herancaPolimorfismo.ex02;

public class Gerente extends Usuario{
    public Gerente(String nome, boolean administrador, String senha, String email) {
        super(nome, administrador, senha, email);
    }

    public void gerarRelatorioFinanceiro(){
        System.out.println("Gerando relatoria completo do sistema);
    }

    public void consultarVendas(){
        System.out.println("Consultando todas as vendas da loja");
    }
}
