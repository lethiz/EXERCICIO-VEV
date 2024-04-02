package main.junit5Tests;

import main.exceptions.InvalidIDException;
import main.exceptions.Model.*;
import main.exceptions.Service.InvalidComparacaoException;
import main.exceptions.Service.InvalidTarefaException;
import main.models.Tarefa;
import main.services.ITarefaService;
import main.services.TarefaService;
import main.util.TarefaPrioridade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

public class TarefaServiceUnitTest {
    private Tarefa tarefaTeste;
    private Tarefa tarefaTesteOutra;
    private Tarefa tarefaTesteFinal;
    private ITarefaService tarefaService;

    @BeforeEach
    public void prepararTest() {
        this.tarefaService = new TarefaService();
    }

    @Test
    @DisplayName("Teste de Buscar Tarefas: sem tarefas registradas")
    void buscarTarefasTesteC1() {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(0, tarefasBuscadas.size());
    }

    @Test
    @DisplayName("Teste de Buscar Tarefas: com poucas tarefas registradas")
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
    @DisplayName("Teste de Buscar Tarefas: com muitas tarefas registradas")
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
    @DisplayName("Teste de Buscar Tarefas ordenadas por Prioridades: sem tarefas registradas")
    void buscarTarefasPrioridadeTesteC4() {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasPrioridade();
        assertEquals(0, tarefasBuscadas.size());
    }

    @Test
    @DisplayName("Teste de Buscar Tarefas ordenadas por Prioridades: com poucas tarefas registradas")
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
    @DisplayName("Teste de Buscar Tarefas ordenadas por Prioridades: com muitas tarefas registradas")
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
    @DisplayName("Teste de Buscar Tarefas ordenadas por Data de Vencimento: sem tarefas registradas")
    void buscarTarefasDataVencimentoTesteC7() {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasDataVencimento();
        assertEquals(0, tarefasBuscadas.size());
    }

    @Test
    @DisplayName("Teste de Buscar Tarefas ordenadas por Data de Vencimento: com poucas tarefas registradas")
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
    @DisplayName("Teste de Buscar Tarefas ordenadas por Data de Vencimento: com muitas tarefas registradas")
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
    @DisplayName("Teste de Buscar Tarefas ordenadas por Data de Vencimento e depois Prioridade: sem tarefas registradas")
    void buscarTarefasOrdenadasTesteC10() throws InvalidComparacaoException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("DATA_VENCIMENTO");
        assertEquals(0, tarefasBuscadas.size());
    }

    @Test
    @DisplayName("Teste de Buscar Tarefas ordenadas por Data de Vencimento e depois Prioridade: com poucas tarefas registradas")
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
    @DisplayName("Teste de Buscar Tarefas ordenadas por Data de Vencimento e depois Prioridade: com muitas tarefas registradas")
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
    @DisplayName("Teste de Buscar Tarefas ordenadas por Prioridade e depois Data de Vencimento: sem tarefas registradas")
    void buscarTarefasOrdenadasTesteC13() throws InvalidComparacaoException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("PRIORIDADE");
        assertEquals(0, tarefasBuscadas.size());
    }

    @Test
    @DisplayName("Teste de Buscar Tarefas ordenadas por Prioridade e depois Data de Vencimento: com poucas tarefas registradas")
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
    @DisplayName("Teste de Buscar Tarefas ordenadas por Prioridade e depois Data de Vencimento: com muitas tarefas registradas")
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
    @DisplayName("Teste de Buscar Tarefas ordenadas por Título e depois Prioridade: sem tarefas registradas")
    void buscarTarefasOrdenadasTesteC16() throws InvalidComparacaoException{
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("");
        assertEquals(0, tarefasBuscadas.size());

    }

    @Test
    @DisplayName("Teste de Buscar Tarefas ordenadas por Título e depois Prioridade: com poucas tarefas registradas")
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
    @DisplayName("Teste de Buscar Tarefas ordenadas por Título e depois Prioridade: com muitas tarefas registradas")
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
    @DisplayName("Teste de Buscar Tarefas ordenadas por Critério: string null")
    void buscarTarefasOrdenadasTesteC19() {
        assertThrows((InvalidComparacaoException.class), () -> {
            this.tarefaService.buscarTarefasOrdenadas(null);
        });
    }

    @Test
    @DisplayName("Teste de Marcar Prioridade: id da tarefa null")
    void marcarPrioridadeTesteC20() {
        assertThrows(InvalidIDException.class, () -> this.tarefaService.marcarPrioridade(null, "BAIXA"));
    }

    @Test
    @DisplayName("Teste de Marcar Prioridade: id da tarefa vazio")
    void marcarPrioridadeTesteC21() {
        assertThrows(InvalidIDException.class, () -> this.tarefaService.marcarPrioridade("", "BAIXA"));
    }

    @Test
    @DisplayName("Teste de Marcar Prioridade: id da tarefa em branco")
    void marcarPrioridadeTesteC22() {
        assertThrows(InvalidIDException.class, () -> this.tarefaService.marcarPrioridade("     ", "BAIXA"));
    }

    @Test
    @DisplayName("Teste de Marcar Prioridade: id da tarefa não existente no banco")
    void marcarPrioridadeTesteC23() {
        assertThrows(InvalidTarefaException.class, () -> this.tarefaService.marcarPrioridade("ABCDEF", "BAIXA"));
    }

    @Test
    @DisplayName("Teste de Marcar Prioridade: prioridade null")
    void marcarPrioridadeTesteC24() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaTesteOutra = this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaTesteFinal = this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "ALTA");

        assertThrows(InvalidPrioridadeException.class, () -> this.tarefaService.marcarPrioridade(tarefaTeste.getId(), null));
    }


    @ParameterizedTest
    @DisplayName("Teste de Marcar Prioridade: corretamente marca prioridade como alta, baixa, média ou indefinida")
    @ValueSource(strings = {"BAIXA", "MÉDIA", "ALTA"})
    void marcarPrioridadeTesteC25(String prioridade) throws InvalidPrioridadeException, InvalidIDException, InvalidTarefaException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaTesteOutra = this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaTesteFinal = this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "ALTA");


        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(3, tarefasBuscadas.size());

        Tarefa tarefaRemarcada = this.tarefaService.marcarPrioridade(tarefaTeste.getId(), prioridade);

        assertEquals(tarefaRemarcada.getPrioridade(), checarPrioridade(prioridade));

        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(3, tarefasBuscadas.size());
    }

    private TarefaPrioridade checarPrioridade(String prioridade){
        return switch (prioridade) {
            case "ALTA" -> TarefaPrioridade.PRIORIDADE_ALTA;
            case "MÉDIA" -> TarefaPrioridade.PRIORIDADE_MEDIA;
            case "BAIXA" -> TarefaPrioridade.PRIORIDADE_BAIXA;
            case null, default -> TarefaPrioridade.PRIORIDADE_INDEFINIDA;
        };
    }

    @Test
    @DisplayName("Teste de Remover Tarefa: id de tarefa null")
    void removerTarefaTesteC27() {
        assertThrows(InvalidIDException.class, () -> this.tarefaService.removerTarefa(null));
    }

    @Test
    @DisplayName("Teste de Remover Tarefa: id de tarefa vazio")
    void removerTarefaTesteC28() {
        assertThrows(InvalidIDException.class, () -> this.tarefaService.removerTarefa(""));
    }

    @Test
    @DisplayName("Teste de Remover Tarefa: id de tarefa em branco")
    void removerTarefaTesteC29() {
        assertThrows(InvalidIDException.class, () -> this.tarefaService.removerTarefa("    "));
    }

    @Test
    @DisplayName("Teste de Remover Tarefa: id da tarefa não existente no banco")
    void removerTarefaTesteC30() {
        assertThrows(InvalidTarefaException.class, () -> this.tarefaService.removerTarefa("ABCDEFG"));
    }

    @Test
    @DisplayName("Teste de Remover Tarefa: corretamente com id existente no banco")
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
    @DisplayName("Teste de Criar Tarefa: título null")
    void criarTarefaTesteC32() {
        assertThrows(InvalidTituloException.class, () -> this.tarefaService.criarTarefa(null, "Descrição Criada", "23/09/2024", "ALTA"));
    }

    @Test
    @DisplayName("Teste de Criar Tarefa: título vazio")
    void criarTarefaTesteC33() {
        assertThrows(InvalidTituloException.class, () -> this.tarefaService.criarTarefa("", "Descrição Criada", "23/09/2024", "ALTA"));
    }

    @Test
    @DisplayName("Teste de Criar Tarefa: título em branco")
    void criarTarefaTesteC34() {
        assertThrows(InvalidTituloException.class, () -> this.tarefaService.criarTarefa("    ", "Descrição Criada", "23/09/2024", "ALTA"));
    }

    @ParameterizedTest
    @DisplayName("Teste de Criar Tarefa: corretamente criar com títulos diferentes")
    @ValueSource(strings = {"T", "Título", "TítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítulo"})
    void criarTarefaTesteC35(String titulo) throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(0, tarefasBuscadas.size());

        Tarefa tarefaCriada = this.tarefaService.criarTarefa(titulo, "Descrição", "25/09/2024", "ALTA");

        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());
    }

    @Test
    @DisplayName("Teste de Criar Tarefa: descrição null")
    void criarTarefaTesteC38() {
        assertThrows(InvalidDescricaoException.class, () -> this.tarefaService.criarTarefa("Título Criada", null, "23/09/2024", "ALTA"));
    }

    @Test
    @DisplayName("Teste de Criar Tarefa: descrição vazia")
    void criarTarefaTesteC39() {
        assertThrows(InvalidDescricaoException.class, () -> this.tarefaService.criarTarefa("Título Criada", "", "23/09/2024", "ALTA"));
    }

    @Test
    @DisplayName("Teste de Criar Tarefa: descrição em branco")
    void criarTarefaTesteC40() {
        assertThrows(InvalidDescricaoException.class, () -> this.tarefaService.criarTarefa("Título Criada", "    ", "23/09/2024", "ALTA"));
    }

    
    @ParameterizedTest
    @DisplayName("Teste de Criar Tarefa: corretamente criar com títulos diferentes")
    @ValueSource(strings = {"D", "Descrição", "DescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescrição"})
    void criarTarefaTesteC41(String descricao) throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(0, tarefasBuscadas.size());

        Tarefa tarefaCriada = this.tarefaService.criarTarefa("Título", descricao, "25/09/2024", "ALTA");

        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());
    }

    @Test
    @DisplayName("Teste de Criar Tarefa: data de vencimento null")
    void criarTarefaTesteC44() {
        assertThrows(InvalidDataVencimentoException.class, () -> this.tarefaService.criarTarefa("Título Criada", "Descrição Criada", null, "ALTA"));
    }

    @Test
    @DisplayName("Teste de Criar Tarefa: data de vencimento em formato vazia")
    void criarTarefaTesteC45() {
        assertThrows(InvalidDataVencimentoException.class, () -> this.tarefaService.criarTarefa("Título Criada", "Descrição Criada", "", "ALTA"));
    }

    @Test
    @DisplayName("Teste de Criar Tarefa: data de vencimento em formato em branco")
    void criarTarefaTesteC46() {
        assertThrows(InvalidDataVencimentoException.class, () -> this.tarefaService.criarTarefa("Título Criada", "Descrição Criada", "    ", "ALTA"));
    }

    @Test
    @DisplayName("Teste de Criar Tarefa: data de vencimento em formato inválido")
    void criarTarefaTesteC47() {
        assertThrows(InvalidDataVencimentoFormatException.class, () -> this.tarefaService.criarTarefa("Título Criada", "Descrição Criada", "12–01–2024", "ALTA"));
    }

    @ParameterizedTest
    @DisplayName("Teste de Criar Tarefa: corretamente criar com datas de vencimento diferentes")
    @ValueSource(strings = {"25/09/2024", "29/09/2024", "10/01/2025"})
    void criarTarefaTesteC48() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(0, tarefasBuscadas.size());


        Tarefa tarefaCriada = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());

    }

    @Test
    @DisplayName("Teste de Criar Tarefa: prioridade null")
    void criarTarefaTesteC49() {
        assertThrows(InvalidPrioridadeException.class, () -> this.tarefaService.criarTarefa("Título Criada", "Descrição Criada", "23/09/2024", null));
    }

    @ParameterizedTest
    @DisplayName("Teste de Criar Tarefa: corretamente criar prioridades diferentes")
    @ValueSource(strings = {"BAIXA", "MÉDIA", "ALTA"})
    void criarTarefaTesteC50() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(0, tarefasBuscadas.size());


        Tarefa tarefaCriada = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "BAIXA");

        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());

    }

    @Test
    @DisplayName("Teste de Atualizar Tarefa: id de tarefa null")
    void atualizarTarefaTesteC52(){
        assertThrows(InvalidIDException.class, () -> {
            this.tarefaService.atualizarTarefa(null, tarefaTeste);
        });
    }

    @Test
    @DisplayName("Teste de Atualizar Tarefa: id de tarefa vazio")
    void atualizarTarefaTesteC53(){
        assertThrows(InvalidIDException.class, () -> {
            this.tarefaService.atualizarTarefa("", tarefaTeste);
        });
    }

    @Test
    @DisplayName("Teste de Atualizar Tarefa: id de tarefa em branco")
    void atualizarTarefaTesteC54(){
        assertThrows(InvalidIDException.class, () -> {
            this.tarefaService.atualizarTarefa("        ", tarefaTeste);
        });
    }

    @Test
    @DisplayName("Teste de Atualizar Tarefa: id de tarefa não existente no banco")
    void atualizarTarefaTesteC55(){
        assertThrows(InvalidTarefaException.class, () -> {
            this.tarefaService.atualizarTarefa("ABCDEFG", tarefaTeste);
        });
    }

    @Test
    @DisplayName("Teste de Atualizar Tarefa: titulo null")
    void atualizarTarefaTesteC57() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidTituloException.class, () -> {
            tarefaTeste.setTitulo(null);
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
    @DisplayName("Teste de Atualizar Tarefa: titulo vazio")
    void atualizarTarefaTesteC58() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidTituloException.class, () -> {
            tarefaTeste.setTitulo("");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
    @DisplayName("Teste de Atualizar Tarefa: titulo em branco")
    void atualizarTarefaTesteC59() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidTituloException.class, () -> {
            tarefaTeste.setTitulo("    ");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @ParameterizedTest
    @DisplayName("Teste de Atualizar Tarefa: corretamente criar com títulos diferentes")
    @ValueSource(strings = {"T", "Título", "TítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítuloTítulo"})
    void atualizarTarefaTesteC60(String titulo) throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidIDException, InvalidTituloException, InvalidTarefaException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "23/09/2024", "ALTA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());

        tarefaTeste.setTitulo(titulo);

        Tarefa tarefaAtualizada = this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        assertEquals(tarefaAtualizada.getTitulo(), titulo);


        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());
    }

    @Test
    @DisplayName("Teste de Atualizar Tarefa: descricao null")
    void atualizarTarefaTesteC63() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidDescricaoException.class, () -> {
            tarefaTeste.setDescricao(null);
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
    @DisplayName("Teste de Atualizar Tarefa: descricao vazia")
    void atualizarTarefaTesteC64() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidDescricaoException.class, () -> {
            tarefaTeste.setDescricao("");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
    @DisplayName("Teste de Atualizar Tarefa: descricao em branco")
    void atualizarTarefaTesteC65() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidDescricaoException.class, () -> {
            tarefaTeste.setDescricao("        ");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @ParameterizedTest
    @DisplayName("Teste de Atualizar Tarefa: corretamente criar com títulos diferentes")
    @ValueSource(strings = {"D", "Descrição", "DescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescriçãoDescrição"})
    void atualizarTarefaTesteC66(String descricao) throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidIDException, InvalidTituloException, InvalidTarefaException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "23/09/2024", "ALTA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());

        tarefaTeste.setDescricao(descricao);

        Tarefa tarefaAtualizada = this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        assertEquals(tarefaAtualizada.getDescricao(), descricao);


        tarefasBuscadas = this.tarefaService.buscarTarefas();assertEquals(1, tarefasBuscadas.size());
    }


    @Test
    @DisplayName("Teste de Atualizar Tarefa: data de vencimento null")
    void atualizarTarefaTesteC69() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidDataVencimentoException.class, () -> {
            tarefaTeste.setDataVencimento(null);
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
    @DisplayName("Teste de Atualizar Tarefa: data de vencimento vazio")
    void atualizarTarefaTesteC70() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidDataVencimentoException.class, () -> {
            tarefaTeste.setDataVencimento("");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
    @DisplayName("Teste de Atualizar Tarefa: data de vencimento em branco")
    void atualizarTarefaTesteC71() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidDataVencimentoException.class, () -> {
            tarefaTeste.setDataVencimento("    ");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
    @DisplayName("Teste de Atualizar Tarefa: data de vencimento em formato inválido")
    void atualizarTarefaTesteC72() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidDataVencimentoFormatException.class, () -> {
            tarefaTeste.setDataVencimento("12-01-2024");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @ParameterizedTest
    @DisplayName("Teste de Atualizar Tarefa: corretamente criar com datas de vencimento diferentes")
    @ValueSource(strings = {"25/09/2024", "29/09/2024", "10/01/2025"})
    void atualizarTarefaTesteC73(String data_vencimento) throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidIDException, InvalidTituloException, InvalidTarefaException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "23/09/2024", "ALTA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());

        tarefaTeste.setDataVencimento(data_vencimento);

        Tarefa tarefaAtualizada = this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        assertEquals(tarefaAtualizada.getDataVencimento(), data_vencimento);


        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());
    }


    @Test
    @DisplayName("Teste de Atualizar Tarefa: prioridade null")
    void atualizarTarefaTesteC74() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidPrioridadeException.class, () -> {
            tarefaTeste.setPrioridade(null);
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @ParameterizedTest
    @DisplayName("Teste de Criar Tarefa: corretamente criar prioridades diferentes")
    @ValueSource(strings = {"BAIXA", "MÉDIA", "ALTA"})
    void atualizarTarefaTesteC75(String prioridade) throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidIDException, InvalidTituloException, InvalidTarefaException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());

        tarefaTeste.setPrioridade(checarPrioridade(prioridade));

        Tarefa tarefaAtualizada = this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        assertEquals(tarefaAtualizada.getPrioridade(), checarPrioridade(prioridade));


        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());
    }

}

