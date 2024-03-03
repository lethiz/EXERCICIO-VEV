package main.services;

import main.exceptions.InvalidIDException;
import main.exceptions.Model.*;
import main.exceptions.Service.InvalidComparacaoException;
import main.exceptions.Service.InvalidTarefaException;
import main.models.Tarefa;
import main.util.TarefaPrioridade;

import java.util.List;

public class TarefaService implements ITarefaService{
    @Override
    public List<Tarefa> buscarTarefas() {
        return null;
    }

    @Override
    public List<Tarefa> buscarTarefasOrdenadas(String primeiraComparacao) throws InvalidComparacaoException {
        return null;
    }

    @Override
    public List<Tarefa> buscarTarefasPrioridade() {
        return null;
    }

    @Override
    public List<Tarefa> buscarTarefasDataVencimento() {
        return null;
    }

    @Override
    public Tarefa marcarPrioridade(String idTarefa, TarefaPrioridade tarefaPrioridade) throws InvalidIDException, InvalidTarefaException, InvalidPrioridadeException {
        return null;
    }

    @Override
    public Tarefa recuperarTarefa(String idTarefa) throws InvalidIDException, InvalidTarefaException {
        return null;
    }

    @Override
    public Tarefa criarTarefa(String titulo, String descricao, String dataVencimento, TarefaPrioridade prioridade) throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDescricaoException, InvalidTituloException, InvalidDataVencimentoFormatException {
        return null;
    }

    @Override
    public Tarefa atualizarTarefa(Tarefa tarefa) throws InvalidIDException, InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDescricaoException, InvalidTituloException, InvalidDataVencimentoFormatException {
        return null;
    }

    @Override
    public Boolean removerTarefa(String idTarefa) throws InvalidIDException, InvalidTarefaException {
        return null;
    }
}
