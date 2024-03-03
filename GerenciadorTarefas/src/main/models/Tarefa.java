package main.models;

import java.util.Objects;
import java.util.UUID;

import main.exceptions.Model.InvalidDataVencimentoException;
import main.exceptions.Model.InvalidDescricaoException;
import main.exceptions.Model.InvalidPrioridadeException;
import main.exceptions.Model.InvalidTituloException;
import main.util.CheckInvalids;
import main.util.TarefaPrioridade;

public class Tarefa {

    private final String id;
    private String titulo;
    private String descricao;
    private String dataVencimento;
    private TarefaPrioridade prioridade;

    private final CheckInvalids checkInvalids = new CheckInvalids();

    public Tarefa(String titulo, String descricao, String dataVencimento, TarefaPrioridade prioridade) throws InvalidTituloException, InvalidDescricaoException, InvalidDataVencimentoException, InvalidPrioridadeException {
        this.id = UUID.randomUUID().toString();

        checkInvalids.checkTitulo(titulo);
        checkInvalids.checkDescricao(descricao);
        checkInvalids.checkDataVencimento(dataVencimento);
        checkInvalids.checkPrioridade(prioridade);

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

    public void setTitulo(String tituloNovo) throws InvalidTituloException {
        checkInvalids.checkTitulo(tituloNovo);
        this.titulo = tituloNovo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricaoNova) throws InvalidDescricaoException {
        checkInvalids.checkDescricao(descricaoNova);
        this.descricao = descricaoNova;
    }

    public String getDataVencimento() {
        return this.dataVencimento;
    }

    public void setDataVencimento(String dataVencimentoNova) throws InvalidDataVencimentoException {
        checkInvalids.checkDataVencimento(dataVencimentoNova);
        this.dataVencimento = dataVencimentoNova;
    }

    public TarefaPrioridade getPrioridade() {
        return this.prioridade;
    }

    public void setPrioridade(TarefaPrioridade prioridadeNova) throws InvalidPrioridadeException {
        checkInvalids.checkPrioridade(prioridade);
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
