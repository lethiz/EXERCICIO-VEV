package main.repository;

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
    public void prepararTest(){
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
    void recuperarTarefaTeste() {
        Tarefa tarefaRecuperada =  this.tarefaRepository.recuperarTarefa(tarefaTeste.getId());
        assertEquals("Título Testagem", tarefaRecuperada.getTitulo());
        assertEquals("Descrição Testagem", tarefaRecuperada.getDescricao());
        assertEquals("23/09/2024", tarefaRecuperada.getDataVencimento());
        assertEquals(TarefaPrioridade.PRIORIDADE_ALTA, tarefaRecuperada.getPrioridade());
        assertEquals(tarefaTeste, tarefaRecuperada);
    }

    @Test
    void buscarTarefasTeste() {
        List<Tarefa> tarefasBuscadas =  this.tarefaRepository.buscarTarefas("Título Testagem");
        assertEquals(1, tarefasBuscadas.size());
        assertEquals(tarefaTeste, tarefasBuscadas.getFirst());
        assertEquals("Título Testagem", tarefasBuscadas.getFirst().getTitulo());
    }

    @Test
    void adicionarTarefaTeste() {
        Tarefa tarefa =  this.tarefaRepository.adicionarTarefa();
    }

    @Test
    void atualizarTarefaTeste() {
        Tarefa tarefa =  this.tarefaRepository.atualizarTarefa();
    }

    @Test
    void removerTarefaTeste() {
        Tarefa tarefa =  this.tarefaRepository.removerTarefa();
    }
}