package main.util;

import main.exceptions.InvalidIDException;
import main.exceptions.Model.*;
import main.exceptions.Service.InvalidTarefaException;
import main.models.Tarefa;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    public void checkDataVencimento(String dataVencimento) throws InvalidDataVencimentoException, InvalidDataVencimentoFormatException {
        if(dataVencimento == null) throw new InvalidDataVencimentoException("Data de Vencimento inválida: não pode ser nula.");
        if(dataVencimento.isBlank()) throw new InvalidDataVencimentoException("Data de Vencimento inválida: não pode estar em branco.");
        if(dataVencimento.isEmpty()) throw new InvalidDataVencimentoException("Data de Vencimento inválida: não pode ser vazia.");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dateFormat.parse(dataVencimento);
        } catch (ParseException e) {
            throw new InvalidDataVencimentoFormatException("O formato de data de vencimento deve ser dd/mm/yyyy");
        }
    }

    public void checkPrioridade(TarefaPrioridade prioridade) throws InvalidPrioridadeException {
        if(prioridade == null) throw new InvalidPrioridadeException("Prioridade inválida: não pode ser nula.");

    }

    public void checkTarefa(Tarefa tarefa, String metodo) throws InvalidTarefaException {
        if(tarefa == null) throw new InvalidTarefaException("É inválido tentar " + metodo + " uma tarefa nula.");
    }
}
