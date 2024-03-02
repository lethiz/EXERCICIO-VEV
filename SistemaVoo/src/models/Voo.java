package models;

import java.util.Date;

public class Voo {

    private String origem;
    private String destino;
    private int totalPassageiros;

    private Date data;

    public Voo(String origem, String destino, int totalPassageiros, Date data) {
        this.origem = origem;
        this.destino = destino;
        this.totalPassageiros = totalPassageiros;
        this.data = data;
    }


}
