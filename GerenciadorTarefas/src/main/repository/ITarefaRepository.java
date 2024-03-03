package main.repository;

import main.models.Tarefa;

import java.util.HashMap;
import java.util.List;

public interface ITarefaRepository {
    HashMap<String, Tarefa> recuperarTarefas();

    Tarefa recuperarTarefa(String idTarefa);

    List<Tarefa> buscarTarefas(String titulo);

    Tarefa adicionarTarefa(Tarefa tarefa);

    Tarefa atualizarTarefa(Tarefa tarefa);

    Boolean removerTarefa(String idTarefa);

    Integer contarTarefas();

}
