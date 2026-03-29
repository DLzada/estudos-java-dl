package collections.ex04;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    /*
    Crie uma classe chamada "ListaTarefas" que possui uma lista de tarefas como atributo. Cada tarefa é representada por uma classe chamada "Tarefa" que possui um atributo de descrição. Implemente os seguintes métodos:

        adicionarTarefa(String descricao): Adiciona uma nova tarefa à lista com a descrição fornecida.
        removerTarefa(String descricao): Remove uma tarefa da lista com base em sua descrição.
        obterNumeroTotalTarefas(): Retorna o número total de tarefas na lista.
        obterDescricoesTarefas(): Retorna uma lista contendo a descrição de todas as tarefas na lista.

    */
    private List<Tarefa> tarefaList;

    public ListaTarefa() {
        this.tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        List<Tarefa> tarefasParaRemover = new ArrayList<>();
        for (Tarefa t: tarefaList){
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                tarefasParaRemover.add(t);
            }
        }
        tarefaList.removeAll(tarefasParaRemover);
    }

    public int obterNumeroTotalTarefas(){
        return tarefaList.size();
    }

    public void obterDescricaoTarefas(){
        System.out.println(tarefaList);
    }

    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();
        System.out.println("O número total de tarefas é: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 2");
        System.out.println("O número total de tarefas é: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.removerTarefa("tarefa 1");
        System.out.println("O número total de tarefas é: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.obterDescricaoTarefas();
    }
}
