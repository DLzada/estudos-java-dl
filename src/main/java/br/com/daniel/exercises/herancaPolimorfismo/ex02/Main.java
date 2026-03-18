package herancaPolimorfismo.ex02;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        Crie uma hierarquia de classes que definam os tipos de usuários
        de um sistema, use os seguintes requisitos:

        Classe Gerente que terá os atributos: Nome, Email, Senha e um
        atributo que informa se ele é administrador, esse último deve
        ser sempre verdadeiro;
        Classe Vendedor que terá os seguintes atributos: Nome, Email, Senha,
        Quantidade de vendas e um atributo que informa se ele é administrador,
        esse útimo deve ser sempre falso;
        Classe Atendente que terá os seguintes atributos: Nome, Email, Senha,
        Valor em caixa e um atributo que informa se ele é administrador, esse
        ultimo deve ser sempre falso.
        Cada classe deve ter seus respectivos getters e setters ( para
        atributos que façam sentido ter) e as classes devem ter os seguintes
        métodos

        A classe Gerente deve ter os métodos Gerar relatório financeiro,
        Consultar vendas, Realizar login, Realizar logff, alterar dados,
        alterar senha;
        A classe Vendedor deve ter os métodos Realizar venda ( incrementar
        o número de vendas quando acionado), Consultar vendas, Realizar login,
        Realizar logoff, alterar dados, alterar senha;
        A classe Atendente deve ter os métodos Receber pagamentos (onde o
        método recebe um valor que deve ser incrementado no valor em caixa),
        Fechar o caixa, Realizar Login, Realizar logoff, alterar dados e
        alterar senha;
        */

        //Instaciamento das classa
        Gerente gerente1 = new Gerente("Gullit Junior", "gullitjunior2025@gmail.com", "gulli123");
        Vendedor vendedor1 = new Vendedor("Maria Cruz", "mariacruzsantos@gmail.com", "maris321");
        Atendente atendente1 = new Atendente("Roger Guedes", "rogercorintiano@hotmail.com", "roger2021");

        // Guardando user in a list
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(gerente1);
        usuarios.add(vendedor1);
        usuarios.add(atendente1);

        System.out.println("=== Testando Login e Status ===");
        for (Usuario u: usuarios){
            u.realizarLogin();
            System.out.println("Usuario: " + u.getNome() + " | Administrador: " + u.isAdministrador());
        }

        //Testando Vendedor
        vendedor1.realizarVenda();
        vendedor1.realizarVenda();
        vendedor1.consultarVendas();

        //Testando Atendente
        atendente1.receberPagamento(125.00);
        atendente1.receberPagamento(99.90);
        atendente1.fecharCaixa();

        //Testando Gerente
        gerente1.gerarRelatorioFinanceiro();
        gerente1.alterarSenha("novaSenha");

        vendedor1.alterarDados("Maria Cruz Alves", "mariacruzalves@hotmail.com");

        System.out.println("\n +++ Finalizando +++");
        for (Usuario u: usuarios){
            u.realizarLogoff();
        }
    }
}
