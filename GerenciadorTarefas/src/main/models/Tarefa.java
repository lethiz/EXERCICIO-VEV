package main.models;

import main.util.TarefaPrioridade;

public class Tarefa {

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
}
