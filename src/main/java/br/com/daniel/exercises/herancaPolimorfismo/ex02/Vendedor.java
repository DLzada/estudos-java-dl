package herancaPolimorfismo.ex02;

public class Vendedor extends Usuario{
    private int quantidadeVendas;

    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha, false);
        this.quantidadeVendas = 0;
    }

    public void realizarVenda(){
        this.quantidadeVendas++;
        System.out.println("Venda realizada! Total: " + quantidadeVendas);
    }

    public void consultarVendas(){
        System.out.println("O vendedor " + getNome() + " vendeu " + quantidadeVendas + " itens.");
    }

    public int getQuantidadeVendas(){
        return quantidadeVendas;
    }
}
