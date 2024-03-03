package main.repository;

import main.exceptions.Model.*;
import main.models.Tarefa;
import main.util.TarefaPrioridade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TarefaRepositoryTest {

    private Tarefa tarefaTeste;
    private Tarefa tarefaTesteOutra;
    private ITarefaRepository tarefaRepository;

    @BeforeEach
    public void prepararTest() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDescricaoException, InvalidTituloException, InvalidDataVencimentoFormatException {
        this.tarefaRepository = new TarefaRepository();
        this.tarefaTeste = new Tarefa("Título Testagem", "Descrição Testagem", "23/09/2024", TarefaPrioridade.PRIORIDADE_ALTA);
        this.tarefaTesteOutra = new Tarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", TarefaPrioridade.PRIORIDADE_MEDIA);
        this.tarefaRepository.adicionarTarefa(tarefaTeste);
        this.tarefaRepository.adicionarTarefa(tarefaTesteOutra);
    }

    @Test
    void contarTarefasTeste() {
        Integer contagem =  this.tarefaRepository.contarTarefas();
        assertEquals(contagem, 2);
    }

    @Test
    void recuperarTarefasTeste() {
        HashMap<String, Tarefa> tarefasRecuperadas =  this.tarefaRepository.recuperarTarefas();
        Integer contagem = tarefasRecuperadas.size();
        assertEquals(contagem, 2);

        Tarefa[] tarefasTarget = {tarefaTeste, tarefaTesteOutra};
        assertArrayEquals(tarefasRecuperadas.values().toArray(), tarefasTarget);
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

        Tarefa[] tarefasTarget = {tarefaTeste, tarefaTesteOutra};
        assertArrayEquals(tarefasBuscadas.toArray(), tarefasTarget);
    }

    @Test
    void adicionarTarefaTeste() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDescricaoException, InvalidTituloException, InvalidDataVencimentoFormatException {
        Integer contagem =  this.tarefaRepository.contarTarefas();
        assertEquals(contagem, 2);

        Tarefa tarefaCriada = new Tarefa("Título Criada", "Descrição Criada", "26/09/2024", TarefaPrioridade.PRIORIDADE_BAIXA);

        Tarefa tarefaAdicionada =  this.tarefaRepository.adicionarTarefa(tarefaCriada);
        assertEquals("Título Criado", tarefaAdicionada.getTitulo());
        assertEquals("Descrição Criação", tarefaAdicionada.getDescricao());
        assertEquals("26/09/2024", tarefaAdicionada.getDataVencimento());
        assertEquals(TarefaPrioridade.PRIORIDADE_BAIXA, tarefaAdicionada.getPrioridade());

        contagem =  this.tarefaRepository.contarTarefas();
        assertEquals(contagem, 3);
    }

    @Test
    void atualizarTarefaTeste() throws InvalidDescricaoException {
        Integer contagem =  this.tarefaRepository.contarTarefas();
        assertEquals(contagem, 2);

        this.tarefaTeste.setDescricao("Nova Descrição");
        Tarefa tarefa = this.tarefaRepository.atualizarTarefa(tarefaTeste);
        assertEquals(tarefa.getDescricao(), "Nova Descrição");

        contagem =  this.tarefaRepository.contarTarefas();
        assertEquals(contagem, 2);

        Tarefa tarefaRecuperada = this.tarefaRepository.recuperarTarefa(tarefaTeste.getId());

        assertEquals("Nova Descrição", tarefaRecuperada.getDescricao());
    }

    @Test
    void removerTarefaTeste() {
        Integer contagem =  this.tarefaRepository.contarTarefas();
        assertEquals(contagem, 2);

        Boolean status =  this.tarefaRepository.removerTarefa(tarefaTeste.getId());
        assertTrue(status);

        contagem =  this.tarefaRepository.contarTarefas();
        assertEquals(contagem, 2);
    }

}