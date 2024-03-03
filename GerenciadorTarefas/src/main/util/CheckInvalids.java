package main.util;

import main.exceptions.InvalidIDException;
import main.exceptions.Model.InvalidDataVencimentoException;
import main.exceptions.Model.InvalidDescricaoException;
import main.exceptions.Model.InvalidPrioridadeException;
import main.exceptions.Model.InvalidTituloException;
import main.exceptions.Repository.InvalidTarefaException;
import main.models.Tarefa;

public class CheckInvalids {

    public void checkId(String id) throws InvalidIDException {
        if(id == null) throw new InvalidIDException("ID inválido: não pode ser nulo.");
        if(id.isBlank()) throw new InvalidIDException("ID inválido: não pode estar em branco.");
        if(id.isEmpty()) throw new InvalidIDException("ID inválido: não pode ser vazio.");

    }

    public void checkTitulo(String titulo) throws InvalidTituloException {
        if(titulo == null) throw new InvalidTituloException("Título inválido: não pode ser nulo.");
        if(titulo.isBlank()) throw new InvalidTituloException("Título inválido: não pode estar em branco.");
        if(titulo.isEmpty()) throw new InvalidTituloException("Título inválido: não pode ser vazio.");

    }

    public void checkDescricao(String descricao) throws InvalidDescricaoException {
        if(descricao == null) throw new InvalidDescricaoException("Descrição inválida: não pode ser nula.");
        if(descricao.isBlank()) throw new InvalidDescricaoException("Descrição inválida: não pode estar em branco.");
        if(descricao.isEmpty()) throw new InvalidDescricaoException("Descrição inválida: não pode ser vazia.");

    }

    public void checkDataVencimento(String dataVencimento) throws InvalidDataVencimentoException {
        if(dataVencimento == null) throw new InvalidDataVencimentoException("Data de Vencimento inválida: não pode ser nula.");
        if(dataVencimento.isBlank()) throw new InvalidDataVencimentoException("Data de Vencimento inválida: não pode estar em branco.");
        if(dataVencimento.isEmpty()) throw new InvalidDataVencimentoException("Data de Vencimento inválida: não pode ser vazia.");

    }

    public void checkPrioridade(TarefaPrioridade prioridade) throws InvalidPrioridadeException {
        if(prioridade == null) throw new InvalidPrioridadeException("Prioridade inválida: não pode ser nula.");

    }

    public void checkTarefa(Tarefa tarefa, String metodo) throws InvalidTarefaException {
        if(tarefa == null) throw new InvalidTarefaException("É inválido tentar " + metodo + " uma tarefa nula.");
    }
}
