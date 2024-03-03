package main.services;

import main.exceptions.Model.*;
import main.exceptions.Service.InvalidComparacaoException;
import main.models.Tarefa;
import main.util.TarefaPrioridade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TarefaServiceTest {
    private Tarefa tarefaTeste;
    private Tarefa tarefaTesteOutra;
    private Tarefa tarefaTesteFinal;
    private ITarefaService tarefaService;

    @BeforeEach
    public void prepararTest() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDescricaoException, InvalidTituloException, InvalidDataVencimentoFormatException {
        this.tarefaService = new TarefaService();
        this.tarefaTeste = this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", TarefaPrioridade.PRIORIDADE_ALTA);
        this.tarefaTesteOutra =  this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", TarefaPrioridade.PRIORIDADE_MEDIA);
        this.tarefaTesteFinal = this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", TarefaPrioridade.PRIORIDADE_ALTA);
    }

    @Test
    void buscarTarefasTeste() {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(3, tarefasBuscadas.size());

        Tarefa[] tarefasTarget = {tarefaTeste, tarefaTesteOutra, tarefaTesteFinal};
        assertArrayEquals(tarefasBuscadas.toArray(), tarefasTarget);
    }

    @Test
    void buscarTarefasOrdenadasTeste() throws InvalidComparacaoException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("PRIORIDADE");
        assertEquals(3, tarefasBuscadas.size());

        Tarefa[] tarefasTarget = {tarefaTeste, tarefaTesteOutra, tarefaTesteFinal};
        assertArrayEquals(tarefasBuscadas.toArray(), tarefasTarget);

        assertEquals(tarefasBuscadas.get(0), tarefaTeste);
        assertEquals(tarefasBuscadas.get(1), tarefaTesteOutra);
        assertEquals(tarefasBuscadas.get(2), tarefaTesteFinal);
    }

    @Test
    void buscarTarefasOrdenadasTesteAlternativo() throws InvalidComparacaoException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("DATA_VENCIMENTO");
        assertEquals(3, tarefasBuscadas.size());

        Tarefa[] tarefasTarget = {tarefaTeste, tarefaTesteOutra, tarefaTesteFinal};
        assertArrayEquals(tarefasBuscadas.toArray(), tarefasTarget);

        assertEquals(tarefasBuscadas.get(0), tarefaTeste);
        assertEquals(tarefasBuscadas.get(1), tarefaTesteFinal);
        assertEquals(tarefasBuscadas.get(2), tarefaTesteOutra);
    }
    @Test
    void buscarTarefasOrdenadasTesteFinal() throws InvalidComparacaoException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("OUTRA_COISA");
        assertEquals(3, tarefasBuscadas.size());

        Tarefa[] tarefasTarget = {tarefaTeste, tarefaTesteOutra, tarefaTesteFinal};
        assertArrayEquals(tarefasBuscadas.toArray(), tarefasTarget);

        assertEquals(tarefasBuscadas.get(0),tarefaTesteOutra);
        assertEquals(tarefasBuscadas.get(1), tarefaTeste);
        assertEquals(tarefasBuscadas.get(2), tarefaTesteOutra);
    }

    @Test
    void buscarTarefasOrdenadasInvalidasTeste()  {
        assertThrows(InvalidComparacaoException.class, () -> {
            this.tarefaService.buscarTarefasOrdenadas(null);
        });
    }

}
