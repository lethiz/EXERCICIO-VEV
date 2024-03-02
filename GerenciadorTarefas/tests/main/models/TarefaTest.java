package main.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TarefaTest {

    Tarefa tarefaTeste;

    @BeforeEach
    public void prepararTest(){
        this.tarefaTeste = new Tarefa("Título Testagen", "Descrição Testagem", "23/09/2024", "PRIORIDADE-ALTA");
    }

    @Test
    public void criarTarefa(){
        this.tarefaCriada =  new Tarefa("Título Criado", "Descrição Criação", "25/09/2024", "PRIORIDADE-BAIXA");
        assertEquals("Título Criado", tarefaCriada.getTitulo());
        assertEquals("Descrição Criação", tarefaCriada.getDescricao());
        assertEquals("25/09/2024", tarefaCriada.getDataVencimento());
        assertEquals("PRIORIDADE-BAIXA", tarefaCriada.getPrioridade());
    }
}