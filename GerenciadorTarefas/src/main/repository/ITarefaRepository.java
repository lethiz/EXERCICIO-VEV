package main.repository;

import main.exceptions.InvalidIDException;
import main.exceptions.Model.InvalidDataVencimentoException;
import main.exceptions.Model.InvalidDescricaoException;
import main.exceptions.Model.InvalidPrioridadeException;
import main.exceptions.Model.InvalidTituloException;
import main.exceptions.Repository.InvalidTarefaException;
import main.models.Tarefa;

import java.util.HashMap;
import java.util.List;

public abstract class ITarefaRepository {

    public abstract HashMap<String, Tarefa> recuperarTarefas();

    public abstract Tarefa recuperarTarefa(String idTarefa) throws InvalidIDException, InvalidTarefaException;

    public abstract List<Tarefa> buscarTarefas(String titulo) throws InvalidTituloException;

    public abstract Boolean adicionarTarefa(Tarefa tarefa) throws InvalidTarefaException;

    public abstract Boolean atualizarTarefa(Tarefa tarefa) throws InvalidTarefaException, InvalidTituloException, InvalidDescricaoException, InvalidDataVencimentoException, InvalidPrioridadeException;

    public abstract Boolean removerTarefa(String idTarefa) throws InvalidIDException, InvalidTarefaException;

    public abstract Integer contarTarefas();

}
