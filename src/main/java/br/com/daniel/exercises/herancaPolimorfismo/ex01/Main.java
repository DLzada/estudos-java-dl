package herancaPolimorfismo.ex01;

public class Main {
    public static void main(String[] args) {
        /*
        Crie uma hierarquia de classes para tratar os tipos
        de ingresso que podem ser comercializados em um cinema.
        O ingresso deve ter um valor, nome do filme e informar
        se é dublado ou legendado. A partir desse ingresso devem
        ser criados os tipos Meia entrada e ingresso família.
        Cada ingresso deve ter um método que retorna o seu valor real
        ( baseado no valor informado na criação do ingresso) para os de
        meia entrada o seu valor deve ser de metade do valor, para os
        ingressos família deve-se retornar o valor multiplicado pelo
        número de pessoas e fornecer um desconto de 5% quando o número
        de pessoas for maior que 3.
        */


        Ingresso i1 = new MeiaEntrada("Batman", 40.0, false);
        Ingresso i2 = new IngressoFamilia("Shrek 5", 30.0, true, 4);

        System.out.println("Filme: " + i1.getInfoFilme() + " | Preço: R$" + i1.valorReal());
        System.out.println("Filme: " + i2.getInfoFilme() + " | Preço (Família): R$" + i2.valorReal());
    }

}
