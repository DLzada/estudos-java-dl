package collections.ex10;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {

    /*
    Conjunto de Convidados
        Crie uma classe chamada "ConjuntoConvidados" que possui um conjunto de objetos do tipo "Convidado" como atributo. Cada convidado possui atributos como nome e código do convite. Implemente os seguintes métodos:

        adicionarConvidado(String nome, int codigoConvite): Adiciona um convidado ao conjunto.
        removerConvidadoPorCodigoConvite(int codigoConvite): Remove um convidado do conjunto com base no código do convite.
        contarConvidados(): Conta o número total de convidados no Set.
        exibirConvidados(): Exibe todos os convidados do conjunto.
    */

    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite){
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite){
        Convidado convidadoParaRemover = null;

        for (Convidado c: convidadoSet){
            if(c.getCodigoConvite() == codigoConvite){
                convidadoParaRemover = c;
                break;
            }
        }
        convidadoSet.remove(convidadoParaRemover);
    }

    public int contarConvidados(){
        return convidadoSet.size();
    }

    public void exibirConvidados(){
        System.out.println(convidadoSet);
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados");

        // Adicionando convidados ao conjunto
        conjuntoConvidados.adicionarConvidado("Alice", 1234);
        conjuntoConvidados.adicionarConvidado("Bob", 1235);
        conjuntoConvidados.adicionarConvidado("Charlie", 1235);
        conjuntoConvidados.adicionarConvidado("David", 1236);

        System.out.println("Convidados no conjunto:");
        conjuntoConvidados.exibirConvidados();

        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados");

        conjuntoConvidados.removerConvidadoPorCodigoConvite(1236);
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados após a remoção");

        System.out.println("Convidados no conjunto após a remoção:");
        conjuntoConvidados.exibirConvidados();
    }
}
