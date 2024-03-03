package main.models;

import java.util.Objects;
import java.util.UUID;
import main.util.TarefaPrioridade;

public class Tarefa {

    private final String id = UUID.randomUUID().toString();
    private String titulo;
    private String descricao;
    private String dataVencimento;
    private TarefaPrioridade prioridade;

    public Tarefa(String titulo, String descricao, String dataVencimento, TarefaPrioridade prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.prioridade = prioridade;
    }

    public String getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String tituloNovo) {
        this.titulo = tituloNovo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricaoNova) {
        this.descricao = descricaoNova;
    }

    public String getDataVencimento() {
        return this.dataVencimento;
    }

    public void setDataVencimento(String dataVencimentoNova) {
        this.dataVencimento = dataVencimentoNova;
    }

    public TarefaPrioridade getPrioridade() {
        return this.prioridade;
    }

    public void setPrioridade(TarefaPrioridade prioridadeNova) {
        this.prioridade = prioridadeNova;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(id, tarefa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataVencimento='" + dataVencimento + '\'' +
                ", prioridade=" + prioridade +
                '}';
    }
}
