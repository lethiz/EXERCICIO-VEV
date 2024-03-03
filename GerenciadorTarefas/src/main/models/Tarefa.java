package main.models;

import java.util.Objects;
import java.util.UUID;

import main.exceptions.Model.InvalidDataVencimentoException;
import main.exceptions.Model.InvalidDescricaoException;
import main.exceptions.Model.InvalidPrioridadeException;
import main.exceptions.Model.InvalidTituloException;
import main.util.TarefaPrioridade;

public class Tarefa {

    private final String id;
    private String titulo;
    private String descricao;
    private String dataVencimento;
    private TarefaPrioridade prioridade;

    public Tarefa(String titulo, String descricao, String dataVencimento, TarefaPrioridade prioridade) throws InvalidTituloException, InvalidDescricaoException, InvalidDataVencimentoException, InvalidPrioridadeException {
        this.id = UUID.randomUUID().toString();

        this.checkTitulo(titulo);
        this.checkDescricao(descricao);
        this.checkDataVencimento(dataVencimento);
        this.checkPrioridade(prioridade);

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
        this.checkTitulo(tituloNovo);
        this.titulo = tituloNovo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricaoNova) throws InvalidDescricaoException {
        this.checkDescricao(descricaoNova);
        this.descricao = descricaoNova;
    }

    public String getDataVencimento() {
        return this.dataVencimento;
    }

    public void setDataVencimento(String dataVencimentoNova) throws InvalidDataVencimentoException {
        this.checkDataVencimento(dataVencimentoNova);
        this.dataVencimento = dataVencimentoNova;
    }

    public TarefaPrioridade getPrioridade() {
        return this.prioridade;
    }

    public void setPrioridade(TarefaPrioridade prioridadeNova) throws InvalidPrioridadeException {
        this.checkPrioridade(prioridade);
        this.prioridade = prioridadeNova;
    }

    private void checkTitulo(String titulo) throws InvalidTituloException {
        if(titulo == null) throw new InvalidTituloException("Título inválido: não pode ser nulo.");
        if(titulo.isBlank()) throw new InvalidTituloException("Título inválido: não pode estar em branco.");
        if(titulo.isEmpty()) throw new InvalidTituloException("Título inválido: não pode ser vazio.");

    }

    private void checkDescricao(String descricao) throws InvalidDescricaoException {
        if(descricao == null) throw new InvalidDescricaoException("Descrição inválida: não pode ser nula.");
        if(descricao.isBlank()) throw new InvalidDescricaoException("Descrição inválida: não pode estar em branco.");
        if(descricao.isEmpty()) throw new InvalidDescricaoException("Descrição inválida: não pode ser vazia.");

    }

    private void checkDataVencimento(String dataVencimento) throws InvalidDataVencimentoException {
        if(dataVencimento == null) throw new InvalidDataVencimentoException("Data de Vencimento inválida: não pode ser nula.");
        if(dataVencimento.isBlank()) throw new InvalidDataVencimentoException("Data de Vencimento inválida: não pode estar em branco.");
        if(dataVencimento.isEmpty()) throw new InvalidDataVencimentoException("Data de Vencimento inválida: não pode ser vazia.");

    }

    private void checkPrioridade(TarefaPrioridade prioridade) throws InvalidPrioridadeException {
        if(prioridade == null) throw new InvalidPrioridadeException("Prioridade inválida: não pode ser nula.");

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
