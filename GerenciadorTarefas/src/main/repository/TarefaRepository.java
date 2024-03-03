package main.repository;

import java.util.HashMap;
import java.util.List;

import main.exceptions.InvalidIDException;
import main.exceptions.Model.InvalidDataVencimentoException;
import main.exceptions.Model.InvalidDescricaoException;
import main.exceptions.Model.InvalidPrioridadeException;
import main.exceptions.Model.InvalidTituloException;
import main.exceptions.Repository.InvalidTarefaException;
import main.models.Tarefa;
import main.util.CheckInvalids;


public class TarefaRepository extends ITarefaRepository {

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
    public Tarefa recuperarTarefa(String idTarefa) throws InvalidIDException, InvalidTarefaException {
        checkInvalids.checkId(idTarefa);
        Tarefa tarefaRecuperada = this.tarefasCadastradas.get(idTarefa);
        checkInvalids.checkTarefa(tarefaRecuperada, "recuperar");
        return tarefaRecuperada;
    }

    @Override
    public List<Tarefa> buscarTarefas(String titulo) throws InvalidTituloException {
        checkInvalids.checkTitulo(titulo);
        return this.tarefasCadastradas.values().stream().filter(tarefa -> tarefa.getTitulo().equals(titulo)).toList();
    }

    @Override
    public Boolean adicionarTarefa(Tarefa tarefa) throws InvalidTarefaException {
        checkInvalids.checkTarefa(tarefa, "adicionar");
        this.tarefasCadastradas.put(tarefa.getId(), tarefa);
        return true;
    }

    @Override
    public Boolean atualizarTarefa(Tarefa tarefa) throws InvalidTarefaException, InvalidTituloException, InvalidDescricaoException, InvalidDataVencimentoException, InvalidPrioridadeException {
        checkInvalids.checkTarefa(tarefa, "atualizar");
        checkInvalids.checkTitulo(tarefa.getTitulo());
        checkInvalids.checkDescricao(tarefa.getDescricao());
        checkInvalids.checkDataVencimento(tarefa.getDataVencimento());
        checkInvalids.checkPrioridade(tarefa.getPrioridade());
        this.tarefasCadastradas.put(tarefa.getId(), tarefa);
        return true;
    }

    @Override
    public Boolean removerTarefa(String idTarefa) throws InvalidIDException, InvalidTarefaException {
        checkInvalids.checkId(idTarefa);
        Tarefa tarefaRecuperada = this.tarefasCadastradas.get(idTarefa);
        checkInvalids.checkTarefa(tarefaRecuperada, "remover");
        this.tarefasCadastradas.remove(idTarefa);
        return true;
    }

    @Override
    public Integer contarTarefas() {
        return this.tarefasCadastradas.keySet().size();
    }


}
