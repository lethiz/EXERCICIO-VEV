package main.repository;

import main.models.Tarefa;

import java.util.HashMap;
import java.util.List;

public abstract class ITarefaRepository {

    public abstract HashMap<String, Tarefa> recuperarTarefas();

    public abstract Tarefa recuperarTarefa(String idTarefa);

    public abstract List<Tarefa> buscarTarefas(String titulo);

    public abstract Boolean adicionarTarefa(Tarefa tarefa);

    public abstract Boolean atualizarTarefa(Tarefa tarefa);

    public abstract Boolean removerTarefa(String idTarefa);

    public abstract Integer contarTarefas();

}
