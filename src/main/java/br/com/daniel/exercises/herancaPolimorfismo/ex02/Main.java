package herancaPolimorfismo.ex02;

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

        Gerente gerente1 = new Gerente("Gullit Junior", "gullitjunior2025@gmail.com", "gulli123");
        Vendedor vendedor1 = new Vendedor("Maria Cruz", "mariacruzsantos@gmail.com", "maris321");
        Atendente atendente1 = new Atendente("Roger Guedes", "rogercorintiano@hotmail.com", "roger2021");


    }
}
