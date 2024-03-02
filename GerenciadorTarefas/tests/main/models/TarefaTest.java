package main.models;

import main.util.TarefaPrioridade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TarefaTest {

    Tarefa tarefaTeste;

    @BeforeEach
    public void prepararTest(){
        this.tarefaTeste = new Tarefa("Título Testagem", "Descrição Testagem", "23/09/2024", TarefaPrioridade.PRIORIDADE_ALTA);
    }

    @Test
    public void criarTarefa(){
        Tarefa tarefaCriada =  new Tarefa("Título Criado", "Descrição Criação", "25/09/2024", TarefaPrioridade.PRIORIDADE_BAIXA);
        assertEquals("Título Criado", tarefaCriada.getTitulo());
        assertEquals("Descrição Criação", tarefaCriada.getDescricao());
        assertEquals("25/09/2024", tarefaCriada.getDataVencimento());
        assertEquals(TarefaPrioridade.PRIORIDADE_BAIXA, tarefaCriada.getPrioridade());
    }

    @Test
    public void criarTarefa(){
        this.tarefaTeste.setTitulo("Título Atualizado");
        this.tarefaTeste.setDescricao("Descrição Atualizada");
        this.tarefaTeste.setDataVencimento("26/09/2024");
        this.tarefaTeste.setPrioridade(TarefaPrioridade.PRIORIDADE_MEDIA);
        assertEquals("Título Atualizado", tarefaTeste.getTitulo());
        assertEquals("Descrição Atualizado", tarefaTeste.getDescricao());
        assertEquals("26/09/2024", tarefaTeste.getDataVencimento());
        assertEquals(TarefaPrioridade.PRIORIDADE_MEDIA, tarefaTeste.getPrioridade());
    }
}
}