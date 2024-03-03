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
        return null;
    }

    @Override
    public Tarefa recuperarTarefa(String idTarefa) {
        return null;
    }

    @Override
    public List<Tarefa> buscarTarefas(String titulo) {
        return null;
    }

    @Override
    public Boolean adicionarTarefa(Tarefa tarefa) {
        return null;
    }

    @Override
    public Boolean atualizarTarefa(Tarefa tarefa) {
        return null;
    }

    @Override
    public Boolean removerTarefa(String idTarefa) {
        return null;
    }

    @Override
    public Integer contarTarefas() {
        return null;
    }
}
