package main.functionalTests;

import main.exceptions.InvalidIDException;
import main.exceptions.Model.*;
import main.exceptions.Service.InvalidComparacaoException;
import main.exceptions.Service.InvalidTarefaException;
import main.models.Tarefa;
import main.services.ITarefaService;
import main.services.TarefaService;
import main.util.TarefaPrioridade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TarefaServiceAVLTest {
    private Tarefa tarefaTeste;
    private Tarefa tarefaTesteOutra;
    private Tarefa tarefaTesteFinal;
    private ITarefaService tarefaService;

    @BeforeEach
    public void prepararTest() {
        this.tarefaService = new TarefaService();
    }

    @Test
    void buscarTarefasTesteC1() {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(0, tarefasBuscadas.size());
    }

    @Test
    void buscarTarefasTesteC2() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "ALTA");


        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(6, tarefasBuscadas.size());
    }

    @Test
    void buscarTarefasTesteC3() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "ALTA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(18, tarefasBuscadas.size());
    }

    @Test
    void buscarTarefasPrioridadeTesteC4() {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasPrioridade();
        assertEquals(0, tarefasBuscadas.size());
    }

    @Test
    void buscarTarefasPrioridadeTesteC5() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "BAIXA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasPrioridade();
        assertEquals(6, tarefasBuscadas.size());

        assertEquals(tarefasBuscadas.get(0).getPrioridade(), TarefaPrioridade.PRIORIDADE_ALTA);
        assertEquals(tarefasBuscadas.get(5).getPrioridade(), TarefaPrioridade.PRIORIDADE_BAIXA);
    }

    @Test
    void buscarTarefasPrioridadeTesteC6() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "BAIXA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasPrioridade();
        assertEquals(18, tarefasBuscadas.size());

        assertEquals(tarefasBuscadas.getFirst().getPrioridade(), TarefaPrioridade.PRIORIDADE_ALTA);
        assertEquals(tarefasBuscadas.get(17).getPrioridade(), TarefaPrioridade.PRIORIDADE_BAIXA);
    }

    @Test
    void buscarTarefasDataVencimentoTesteC7() {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasDataVencimento();
        assertEquals(0, tarefasBuscadas.size());
    }

    @Test
    void buscarTarefasDataVencimentoTesteC8() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "29/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "29/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "BAIXA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasDataVencimento();
        assertEquals(6, tarefasBuscadas.size());

        assertEquals(tarefasBuscadas.get(0).getDataVencimento(), "23/09/2024");
        assertEquals(tarefasBuscadas.get(5).getDataVencimento(), "29/09/2024");
    }

    @Test
    void buscarTarefasDataVencimentoTesteC9() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "29/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "29/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "29/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "29/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "29/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "29/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "BAIXA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasDataVencimento();
        assertEquals(18, tarefasBuscadas.size());

        assertEquals(tarefasBuscadas.getFirst().getDataVencimento(), "23/09/2024");
        assertEquals(tarefasBuscadas.get(17).getDataVencimento(), "29/09/2024");
    }

    @Test
    void buscarTarefasOrdenadasTesteC10() throws InvalidComparacaoException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("DATA_VENCIMENTO");
        assertEquals(0, tarefasBuscadas.size());
    }

    @Test
    void buscarTarefasOrdenadasTesteC11() throws InvalidComparacaoException, InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "29/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "29/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "BAIXA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("DATA_VENCIMENTO");
        assertEquals(6, tarefasBuscadas.size());

        assertEquals(tarefasBuscadas.get(0).getDataVencimento(), "23/09/2024");
        assertEquals(tarefasBuscadas.get(5).getDataVencimento(), "29/09/2024");
        assertEquals(tarefasBuscadas.get(0).getPrioridade(), TarefaPrioridade.PRIORIDADE_ALTA);
        assertEquals(tarefasBuscadas.get(5).getPrioridade(), TarefaPrioridade.PRIORIDADE_BAIXA);
    }

    @Test
    void buscarTarefasOrdenadasTesteC12() throws InvalidComparacaoException, InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "29/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "29/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "29/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "29/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "29/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "29/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "BAIXA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("DATA_VENCIMENTO");
        assertEquals(18, tarefasBuscadas.size());

        assertEquals(tarefasBuscadas.getFirst().getDataVencimento(), "23/09/2024");
        assertEquals(tarefasBuscadas.get(17).getDataVencimento(), "29/09/2024");
        assertEquals(tarefasBuscadas.getFirst().getPrioridade(), TarefaPrioridade.PRIORIDADE_ALTA);
        assertEquals(tarefasBuscadas.get(17).getPrioridade(), TarefaPrioridade.PRIORIDADE_BAIXA);
    }

    @Test
    void buscarTarefasOrdenadasTesteC13() throws InvalidComparacaoException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("PRIORIDADE");
        assertEquals(0, tarefasBuscadas.size());
    }

    @Test
    void buscarTarefasOrdenadasTesteC14() throws InvalidComparacaoException, InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "29/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "29/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "BAIXA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("PRIORIDADE");
        assertEquals(6, tarefasBuscadas.size());

        assertEquals(tarefasBuscadas.get(0).getDataVencimento(), "23/09/2024");
        assertEquals(tarefasBuscadas.get(5).getDataVencimento(), "29/09/2024");
        assertEquals(tarefasBuscadas.get(0).getPrioridade(), TarefaPrioridade.PRIORIDADE_ALTA);
        assertEquals(tarefasBuscadas.get(5).getPrioridade(), TarefaPrioridade.PRIORIDADE_BAIXA);
    }

    @Test
    void buscarTarefasOrdenadasTesteC15() throws InvalidComparacaoException, InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "29/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "29/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "29/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "29/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "29/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "29/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "BAIXA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("PRIORIDADE");
        assertEquals(18, tarefasBuscadas.size());

        assertEquals(tarefasBuscadas.getFirst().getDataVencimento(), "23/09/2024");
        assertEquals(tarefasBuscadas.get(17).getDataVencimento(), "29/09/2024");
        assertEquals(tarefasBuscadas.getFirst().getPrioridade(), TarefaPrioridade.PRIORIDADE_ALTA);
        assertEquals(tarefasBuscadas.get(17).getPrioridade(), TarefaPrioridade.PRIORIDADE_BAIXA);
    }

    @Test
    void buscarTarefasOrdenadasTesteC16() throws InvalidComparacaoException{
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("");
        assertEquals(0, tarefasBuscadas.size());

    }

    @Test
    void buscarTarefasOrdenadasTesteC17() throws InvalidComparacaoException, InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "29/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "29/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "BAIXA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("");
        assertEquals(6, tarefasBuscadas.size());

        assertEquals(tarefasBuscadas.getFirst().getTitulo(), "Título Testagem");
        assertEquals(tarefasBuscadas.get(5).getTitulo(), "Título Testagem Final");
        assertEquals(tarefasBuscadas.getFirst().getPrioridade(), TarefaPrioridade.PRIORIDADE_ALTA);
        assertEquals(tarefasBuscadas.get(5).getPrioridade(), TarefaPrioridade.PRIORIDADE_BAIXA);
    }


    @Test
    void buscarTarefasOrdenadasTesteC18() throws InvalidComparacaoException, InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "29/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "29/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "29/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "29/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "29/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "29/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "BAIXA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "BAIXA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("");
        assertEquals(18, tarefasBuscadas.size());

        assertEquals(tarefasBuscadas.getFirst().getTitulo(), "Título Testagem");
        assertEquals(tarefasBuscadas.get(17).getTitulo(), "Título Testagem Final");
        assertEquals(tarefasBuscadas.getFirst().getPrioridade(), TarefaPrioridade.PRIORIDADE_ALTA);
        assertEquals(tarefasBuscadas.get(17).getPrioridade(), TarefaPrioridade.PRIORIDADE_BAIXA);
    }

    @Test
    void buscarTarefasOrdenadasTesteC19() {
        assertThrows((InvalidComparacaoException.class), () -> {
            this.tarefaService.buscarTarefasOrdenadas(null);
        });
    }

    @Test
    void marcarPrioridadeTesteC20() {
        assertThrows(InvalidIDException.class, () -> this.tarefaService.marcarPrioridade(null, "BAIXA"));
    }

    @Test
    void marcarPrioridadeTesteC21() {
        assertThrows(InvalidIDException.class, () -> this.tarefaService.marcarPrioridade("", "BAIXA"));
    }

    @Test
    void marcarPrioridadeTesteC22() {
        assertThrows(InvalidIDException.class, () -> this.tarefaService.marcarPrioridade("     ", "BAIXA"));
    }

    @Test
    void marcarPrioridadeTesteC23() {
        assertThrows(InvalidTarefaException.class, () -> this.tarefaService.marcarPrioridade("ABCDEF", "BAIXA"));
    }

    @Test
    void marcarPrioridadeTesteC24() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaTesteOutra = this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaTesteFinal = this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "ALTA");

        assertThrows(InvalidPrioridadeException.class, () -> this.tarefaService.marcarPrioridade(tarefaTeste.getId(), null));
    }


    @Test
    void marcarPrioridadeTesteC25() throws InvalidPrioridadeException, InvalidIDException, InvalidTarefaException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaTesteOutra = this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaTesteFinal = this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "ALTA");


        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(3, tarefasBuscadas.size());

        Tarefa tarefaRemarcada = this.tarefaService.marcarPrioridade(tarefaTeste.getId(), "BAIXA");
        assertEquals(tarefaRemarcada.getPrioridade(), TarefaPrioridade.PRIORIDADE_BAIXA);

        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(3, tarefasBuscadas.size());
    }

    @Test
    void marcarPrioridadeTesteC26() throws InvalidPrioridadeException, InvalidIDException, InvalidTarefaException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaTesteOutra = this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaTesteFinal = this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "ALTA");


        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(3, tarefasBuscadas.size());

        Tarefa tarefaRemarcada = this.tarefaService.marcarPrioridade(tarefaTeste.getId(), "ALTA");
        assertEquals(tarefaRemarcada.getPrioridade(), TarefaPrioridade.PRIORIDADE_ALTA);

        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(3, tarefasBuscadas.size());
    }

    @Test
    void removerTarefaTesteC27() {
        assertThrows(InvalidIDException.class, () -> this.tarefaService.removerTarefa(null));
    }

    @Test
    void removerTarefaTesteC28() {
        assertThrows(InvalidIDException.class, () -> this.tarefaService.removerTarefa(""));
    }

    @Test
    void removerTarefaTesteC29() {
        assertThrows(InvalidIDException.class, () -> this.tarefaService.removerTarefa("    "));
    }

    @Test
    void removerTarefaTesteC30() {
        assertThrows(InvalidTarefaException.class, () -> this.tarefaService.removerTarefa("ABCDEFG"));
    }

    @Test
    void removerTarefaTesteC31() throws InvalidIDException, InvalidTarefaException, InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaTesteOutra = this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaTesteFinal = this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "ALTA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(3, tarefasBuscadas.size());

        Boolean status = this.tarefaService.removerTarefa(tarefaTeste.getId());
        assertTrue(status);

        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(2, tarefasBuscadas.size());
    }

    @Test
    void criarTarefaTesteC32() {
        assertThrows(InvalidTituloException.class, () -> this.tarefaService.criarTarefa(null, "Descrição Criada", "23/09/2024", "ALTA"));
    }

    @Test
    void criarTarefaTesteC33() {
        assertThrows(InvalidTituloException.class, () -> this.tarefaService.criarTarefa("", "Descrição Criada", "23/09/2024", "ALTA"));
    }

    @Test
    void criarTarefaTesteC34() {
        assertThrows(InvalidTituloException.class, () -> this.tarefaService.criarTarefa("    ", "Descrição Criada", "23/09/2024", "ALTA"));
    }

    @Test
    void criarTarefaTesteC35() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(0, tarefasBuscadas.size());


        Tarefa tarefaCriada = this.tarefaService.criarTarefa("T", "Descrição", "25/09/2024", "ALTA");

        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());
    }

    @Test
    void criarTarefaTesteC36() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(0, tarefasBuscadas.size());


        Tarefa tarefaCriada = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());

    }

    @Test
    void criarTarefaTesteC37() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(0, tarefasBuscadas.size());


        Tarefa tarefaCriada = this.tarefaService.criarTarefa("TítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítulo", "Descrição", "25/09/2024", "ALTA");

        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());

    }

    @Test
    void criarTarefaTesteC38() {
        assertThrows(InvalidDescricaoException.class, () -> this.tarefaService.criarTarefa("Título Criada", null, "23/09/2024", "ALTA"));
    }

    @Test
    void criarTarefaTesteC39() {
        assertThrows(InvalidDescricaoException.class, () -> this.tarefaService.criarTarefa("Título Criada", "", "23/09/2024", "ALTA"));
    }

    @Test
    void criarTarefaTesteC40() {
        assertThrows(InvalidDescricaoException.class, () -> this.tarefaService.criarTarefa("Título Criada", "    ", "23/09/2024", "ALTA"));
    }

    @Test
    void criarTarefaTesteC41() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(0, tarefasBuscadas.size());

        Tarefa tarefaCriada = this.tarefaService.criarTarefa("Título", "D", "25/09/2024", "ALTA");

        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());
    }

    @Test
    void criarTarefaTesteC42() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(0, tarefasBuscadas.size());


        Tarefa tarefaCriada = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());
    }

    @Test
    void criarTarefaTesteC43() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(0, tarefasBuscadas.size());


        Tarefa tarefaCriada = this.tarefaService.criarTarefa("Título", "DescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescrição", "25/09/2024", "ALTA");

        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());
    }

    @Test
    void criarTarefaTesteC44() {
        assertThrows(InvalidDataVencimentoException.class, () -> this.tarefaService.criarTarefa("Título Criada", "Descrição Criada", null, "ALTA"));
    }

    @Test
    void criarTarefaTesteC45() {
        assertThrows(InvalidDataVencimentoException.class, () -> this.tarefaService.criarTarefa("Título Criada", "Descrição Criada", "", "ALTA"));
    }


    @Test
    void criarTarefaTesteC46() {
        assertThrows(InvalidDataVencimentoException.class, () -> this.tarefaService.criarTarefa("Título Criada", "Descrição Criada", "    ", "ALTA"));
    }

    @Test
    void criarTarefaTesteC47() {
        assertThrows(InvalidDataVencimentoFormatException.class, () -> this.tarefaService.criarTarefa("Título Criada", "Descrição Criada", "12–01–2024", "ALTA"));
    }

    @Test
    void criarTarefaTesteC48() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(0, tarefasBuscadas.size());


        Tarefa tarefaCriada = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());

    }

    @Test
    void criarTarefaTesteC49() {
        assertThrows(InvalidPrioridadeException.class, () -> this.tarefaService.criarTarefa("Título Criada", "Descrição Criada", "23/09/2024", null));
    }

    @Test
    void criarTarefaTesteC50() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(0, tarefasBuscadas.size());


        Tarefa tarefaCriada = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "BAIXA");

        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());

    }

    @Test
    void criarTarefaTesteC51() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(0, tarefasBuscadas.size());


        Tarefa tarefaCriada = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());

    }

    @Test
    void atualizarTarefaTesteC52(){
        assertThrows(InvalidIDException.class, () -> {
            this.tarefaService.atualizarTarefa(null, tarefaTeste);
        });
    }

    @Test
    void atualizarTarefaTesteC53(){
        assertThrows(InvalidIDException.class, () -> {
            this.tarefaService.atualizarTarefa("", tarefaTeste);
        });
    }

    @Test
    void atualizarTarefaTesteC54(){
        assertThrows(InvalidIDException.class, () -> {
            this.tarefaService.atualizarTarefa("        ", tarefaTeste);
        });
    }

    @Test
    void atualizarTarefaTesteC55(){
        assertThrows(InvalidTarefaException.class, () -> {
            this.tarefaService.atualizarTarefa("ABCDEFG", tarefaTeste);
        });
    }

    @Test
    void atualizarTarefaTesteC56() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidIDException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "23/09/2024", "ALTA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());


        Tarefa tarefaAtualizada = this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        assertEquals(tarefaAtualizada.getTitulo(), "Título");


        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());
    }


    @Test
    void atualizarTarefaTesteC57() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidTituloException.class, () -> {
            tarefaTeste.setTitulo(null);
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
    void atualizarTarefaTesteC58() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidTituloException.class, () -> {
            tarefaTeste.setTitulo("");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
    void atualizarTarefaTesteC59() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidTituloException.class, () -> {
            tarefaTeste.setTitulo("    ");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
    void atualizarTarefaTesteC60() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidIDException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "23/09/2024", "ALTA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());

        tarefaTeste.setTitulo("T");

        Tarefa tarefaAtualizada = this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        assertEquals(tarefaAtualizada.getTitulo(), "T");


        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());
    }

    @Test
    void atualizarTarefaTesteC61() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidIDException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "23/09/2024", "ALTA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());

        tarefaTeste.setTitulo("Título");

        Tarefa tarefaAtualizada = this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        assertEquals(tarefaAtualizada.getTitulo(), "Título");


        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());
    }

    @Test
    void atualizarTarefaTesteC62() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidIDException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "23/09/2024", "ALTA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());

        tarefaTeste.setTitulo("TítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítulo");

        Tarefa tarefaAtualizada = this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        assertEquals(tarefaAtualizada.getTitulo(), "TítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítulo");


        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());
    }


    @Test
    void atualizarTarefaTesteC63() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidDescricaoException.class, () -> {
            tarefaTeste.setDescricao(null);
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
    void atualizarTarefaTesteC64() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidDescricaoException.class, () -> {
            tarefaTeste.setDescricao("");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
    void atualizarTarefaTesteC65() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidDescricaoException.class, () -> {
            tarefaTeste.setDescricao("        ");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
        void atualizarTarefaTesteC66() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidIDException, InvalidTituloException {
            this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "23/09/2024", "ALTA");

            List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
            assertEquals(1, tarefasBuscadas.size());

            tarefaTeste.setDescricao("D");

            Tarefa tarefaAtualizada = this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
            assertEquals(tarefaAtualizada.getDescricao(), "D");


            tarefasBuscadas = this.tarefaService.buscarTarefas();
            assertEquals(1, tarefasBuscadas.size());
    }

    @Test
    void atualizarTarefaTesteC67() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidIDException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "23/09/2024", "ALTA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());

        tarefaTeste.setDescricao("Descrição");

        Tarefa tarefaAtualizada = this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        assertEquals(tarefaAtualizada.getDescricao(), "Descrição");


        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());
    }

    @Test
    void atualizarTarefaTesteC68() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidIDException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "23/09/2024", "ALTA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());

        tarefaTeste.setDescricao("DescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescrição");

        Tarefa tarefaAtualizada = this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        assertEquals(tarefaAtualizada.getDescricao(), "DescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescrição");


        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());
    }


    @Test
    void atualizarTarefaTesteC69() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidDataVencimentoException.class, () -> {
            tarefaTeste.setDataVencimento(null);
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
    void atualizarTarefaTesteC70() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidDataVencimentoException.class, () -> {
            tarefaTeste.setDataVencimento("");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
    void atualizarTarefaTesteC71() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidDataVencimentoException.class, () -> {
            tarefaTeste.setDataVencimento("    ");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
    void atualizarTarefaTesteC72() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidDataVencimentoFormatException.class, () -> {
            tarefaTeste.setDataVencimento("12-01-2024");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
    void atualizarTarefaTesteC73() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidIDException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "23/09/2024", "ALTA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());

        tarefaTeste.setDataVencimento("25/09/2024");

        Tarefa tarefaAtualizada = this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        assertEquals(tarefaAtualizada.getDataVencimento(), "25/09/2024");


        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());
    }


    @Test
    void atualizarTarefaTesteC74() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidPrioridadeException.class, () -> {
            tarefaTeste.setPrioridade(null);
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
    void atualizarTarefaTesteC75() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidIDException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());

        tarefaTeste.setPrioridade(TarefaPrioridade.PRIORIDADE_BAIXA);

        Tarefa tarefaAtualizada = this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        assertEquals(tarefaAtualizada.getPrioridade(), TarefaPrioridade.PRIORIDADE_BAIXA);


        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());
    }

    @Test
    void atualizarTarefaTesteC76() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidIDException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());

        tarefaTeste.setPrioridade(TarefaPrioridade.PRIORIDADE_BAIXA);

        Tarefa tarefaAtualizada = this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        assertEquals(tarefaAtualizada.getPrioridade(), TarefaPrioridade.PRIORIDADE_BAIXA);


        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());
    }

}

