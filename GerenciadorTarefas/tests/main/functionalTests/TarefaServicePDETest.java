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
public class TarefaServicePDETest {

    private Tarefa tarefaTeste;
    private Tarefa tarefaTesteOutra;
    private Tarefa tarefaTesteFinal;
    private ITarefaService tarefaService;


    @BeforeEach
    public void prepararTest() {
        this.tarefaService = new TarefaService();
    }

    @Test
    void listarTarefasTesteC1() {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(0, tarefasBuscadas.size());

        tarefasBuscadas = this.tarefaService.buscarTarefasPrioridade();
        assertEquals(0, tarefasBuscadas.size());

        tarefasBuscadas = this.tarefaService.buscarTarefasDataVencimento();
        assertEquals(0, tarefasBuscadas.size());
    }

    @Test
    void listarTarefasTesteC2() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "ALTA");


        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(6, tarefasBuscadas.size());

        tarefasBuscadas = this.tarefaService.buscarTarefasPrioridade();
        assertEquals(6, tarefasBuscadas.size());

        tarefasBuscadas = this.tarefaService.buscarTarefasDataVencimento();
        assertEquals(6, tarefasBuscadas.size());
    }

    @Test
    void listarTarefasTesteC3() {
        assertThrows((InvalidComparacaoException.class), () -> {
            this.tarefaService.buscarTarefasOrdenadas(null);
        });
    }

    @Test
    void listarTarefasTesteC4() throws InvalidComparacaoException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("DATA_VENCIMENTO");
        assertEquals(0, tarefasBuscadas.size());

        tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("PRIORIDADE");
        assertEquals(0, tarefasBuscadas.size());

        tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("");
        assertEquals(0, tarefasBuscadas.size());
    }

    @Test
    void listarTarefasTesteC5() throws InvalidComparacaoException, InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
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

        tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("DATA_VENCIMENTO");
        assertEquals(6, tarefasBuscadas.size());

        assertEquals(tarefasBuscadas.getFirst().getDataVencimento(), "23/09/2024");
        assertEquals(tarefasBuscadas.get(5).getDataVencimento(), "29/09/2024");
        assertEquals(tarefasBuscadas.getFirst().getPrioridade(), TarefaPrioridade.PRIORIDADE_ALTA);
        assertEquals(tarefasBuscadas.get(5).getPrioridade(), TarefaPrioridade.PRIORIDADE_BAIXA);

        tarefasBuscadas = this.tarefaService.buscarTarefasOrdenadas("");
        assertEquals(6, tarefasBuscadas.size());

        assertEquals(tarefasBuscadas.getFirst().getTitulo(), "Título Testagem");
        assertEquals(tarefasBuscadas.get(5).getTitulo(), "Título Testagem Final");
        assertEquals(tarefasBuscadas.getFirst().getPrioridade(), TarefaPrioridade.PRIORIDADE_ALTA);
        assertEquals(tarefasBuscadas.get(5).getPrioridade(), TarefaPrioridade.PRIORIDADE_BAIXA);
    }

    @Test
    void marcarPrioridadeTesteC6() {
        assertThrows(InvalidIDException.class, () -> this.tarefaService.marcarPrioridade(null, "BAIXA"));
        assertThrows(InvalidIDException.class, () -> this.tarefaService.marcarPrioridade("", "BAIXA"));
        assertThrows(InvalidIDException.class, () -> this.tarefaService.marcarPrioridade("     ", "BAIXA"));
    }


    @Test
    void marcarPrioridadeTesteC7() {
        assertThrows(InvalidTarefaException.class, () -> this.tarefaService.marcarPrioridade("ABCDEF", "BAIXA"));
    }

    @Test
    void marcarPrioridadeTesteC8() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "ALTA");
        this.tarefaTesteOutra = this.tarefaService.criarTarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", "MEDIA");
        this.tarefaTesteFinal = this.tarefaService.criarTarefa("Título Testagem Final", "Descrição Testagem Final", "24/09/2024", "ALTA");

        assertThrows(InvalidPrioridadeException.class, () -> this.tarefaService.marcarPrioridade(tarefaTeste.getId(), null));
    }

    @Test
    void marcarPrioridadeTesteC9() throws InvalidPrioridadeException, InvalidIDException, InvalidTarefaException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
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
    void removerTarefaTesteC10() {
        assertThrows(InvalidIDException.class, () -> this.tarefaService.removerTarefa(null));
        assertThrows(InvalidIDException.class, () -> this.tarefaService.removerTarefa(""));
        assertThrows(InvalidIDException.class, () -> this.tarefaService.removerTarefa("    "));
    }


    @Test
    void removerTarefaTesteC11() {
        assertThrows(InvalidTarefaException.class, () -> this.tarefaService.removerTarefa("ABCDEFG"));
    }

    @Test
    void removerTarefaTesteC12() throws InvalidIDException, InvalidTarefaException, InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
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
    void criarTarefaTesteC13() {
        assertThrows(InvalidTituloException.class, () -> this.tarefaService.criarTarefa(null, "Descrição Criada", "23/09/2024", "ALTA"));
        assertThrows(InvalidTituloException.class, () -> this.tarefaService.criarTarefa("", "Descrição Criada", "23/09/2024", "ALTA"));
        assertThrows(InvalidTituloException.class, () -> this.tarefaService.criarTarefa("    ", "Descrição Criada", "23/09/2024", "ALTA"));
    }

    @Test
    void criarTarefaTesteC14() {
        assertThrows(InvalidDescricaoException.class, () -> this.tarefaService.criarTarefa("Título Criada", null, "23/09/2024", "ALTA"));
        assertThrows(InvalidDescricaoException.class, () -> this.tarefaService.criarTarefa("Título Criada", "", "23/09/2024", "ALTA"));
        assertThrows(InvalidDescricaoException.class, () -> this.tarefaService.criarTarefa("Título Criada", "    ", "23/09/2024", "ALTA"));
    }


    @Test
    void criarTarefaTesteC15() {
        assertThrows(InvalidDataVencimentoException.class, () -> this.tarefaService.criarTarefa("Título Criada", "Descrição Criada", "    ", "ALTA"));
        assertThrows(InvalidDataVencimentoException.class, () -> this.tarefaService.criarTarefa("Título Criada", "Descrição Criada", null, "ALTA"));
        assertThrows(InvalidDataVencimentoException.class, () -> this.tarefaService.criarTarefa("Título Criada", "Descrição Criada", "", "ALTA"));
        assertThrows(InvalidDataVencimentoFormatException.class, () -> this.tarefaService.criarTarefa("Título Criada", "Descrição Criada", "12–01–2024", "ALTA"));
    }

    @Test
    void criarTarefaTesteC16() {
        assertThrows(InvalidPrioridadeException.class, () -> this.tarefaService.criarTarefa("Título Criada", "Descrição Criada", "23/09/2024", null));
    }

    @Test
    void criarTarefaTesteC17() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        List<Tarefa> tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(0, tarefasBuscadas.size());


        Tarefa tarefaCriada = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        tarefasBuscadas = this.tarefaService.buscarTarefas();
        assertEquals(1, tarefasBuscadas.size());
    }

    @Test
    void atualizarTarefaTesteC18(){
        assertThrows(InvalidIDException.class, () -> {
            this.tarefaService.atualizarTarefa(null, tarefaTeste);
        });
        assertThrows(InvalidIDException.class, () -> {
            this.tarefaService.atualizarTarefa("", tarefaTeste);
        });
        assertThrows(InvalidIDException.class, () -> {
            this.tarefaService.atualizarTarefa("        ", tarefaTeste);
        });
    }

    @Test
    void atualizarTarefaTesteC19(){
        assertThrows(InvalidTarefaException.class, () -> {
            this.tarefaService.atualizarTarefa("ABCDEFG", tarefaTeste);
        });
    }

    @Test
    void atualizarTarefaTesteC20() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidTituloException.class, () -> {
            tarefaTeste.setTitulo(null);
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
        assertThrows(InvalidTituloException.class, () -> {
            tarefaTeste.setTitulo("");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
        assertThrows(InvalidTituloException.class, () -> {
            tarefaTeste.setTitulo("    ");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
    void atualizarTarefaTesteC21() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidDescricaoException.class, () -> {
            tarefaTeste.setDescricao(null);
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
        assertThrows(InvalidDescricaoException.class, () -> {
            tarefaTeste.setDescricao("");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
        assertThrows(InvalidDescricaoException.class, () -> {
            tarefaTeste.setDescricao("        ");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
    void atualizarTarefaTeste22() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidDataVencimentoException.class, () -> {
            tarefaTeste.setDataVencimento(null);
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
        assertThrows(InvalidDataVencimentoException.class, () -> {
            tarefaTeste.setDataVencimento("");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
        assertThrows(InvalidDataVencimentoException.class, () -> {
            tarefaTeste.setDataVencimento("    ");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
        assertThrows(InvalidDataVencimentoFormatException.class, () -> {
            tarefaTeste.setDataVencimento("12-01-2024");
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
    void atualizarTarefaTesteC23() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        this.tarefaTeste = this.tarefaService.criarTarefa("Título", "Descrição", "25/09/2024", "ALTA");

        assertThrows(InvalidPrioridadeException.class, () -> {
            tarefaTeste.setPrioridade(null);
            this.tarefaService.atualizarTarefa(tarefaTeste.getId(), tarefaTeste);
        });
    }

    @Test
    void atualizarTarefaTesteC24() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidIDException, InvalidTituloException, InvalidTarefaException {
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
