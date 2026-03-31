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
        convidadoSet.remove(convidadoParaRemover)
    }

    public int contarConvidado(){
        return convidadoSet.size();
    }

    public void exibirConvidados(){
        System.out.println(convidadoSet);
    }

}
