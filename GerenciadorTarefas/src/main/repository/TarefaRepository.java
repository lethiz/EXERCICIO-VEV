package main.repository;

import java.util.HashMap;
import java.util.List;

import main.models.Tarefa;
import main.util.CheckInvalids;


public class TarefaRepository implements ITarefaRepository {

    private HashMap<String, Tarefa> tarefasCadastradas;

    private final CheckInvalids checkInvalids = new CheckInvalids();


    public TarefaRepository() {
        this.tarefasCadastradas = new HashMap<String, Tarefa>();
    }

    @Override
    public HashMap<String, Tarefa> recuperarTarefas() {
        return (HashMap<String, Tarefa>) this.tarefasCadastradas.clone();
    }

    @Override
    public Tarefa recuperarTarefa(String idTarefa)  {
        return this.tarefasCadastradas.get(idTarefa);
    }

    @Override
    public List<Tarefa> buscarTarefas(String titulo) {
        return this.tarefasCadastradas.values().stream().filter(tarefa -> tarefa.getTitulo().equals(titulo)).toList();
    }

    @Override
    public Tarefa adicionarTarefa(Tarefa tarefa) {
        this.tarefasCadastradas.put(tarefa.getId(), tarefa);
        return this.tarefasCadastradas.get(tarefa.getId());
    }

    @Override
    public Tarefa atualizarTarefa(Tarefa tarefa) {
        this.tarefasCadastradas.put(tarefa.getId(), tarefa);
        return this.tarefasCadastradas.get(tarefa.getId());
    }

    @Override
    public Boolean removerTarefa(String idTarefa) {
        this.tarefasCadastradas.remove(idTarefa);
        return true;
    }

    @Override
    public Integer contarTarefas() {
        return this.tarefasCadastradas.keySet().size();
    }


}
