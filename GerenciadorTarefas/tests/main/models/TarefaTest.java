package main.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TarefaTest {

    Tarefa tarefaTeste;

    @BeforeEach
    public void prepararTest(){
        this.tarefaTeste = new Tarefa("Título Testagem", "Descrição Testagem", "23/09/2024", "PRIORIDADE_ALTA");
    }

    @Test
    public void criarTarefa(){
        this.tarefaCriada =  new Tarefa("Título Criado", "Descrição Criação", "25/09/2024", "PRIORIDADE_BAIXA");
        assertEquals("Título Criado", tarefaCriada.getTitulo());
        assertEquals("Descrição Criação", tarefaCriada.getDescricao());
        assertEquals("25/09/2024", tarefaCriada.getDataVencimento());
        assertEquals("PRIORIDADE-BAIXA", tarefaCriada.getPrioridade());
    }

    @Test
    public void criarTarefa(){
        this.tarefaTeste.setTitulo("Título Atualizado");
        this.tarefaTeste.setDescricao("Descrição Atualizada");
        this.tarefaTeste.setDataVencimento("26/09/2024");
        this.tarefaTeste.setPrioridade("PRIORIDADE_MÉDIA");
        assertEquals("Título Atualizado", tarefaTeste.getTitulo());
        assertEquals("Descrição Atualizado", tarefaTeste.getDescricao());
        assertEquals("26/09/2024", tarefaTeste.getDataVencimento());
        assertEquals("PRIORIDADE_MÉDIA", tarefaTeste.getPrioridade());
    }
}