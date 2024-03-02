package main.models;

import main.util.TarefaPrioridade;

public class Tarefa {

    private String titulo;
    private String descricao;
    private String dataVencimento;
    private TarefaPrioridade prioridade;


    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataVencimento() {
        return this.dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public TarefaPrioridade getPrioridade() {
        return this.prioridade;
    }

    public void setPrioridade(TarefaPrioridade prioridade) {
        this.prioridade = prioridade;
    }
}
