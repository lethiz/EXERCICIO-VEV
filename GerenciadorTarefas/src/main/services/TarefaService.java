package main.services;

import main.exceptions.InvalidIDException;
import main.exceptions.Model.*;
import main.exceptions.Service.InvalidComparacaoException;
import main.exceptions.Service.InvalidTarefaException;
import main.models.Tarefa;
import main.repository.ITarefaRepository;
import main.util.CheckInvalids;
import main.util.DataVencimentoComparator;
import main.util.TarefaPrioridade;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TarefaService implements ITarefaService{

    private ITarefaRepository tarefasRepository;

    private final CheckInvalids checkInvalids = new CheckInvalids();

    public List<Tarefa> buscarTarefas()  {
        return tarefasRepository.recuperarTarefas().values().stream().toList();
    }

    public  List<Tarefa>  buscarTarefasOrdenadas(String primeiraComparacao) throws InvalidComparacaoException {
        List<Tarefa> tarefasRecuperadas =  this.buscarTarefas();

        if(primeiraComparacao == null){
            throw new InvalidComparacaoException("o parâmetro de comparação não pode ser nulo");
        }

        String comparativoInicial = primeiraComparacao.toUpperCase();


        if(Objects.equals(comparativoInicial, "PRIORIDADE")) return tarefasRecuperadas.stream().sorted(
                Comparator.comparing(Tarefa::getPrioridade)
                        .thenComparing(new DataVencimentoComparator())
        ).collect(Collectors.toList());
        else if(Objects.equals(comparativoInicial, "DATA_VENCIMENTO")) return tarefasRecuperadas.stream().sorted(
                Comparator.comparing(Tarefa::getPrioridade)
                        .thenComparing(new DataVencimentoComparator())
        ).collect(Collectors.toList());
        else return tarefasRecuperadas.stream().sorted(
                    Comparator.comparing(Tarefa::getPrioridade)
                            .thenComparing((Tarefa::getTitulo))
            ).collect(Collectors.toList());

    }
    public  List<Tarefa> buscarTarefasPrioridade()  {
        List<Tarefa> tarefaRecuperadas = this.buscarTarefas();

        return tarefaRecuperadas.stream().sorted(new DataVencimentoComparator()).toList();
    }

    public  List<Tarefa> buscarTarefasDataVencimento()  {
        List<Tarefa> tarefaRecuperadas = this.buscarTarefas();

        return tarefaRecuperadas.stream().sorted(Comparator.comparing(Tarefa::getPrioridade)).toList();
    }

    public Tarefa marcarPrioridade(String idTarefa, TarefaPrioridade tarefaPrioridade) throws InvalidIDException, InvalidTarefaException, InvalidPrioridadeException {
        checkInvalids.checkId(idTarefa);

        Tarefa tarefaRecuperada = tarefasRepository.recuperarTarefa(idTarefa);

        checkInvalids.checkTarefa(tarefaRecuperada, "recuperar");

        tarefaRecuperada.setPrioridade(tarefaPrioridade);

        tarefasRepository.atualizarTarefa(tarefaRecuperada);

        return tarefaRecuperada;
    }

    public Tarefa recuperarTarefa(String idTarefa) throws InvalidIDException, InvalidTarefaException {
        checkInvalids.checkId(idTarefa);

        Tarefa tarefaRecuperada = tarefasRepository.recuperarTarefa(idTarefa);

        checkInvalids.checkTarefa(tarefaRecuperada, "recuperar");

        return tarefaRecuperada;
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
