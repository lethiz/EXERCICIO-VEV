package main.models;

import main.exceptions.Model.*;
import main.util.TarefaPrioridade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TarefaTest {

    private Tarefa tarefaTeste;

    @BeforeEach
    public void prepararTest() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDescricaoException, InvalidTituloException, InvalidDataVencimentoFormatException {
        this.tarefaTeste = new Tarefa("Título Testagem", "Descrição Testagem", "23/09/2024", TarefaPrioridade.PRIORIDADE_ALTA);
    }

    @Test
    public void criarTarefa() throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDescricaoException, InvalidTituloException, InvalidDataVencimentoFormatException {
        Tarefa tarefaCriada =  new Tarefa("Título Criado", "Descrição Criação", "25/09/2024", TarefaPrioridade.PRIORIDADE_BAIXA);
        assertEquals("Título Criado", tarefaCriada.getTitulo());
        assertEquals("Descrição Criação", tarefaCriada.getDescricao());
        assertEquals("25/09/2024", tarefaCriada.getDataVencimento());
        assertEquals(TarefaPrioridade.PRIORIDADE_BAIXA, tarefaCriada.getPrioridade());
    }

    @Test
    public void criarTarefaTituloInvalido(){
        assertThrows(InvalidTituloException.class, () -> {
            Tarefa tarefaCriada =  new Tarefa(null, "Descrição Criação", "25/09/2024", TarefaPrioridade.PRIORIDADE_BAIXA);
        });
        assertThrows(InvalidTituloException.class, () -> {
            Tarefa tarefaCriada =  new Tarefa("", "Descrição Criação", "25/09/2024", TarefaPrioridade.PRIORIDADE_BAIXA);
        });
        assertThrows(InvalidTituloException.class, () -> {
            Tarefa tarefaCriada =  new Tarefa( "   ", "Descrição Criação", "25/09/2024", TarefaPrioridade.PRIORIDADE_BAIXA);
        });
    }

    @Test
    public void criarTarefaDescricaoInvalida(){
        assertThrows(InvalidDescricaoException.class, () -> {
            Tarefa tarefaCriada =  new Tarefa("Título Criado", null, "25/09/2024", TarefaPrioridade.PRIORIDADE_BAIXA);
        });
        assertThrows(InvalidDescricaoException.class, () -> {
            Tarefa tarefaCriada =  new Tarefa("Título Criado", "", "25/09/2024", TarefaPrioridade.PRIORIDADE_BAIXA);
        });
        assertThrows(InvalidDescricaoException.class, () -> {
            Tarefa tarefaCriada =  new Tarefa( "Título Criado", "    ", "25/09/2024", TarefaPrioridade.PRIORIDADE_BAIXA);
        });
    }

    @Test
    public void criarTarefaDataVencimentoInvalida(){
        assertThrows(InvalidDataVencimentoException.class, () -> {
            Tarefa tarefaCriada =  new Tarefa("Título Criado", "Descrição Criação", null, TarefaPrioridade.PRIORIDADE_BAIXA);
        });
        assertThrows(InvalidDataVencimentoException.class, () -> {
            Tarefa tarefaCriada =  new Tarefa("Título Criado", "Descrição Criação", "", TarefaPrioridade.PRIORIDADE_BAIXA);
        });
        assertThrows(InvalidDataVencimentoException.class, () -> {
            Tarefa tarefaCriada =  new Tarefa( "Título Criado", "Descrição Criação", "     ", TarefaPrioridade.PRIORIDADE_BAIXA);
        });
    }

    @Test
    public void criarTarefaPrioridadeInvalida(){
        assertThrows(InvalidPrioridadeException.class, () -> {
            Tarefa tarefaCriada =  new Tarefa("Título Criado", "Descrição Criação", "25/09/2024", null);
        });

    }

    @Test
    public void atualizarTarefa() throws InvalidTituloException, InvalidDescricaoException, InvalidDataVencimentoException, InvalidPrioridadeException, InvalidDataVencimentoFormatException {
        this.tarefaTeste.setTitulo("Título Atualizado");
        this.tarefaTeste.setDescricao("Descrição Atualizada");
        this.tarefaTeste.setDataVencimento("26/09/2024");
        this.tarefaTeste.setPrioridade(TarefaPrioridade.PRIORIDADE_MEDIA);
        assertEquals("Título Atualizado", tarefaTeste.getTitulo());
        assertEquals("Descrição Atualizada", tarefaTeste.getDescricao());
        assertEquals("26/09/2024", tarefaTeste.getDataVencimento());
        assertEquals(TarefaPrioridade.PRIORIDADE_MEDIA, tarefaTeste.getPrioridade());
    }

}