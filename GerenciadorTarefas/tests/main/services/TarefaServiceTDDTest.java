package main.services;

import main.exceptions.InvalidIDException;
import main.exceptions.Model.*;
import main.exceptions.Service.InvalidComparacaoException;
import main.exceptions.Service.InvalidTarefaException;
import main.models.Tarefa;
import main.util.TarefaPrioridade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TarefaServiceTDDTest {
    private Tarefa tarefaTeste;
    private Tarefa tarefaTesteOutra;
    private Tarefa tarefaTesteFinal;
    private ITarefaService tarefaService;

    @BeforeEach
    public void prepararTest() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDescricaoException, InvalidTituloException, InvalidDataVencimentoFormatException {
        this.tarefaService = new TarefaService();
        this.tarefaTeste = this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaTesteOutra =  this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaTesteFinal = this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "ALTA");
    }

    @Test
    void buscarTarefasTeste() {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(3, tarefasBuscadas.size());

        Tarefa[] tarefasTarget = {tarefaTeste, tarefaTesteOutra, tarefaTesteFinal};
        Set<Tarefa> expectedSet = new HashSet<>(Arrays.asList(tarefasTarget));
        Set<Tarefa> actualSet = new HashSet<>(tarefasBuscadas);

        assertEquals(expectedSet, actualSet);
    }

    @Test
    void buscarTarefasOrdenadasTeste() throws InvalidComparacaoException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("PRIORIDADE");
        assertEquals(3, tarefasBuscadas.size());

        Tarefa[] tarefasTarget = {tarefaTeste, tarefaTesteOutra, tarefaTesteFinal};
        Set<Tarefa> expectedSet = new HashSet<>(Arrays.asList(tarefasTarget));
        Set<Tarefa> actualSet = new HashSet<>(tarefasBuscadas);

        assertEquals(expectedSet, actualSet);

        assertEquals(tarefasBuscadas.get(0), tarefaTeste);
        assertEquals(tarefasBuscadas.get(1), tarefaTesteFinal);
        assertEquals(tarefasBuscadas.get(2), tarefaTesteOutra);
    }

    @Test
    void buscarTarefasOrdenadasTesteAlternativo() throws InvalidComparacaoException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("DATA_VENCIMENTO");
        assertEquals(3, tarefasBuscadas.size());

        Tarefa[] tarefasTarget = {tarefaTeste, tarefaTesteOutra, tarefaTesteFinal};
        Set<Tarefa> expectedSet = new HashSet<>(Arrays.asList(tarefasTarget));
        Set<Tarefa> actualSet = new HashSet<>(tarefasBuscadas);

        assertEquals(expectedSet, actualSet);


        assertEquals(tarefasBuscadas.get(0), tarefaTeste);
        assertEquals(tarefasBuscadas.get(1), tarefaTesteFinal);
        assertEquals(tarefasBuscadas.get(2), tarefaTesteOutra);
    }

    @Test
    void buscarTarefasOrdenadasTesteFinal() throws InvalidComparacaoException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("OUTRA_COISA");
        assertEquals(3, tarefasBuscadas.size());

        Tarefa[] tarefasTarget = {tarefaTeste, tarefaTesteOutra, tarefaTesteFinal};
        Set<Tarefa> expectedSet = new HashSet<>(Arrays.asList(tarefasTarget));
        Set<Tarefa> actualSet = new HashSet<>(tarefasBuscadas);

        assertEquals(expectedSet, actualSet);


        assertEquals(tarefasBuscadas.get(0),tarefaTeste);
        assertEquals(tarefasBuscadas.get(1), tarefaTesteFinal);
        assertEquals(tarefasBuscadas.get(2), tarefaTesteOutra);
    }

    @Test
    void buscarTarefasOrdenadasInvalidasTeste()  {
        assertThrows(InvalidComparacaoException.class, () -> this.tarefaService.buscarTarefasOrdenadas(null));
    }

    @Test
    void buscarTarefasPrioridadeTeste() {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasPrioridade();
        assertEquals(3, tarefasBuscadas.size());

        Tarefa[] tarefasTarget = {tarefaTeste, tarefaTesteOutra, tarefaTesteFinal};
        Set<Tarefa> expectedSet = new HashSet<>(Arrays.asList(tarefasTarget));
        Set<Tarefa> actualSet = new HashSet<>(tarefasBuscadas);

        assertEquals(expectedSet, actualSet);

        assertEquals(tarefasBuscadas.get(0).getPrioridade(), TarefaPrioridade.PRIORIDADE_ALTA);
        assertEquals(tarefasBuscadas.get(2).getPrioridade(), TarefaPrioridade.PRIORIDADE_MEDIA);
    }

    @Test
    void buscarTarefasDataVencimentoTeste() {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasDataVencimento();
        assertEquals(3, tarefasBuscadas.size());

        Tarefa[] tarefasTarget = {tarefaTeste, tarefaTesteOutra, tarefaTesteFinal};
        Set<Tarefa> expectedSet = new HashSet<>(Arrays.asList(tarefasTarget));
        Set<Tarefa> actualSet = new HashSet<>(tarefasBuscadas);

        assertEquals(expectedSet, actualSet);

        assertEquals(tarefasBuscadas.get(0).getDataVencimento(), "23/09/2024");
        assertEquals(tarefasBuscadas.get(2).getDataVencimento(),"25/09/2024");
    }

    @Test
    void marcarPrioridadeTeste() throws InvalidPrioridadeException, InvalidIDException, InvalidTarefaException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(3, tarefasBuscadas.size());

        Tarefa tarefaRemarcada = this.tarefaService.marcarPrioridade(tarefaTeste.getId(), "BAIXA");
        assertEquals(tarefaRemarcada.getPrioridade(), TarefaPrioridade.PRIORIDADE_BAIXA);

        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(3, tarefasBuscadas.size());
    }

    @Test
    void marcarPrioridadeInvalidaTeste(){
        assertThrows(InvalidIDException.class, () -> this.tarefaService.marcarPrioridade(null, "BAIXA"));
    }

    @Test
    void recuperarTarefaTeste() throws InvalidIDException, InvalidTarefaException {
        Tarefa tarefasRecuperada = this.tarefaService.recuperarTarefa(tarefaTeste.getId());
        assertEquals("Título Testagem", tarefasRecuperada.getTitulo());
        assertEquals("Descrição Testagem", tarefasRecuperada.getDescricao());
        assertEquals("23/09/2024", tarefasRecuperada.getDataVencimento());
        assertEquals(TarefaPrioridade.PRIORIDADE_ALTA, tarefasRecuperada.getPrioridade());

    }

    @Test
    void recuperarTarefaInvalidaTeste()  {
        assertThrows(InvalidIDException.class, () -> this.tarefaService.recuperarTarefa(null));

    }

    @Test
    void criarTarefaTeste() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(3, tarefasBuscadas.size());


        Tarefa tarefaCriada = this.tarefaService.criarTarefa("Título Criada", "Descrição Criada", "23/09/2024", "BAIXA");

        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(4, tarefasBuscadas.size());

    }

    @Test
    void criarTarefaInvalidaTeste(){
        assertThrows(InvalidDataVencimentoException.class, () -> this.tarefaService.criarTarefa("Título Criada", "Descrição Criada", null, "ALTA"));
        assertThrows(InvalidDataVencimentoException.class, () -> this.tarefaService.criarTarefa("Título Criada", "Descrição Criada", "", "ALTA"));
        assertThrows(InvalidDataVencimentoException.class, () -> this.tarefaService.criarTarefa("Título Criada", "Descrição Criada", "      ", "ALTA"));
        assertThrows(InvalidDataVencimentoFormatException.class, () -> this.tarefaService.criarTarefa("Título Criada", "Descrição Criada", "23-09-2024", "ALTA"));
        assertThrows(InvalidDescricaoException.class, () -> this.tarefaService.criarTarefa("Título Criada", null, "23/09/2024", "ALTA"));
        assertThrows(InvalidDescricaoException.class, () -> this.tarefaService.criarTarefa("Título Criada", "", "23/09/2024", "ALTA"));
        assertThrows(InvalidDescricaoException.class, () -> this.tarefaService.criarTarefa("Título Criada", "    ", "23/09/2024", "ALTA"));
        assertThrows(InvalidTituloException.class, () -> this.tarefaService.criarTarefa(null, "Descrição Criada", "23/09/2024", "ALTA"));
        assertThrows(InvalidTituloException.class, () -> this.tarefaService.criarTarefa("", "Descrição Criada", "23/09/2024", "ALTA"));
        assertThrows(InvalidTituloException.class, () -> this.tarefaService.criarTarefa("    ", "Descrição Criada", "23/09/2024", "ALTA"));
    }

    @Test
    void atualizarTarefaTeste() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidIDException, InvalidTituloException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(3, tarefasBuscadas.size());

        tarefaTeste.setPrioridade(TarefaPrioridade.PRIORIDADE_BAIXA);

        Tarefa tarefaAtualizada = this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        assertEquals(tarefaAtualizada.getPrioridade(), TarefaPrioridade.PRIORIDADE_BAIXA);


        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(3, tarefasBuscadas.size());
    }

    @Test
    void atualizarTarefaInvalidaTeste(){
        assertThrows(InvalidPrioridadeException.class, () -> {
            tarefaTeste.setPrioridade(null);
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
        assertThrows(InvalidDataVencimentoException.class, () -> {
            tarefaTeste.setDataVencimento(null);
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
        assertThrows(InvalidDataVencimentoException.class, () -> {
            tarefaTeste.setDataVencimento("    ");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
        assertThrows(InvalidDataVencimentoException.class, () -> {
            tarefaTeste.setDataVencimento("");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
        assertThrows(InvalidDataVencimentoFormatException.class, () -> {
            tarefaTeste.setDataVencimento("22 de Dezembro d 2024");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });

        assertThrows(InvalidDescricaoException.class, () -> {
            tarefaTeste.setDescricao(null);
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
        assertThrows(InvalidDescricaoException.class, () -> {
            tarefaTeste.setDescricao("   ");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
        assertThrows(InvalidDescricaoException.class, () -> {
            tarefaTeste.setDescricao("");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
        assertThrows(InvalidTituloException.class, () -> {
            tarefaTeste.setTitulo(null);
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
        assertThrows(InvalidTituloException.class, () -> {
            tarefaTeste.setTitulo("     ");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
        assertThrows(InvalidTituloException.class, () -> {
            tarefaTeste.setTitulo("");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
    void removerTarefaTeste() throws InvalidIDException, InvalidTarefaException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(3, tarefasBuscadas.size());

        Boolean status = this.tarefaService.removerTarefa(tarefaTeste.getId());
        assertTrue(status);

        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(2, tarefasBuscadas.size());
    }

    @Test
    void removerTarefaIdInvalidoTeste(){
        assertThrows(InvalidIDException.class, () -> this.tarefaService.removerTarefa(null));
    }

}
