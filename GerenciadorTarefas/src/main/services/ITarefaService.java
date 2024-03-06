package main.services;

import main.exceptions.InvalidIDException;
import main.exceptions.Model.*;
import main.exceptions.Service.InvalidComparacaoException;
import main.exceptions.Service.InvalidTarefaException;
import main.models.Tarefa;
import main.util.TarefaPrioridade;

import java.util.List;

public interface ITarefaService {
    List<Tarefa> buscarTarefas();

    List<Tarefa> buscarTarefasOrdenadas(String primeiraComparacao) throws InvalidComparacaoException;

    List<Tarefa> buscarTarefasPrioridade();

    List<Tarefa> buscarTarefasDataVencimento();

    Tarefa marcarPrioridade(String idTarefa, String tarefaPrioridade) throws InvalidIDException, InvalidTarefaException, InvalidPrioridadeException;

    Tarefa recuperarTarefa(String idTarefa) throws InvalidIDException, InvalidTarefaException;

    public Tarefa criarTarefa(String titulo, String descricao, String dataVencimento, String prioridade) throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDescricaoException, InvalidTituloException, InvalidDataVencimentoFormatException;

    Tarefa atualizarTarefa(String idTarefa, Tarefa tarefa) throws InvalidIDException, InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDescricaoException, InvalidTituloException, InvalidDataVencimentoFormatException;

    Boolean removerTarefa(String idTarefa) throws InvalidIDException, InvalidTarefaException;
}
