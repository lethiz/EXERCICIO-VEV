package main.repository;

import main.exceptions.InvalidIDException;
import main.exceptions.Model.InvalidDataVencimentoException;
import main.exceptions.Model.InvalidDescricaoException;
import main.exceptions.Model.InvalidPrioridadeException;
import main.exceptions.Model.InvalidTituloException;
import main.exceptions.Repository.InvalidTarefaException;
import main.models.Tarefa;
import main.util.TarefaPrioridade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TarefaRepositoryTest {

    private Tarefa tarefaTeste;
    private Tarefa tarefaTesteOutra;
    private ITarefaRepository tarefaRepository;

    @BeforeEach
    public void prepararTest() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDescricaoException, InvalidTituloException, InvalidTarefaException {
        this.tarefaRepository = new TarefaRepository();
        this.tarefaTeste = new Tarefa("Título Testagem", "Descrição Testagem", "23/09/2024", TarefaPrioridade.PRIORIDADE_ALTA);
        this.tarefaTesteOutra = new Tarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", TarefaPrioridade.PRIORIDADE_MEDIA);
        this.tarefaRepository.adicionarTarefa(tarefaTeste);
        this.tarefaRepository.adicionarTarefa(tarefaTesteOutra);
    }

    @Test
    void recuperarTarefasTeste() {
        HashMap<String, Tarefa> tarefas =  this.tarefaRepository.recuperarTarefas();
        Integer contagem = tarefas.size();
        assertEquals(contagem, 2);
    }

    @Test
    void recuperarTarefaTeste() throws InvalidTarefaException, InvalidIDException {
        Tarefa tarefaRecuperada =  this.tarefaRepository.recuperarTarefa(tarefaTeste.getId());
        assertEquals("Título Testagem", tarefaRecuperada.getTitulo());
        assertEquals("Descrição Testagem", tarefaRecuperada.getDescricao());
        assertEquals("23/09/2024", tarefaRecuperada.getDataVencimento());
        assertEquals(TarefaPrioridade.PRIORIDADE_ALTA, tarefaRecuperada.getPrioridade());
        assertEquals(tarefaTeste, tarefaRecuperada);
    }

    @Test
    void recuperarTarefaNulaTeste() {
        assertThrows(InvalidIDException.class, () -> {
            this.tarefaRepository.recuperarTarefa(null);
        });
    }

    @Test
    void buscarTarefasTeste() throws InvalidTituloException {
        List<Tarefa> tarefasBuscadas =  this.tarefaRepository.buscarTarefas("Título Testagem");
        assertEquals(1, tarefasBuscadas.size());
        assertEquals(tarefaTeste, tarefasBuscadas.getFirst());
        assertEquals("Título Testagem", tarefasBuscadas.getFirst().getTitulo());
    }

    @Test
    void adicionarTarefaTeste() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDescricaoException, InvalidTituloException, InvalidTarefaException {
        Tarefa tarefaCriada = new Tarefa("Título Criada", "Descrição Criada", "26/09/2024", TarefaPrioridade.PRIORIDADE_BAIXA);
        Boolean tarefa =  this.tarefaRepository.adicionarTarefa(tarefaCriada);
        assertTrue(tarefa);

        HashMap<String, Tarefa> tarefas =  this.tarefaRepository.recuperarTarefas();
        Integer contagem = tarefas.size();
        assertEquals(contagem, 3);
    }

    @Test
    void adicionarTarefaNulaTeste() {
        assertThrows(InvalidTarefaException.class, () -> {
            this.tarefaRepository.adicionarTarefa(null);
        });
    }

    @Test
    void atualizarTarefaTeste() throws InvalidDescricaoException, InvalidTarefaException, InvalidPrioridadeException, InvalidDataVencimentoException, InvalidTituloException, InvalidIDException {
        this.tarefaTeste.setDescricao("Nova Descrição");
        Boolean tarefa = this.tarefaRepository.atualizarTarefa(tarefaTeste);
        assertTrue(tarefa);

        HashMap<String, Tarefa> tarefas =  this.tarefaRepository.recuperarTarefas();
        Integer contagem = tarefas.size();
        assertEquals(contagem, 2);

        Tarefa tarefaRecuperada = null;
        tarefaRecuperada = this.tarefaRepository.recuperarTarefa(tarefaTeste.getId());

        assertEquals("Nova Descrição", tarefaRecuperada.getDescricao());

    }

    @Test
    void atualizarTarefaNulaTeste(){
        assertThrows(InvalidTarefaException.class, () -> {
            this.tarefaRepository.atualizarTarefa(null);
        });
    }

    @Test
    void removerTarefaTeste() throws InvalidIDException, InvalidTarefaException {
        Boolean tarefaRemovida =  this.tarefaRepository.removerTarefa(tarefaTeste.getId());
        assertTrue(tarefaRemovida);

        HashMap<String, Tarefa> tarefas =  this.tarefaRepository.recuperarTarefas();
        Integer contagem = tarefas.size();
        assertEquals(contagem, 1);

    }

    @Test
    void removerTarefaNulaTeste() {
        assertThrows(InvalidTarefaException.class, () -> {
                this.tarefaRepository.removerTarefa(null);
            });
    }
}