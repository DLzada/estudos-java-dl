package herancaPolimorfismo.ex02;

public class Vendedor extends Usuario{
    private int quantidadeVendas;

    public Vendedor(String nome, boolean administrador, String senha, String email, int quantidadeVendas) {
        super(nome, administrador, senha, email);
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
