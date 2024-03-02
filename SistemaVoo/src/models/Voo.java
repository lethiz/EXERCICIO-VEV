package models;

import java.time.LocalDate;
import java.util.UUID;

public class Voo {

    private UUID ID;

    private String origem;
    private String destino;
    private int totalPassageiros;

    private LocalDate data;

    public Voo(String origem, String destino, int totalPassageiros, LocalDate data) {
        this.ID = UUID.randomUUID();
        this.origem = origem;
        this.destino = destino;
        this.totalPassageiros = totalPassageiros;
        this.data = data;
    }


    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getTotalPassageiros() {
        return totalPassageiros;
    }

    public void setTotalPassageiros(int totalPassageiros) {
        this.totalPassageiros = totalPassageiros;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void decrementarTotalPassageiros() {
        this.totalPassageiros--;
    }
}
