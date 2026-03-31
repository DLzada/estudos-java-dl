package collections.ex13;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> listaTarefas;

    public ListaTarefas() {
        this.listaTarefas = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        listaTarefas.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        Tarefa tarefaParaRemover = null;
        if(!listaTarefas.isEmpty()){
            for (Tarefa t: listaTarefas){
                if(t.getDescricao().equalsIgnoreCase(descricao)){
                    tarefaParaRemover = t;
                    break;
                }
            }
            listaTarefas.remove(tarefaParaRemover);
        }else {
            throw new RuntimeException("Erro, a lista esta Vazia");
        }
    }

    public void exibirTarefas() {
        if(!listaTarefas.isEmpty()) {
            System.out.println(listaTarefas);
        } else {
            System.out.println("Tarefa não encontrada!");
        }
    }

    public int contarTarefas(){
        return listaTarefas.size();
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();

        for (Tarefa t: listaTarefas){
            if(t.isConcluida()){
                tarefasConcluidas.add(t);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasNaoConcluidas = new HashSet<>();

        for (Tarefa t: listaTarefas){
            if(t.isConcluida()){
                tarefasNaoConcluidas.add(t);
            }
        }
        return tarefasNaoConcluidas;
    }

    public void marcarTarefaConcluida(String descricao){
        for (Tarefa t: listaTarefas){
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                t.setConcluida(true);
            }
        }
    }

    public void marcarTarefaPendente(String descricao){
        Tarefa tarefaParaMarcarComoPendente = null;
        for (Tarefa t: listaTarefas){
            if (t.getDescricao().equalsIgnoreCase(descricao)){
                tarefaParaMarcarComoPendente = t;
                break;
            }
        }

        if(tarefaParaMarcarComoPendente != null){
            if (tarefaParaMarcarComoPendente.isConcluida()){
                tarefaParaMarcarComoPendente.setConcluida(false);
            }
        }else {
            System.out.println("Tarefa nao encontrada na lista");
        }
    }

    public void limparListaTarefas(){
        if(listaTarefas.isEmpty()){
            System.out.println("A lista esta vazia");
        }else {
            listaTarefas.clear();
        }
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.adicionarTarefa("Estudar Java");
        listaTarefas.adicionarTarefa("Fazer exercícios físicos");
        listaTarefas.adicionarTarefa("Organizar a mesa de trabalho");
        listaTarefas.adicionarTarefa("Ler livro");
        listaTarefas.adicionarTarefa("Preparar apresentação");

        listaTarefas.exibirTarefas();

        listaTarefas.removerTarefa("Fazer exercícios físicos");

        System.out.println("Total de tarefas na lista: " + listaTarefas.contarTarefas());

        System.out.println(listaTarefas.obterTarefasPendentes());

        listaTarefas.marcarTarefaConcluida("Ler livro");
        listaTarefas.marcarTarefaConcluida("Estudar Java");

        System.out.println(listaTarefas.obterTarefasConcluidas());

        listaTarefas.marcarTarefaPendente("Estudar Java");
        listaTarefas.exibirTarefas();

        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();
    }
}
