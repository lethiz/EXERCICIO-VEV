package main.util;

import main.models.Tarefa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class DataVencimentoComparator implements Comparator<Tarefa>{
    @Override
    public int compare(Tarefa tarefa1, Tarefa tarefa2) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date dataVencimento1 = new Date();
        Date dataVencimento2 = new Date();
        try {
            dataVencimento1 = dateFormat.parse(tarefa1.getDataVencimento());
            dataVencimento2 = dateFormat.parse(tarefa2.getDataVencimento());
        } catch (ParseException ignored) {}

        return dataVencimento1.compareTo(dataVencimento2); // Descending order
    }
}
