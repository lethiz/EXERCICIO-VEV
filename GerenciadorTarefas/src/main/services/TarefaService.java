package main.services;

import main.exceptions.InvalidIDException;
import main.exceptions.Model.*;
import main.exceptions.Service.InvalidComparacaoException;
import main.exceptions.Service.InvalidTarefaException;
import main.models.Tarefa;
import main.repository.ITarefaRepository;
import main.repository.TarefaRepository;
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

    public TarefaService() {
        this.tarefasRepository = new TarefaRepository();
    }

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

        return tarefaRecuperadas.stream().sorted(Comparator.comparing(Tarefa::getPrioridade)).toList();
    }

    public  List<Tarefa> buscarTarefasDataVencimento()  {
        List<Tarefa> tarefaRecuperadas = this.buscarTarefas();

        return tarefaRecuperadas.stream().sorted(new DataVencimentoComparator()).toList();
    }

    public Tarefa marcarPrioridade(String idTarefa, String prioridade) throws InvalidIDException, InvalidTarefaException, InvalidPrioridadeException {
        checkInvalids.checkId(idTarefa);

        TarefaPrioridade tarefaPrioridade = TarefaPrioridade.PRIORIDADE_INDEFINIDA;
        if(prioridade.equalsIgnoreCase("ALTA")) tarefaPrioridade = TarefaPrioridade.PRIORIDADE_ALTA;
        else if(prioridade.equalsIgnoreCase("MEDIA") || prioridade.equalsIgnoreCase("MÉDIA") ) tarefaPrioridade = TarefaPrioridade.PRIORIDADE_MEDIA;
        else if(prioridade.equalsIgnoreCase("BAIXA")) tarefaPrioridade = TarefaPrioridade.PRIORIDADE_BAIXA;

        checkInvalids.checkPrioridade(tarefaPrioridade);

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

    public Tarefa criarTarefa(String titulo, String descricao, String dataVencimento, String prioridade) throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDescricaoException, InvalidTituloException, InvalidDataVencimentoFormatException {
        TarefaPrioridade tarefaPrioridade = TarefaPrioridade.PRIORIDADE_INDEFINIDA;
        if(prioridade.equalsIgnoreCase("ALTA")) tarefaPrioridade = TarefaPrioridade.PRIORIDADE_ALTA;
        else if(prioridade.equalsIgnoreCase("MEDIA") || prioridade.equalsIgnoreCase("MÉDIA") ) tarefaPrioridade = TarefaPrioridade.PRIORIDADE_MEDIA;
        else if(prioridade.equalsIgnoreCase("BAIXA")) tarefaPrioridade = TarefaPrioridade.PRIORIDADE_BAIXA;


        Tarefa tarefaNova = new Tarefa(titulo, descricao, dataVencimento, tarefaPrioridade);

        checkInvalids.checkTitulo(tarefaNova.getTitulo());
        checkInvalids.checkDescricao(tarefaNova.getDescricao());
        checkInvalids.checkDataVencimento(tarefaNova.getDataVencimento());
        checkInvalids.checkPrioridade(tarefaNova.getPrioridade());

        Tarefa tarefaCriada = tarefasRepository.adicionarTarefa(tarefaNova);

        return tarefaCriada;
    }
    public Tarefa atualizarTarefa(String idTarefa, Tarefa tarefa) throws InvalidIDException, InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDescricaoException, InvalidTituloException, InvalidDataVencimentoFormatException {
        checkInvalids.checkId(tarefa.getId());

        Tarefa tarefaRecuperada = tarefasRepository.recuperarTarefa(idTarefa);

        checkInvalids.checkTitulo(tarefa.getTitulo());
        checkInvalids.checkDescricao(tarefa.getDescricao());
        checkInvalids.checkDataVencimento(tarefa.getDataVencimento());
        checkInvalids.checkPrioridade(tarefa.getPrioridade());

        tarefaRecuperada.setTitulo(tarefa.getTitulo());
        tarefaRecuperada.setDescricao(tarefa.getDescricao());
        tarefaRecuperada.setPrioridade(tarefa.getPrioridade());
        tarefaRecuperada.setDataVencimento(tarefa.getDataVencimento());

        Tarefa tarefaAtualizada = tarefasRepository.atualizarTarefa(tarefaRecuperada);

        return tarefaAtualizada;
    }

    public Boolean removerTarefa(String idTarefa) throws InvalidIDException, InvalidTarefaException {
        checkInvalids.checkId(idTarefa);

        Tarefa tarefaRecuperada = tarefasRepository.recuperarTarefa(idTarefa);

        checkInvalids.checkTarefa(tarefaRecuperada, "remover");

        tarefasRepository.removerTarefa(idTarefa);

        return true;
    }
}
