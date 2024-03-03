package main.services;

import main.exceptions.Model.*;
import main.models.Tarefa;
import main.util.TarefaPrioridade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TarefaServiceTest {

    private Tarefa tarefaTeste;
    private Tarefa tarefaTesteOutra;
    private ITarefaService tarefaService;

    @BeforeEach
    public void prepararTest() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDescricaoException, InvalidTituloException, InvalidDataVencimentoFormatException {
        this.tarefaService = new TarefaService();
        this.tarefaTeste = new Tarefa("Título Testagem", "Descrição Testagem", "23/09/2024", TarefaPrioridade.PRIORIDADE_ALTA);
        this.tarefaTesteOutra = new Tarefa("Título Outra Testagem", "Descrição Outra Testagem", "25/09/2024", TarefaPrioridade.PRIORIDADE_MEDIA);

    }

        @Test
    void buscarTarefasTeste() {
    }

    @Test
    void buscarTarefasOrdenadasTeste() {
    }

    @Test
    void buscarTarefasPrioridadeTeste() {
    }

    @Test
    void buscarTarefasDataVencimentoTeste() {
    }

    @Test
    void marcarPrioridadeTeste() {
    }

    @Test
    void recuperarTarefaTeste() {
    }

    @Test
    void criarTarefTeste() {
    }

    @Test
    void atualizarTarefaTeste() {
    }

    @Test
    void removerTarefaTeste() {
    }
}