package main.repository;

import java.util.HashMap;
import java.util.List;

import main.models.Tarefa;


public class TarefaRepository extends ITarefaRepository {

    private HashMap<String, Tarefa> tarefasCadastradas;

    public TarefaRepository() {
        this.tarefasCadastradas = new HashMap<String, Tarefa>();
    }

    @Override
    public HashMap<String, Tarefa> recuperarTarefas() {
        return (HashMap<String, Tarefa>) this.tarefasCadastradas.clone();
    }

    @Override
    public Tarefa recuperarTarefa(String idTarefa) {
        return this.tarefasCadastradas.get(idTarefa);
    }

    @Override
    public List<Tarefa> buscarTarefas(String titulo) {
        return this.tarefasCadastradas.values().stream().filter(tarefa -> tarefa.getTitulo().equals(titulo)).toList();
    }

    @Override
    public Boolean adicionarTarefa(Tarefa tarefa) {
        this.tarefasCadastradas.put(tarefa.getId(), tarefa);
        return true;
    }

    @Override
    public Boolean atualizarTarefa(Tarefa tarefa) {
        this.tarefasCadastradas.put(tarefa.getId(), tarefa);
        return true;
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
