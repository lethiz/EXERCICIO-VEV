package models;

import java.time.LocalDate;
import java.util.UUID;

public class Voo {

    private final UUID ID;
    private String origem;
    private String destino;
    private int totalPassageiros;

    private LocalDate data;

    private float preco;

    public Voo(String origem, String destino, int totalPassageiros, LocalDate data, float preco) {

        if (origem == null) {
            throw new NullPointerException("Origem nula!");
        } else if (origem.trim().isEmpty() || origem.trim().length() < 2) {
            throw new IllegalArgumentException("Origem inválida!");
        }

        if (destino == null || destino.trim().isEmpty() || destino.trim().length() < 2) {
            throw new IllegalArgumentException("Destino inválido!");
        }

        if (totalPassageiros <= 0) {
            throw new IllegalArgumentException("Total de passageiros inválido!");
        }

        LocalDate today = LocalDate.now();
        if (data == null) {
            throw new NullPointerException("Data nula!");
        } else if (data.isBefore(today)) {
            throw new IllegalArgumentException("Data no passado!");
        }

        if (preco <= 0) {
            throw new IllegalArgumentException("Preço inválido!");
        }

        this.preco = preco;
        this.ID = UUID.randomUUID();
        this.origem = origem;
        this.destino = destino;
        this.totalPassageiros = totalPassageiros;
        this.data = data;
    }

    public UUID getID() {
        return ID;
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

    public float getPreco() {
        return preco;
    }

    public void decrementarTotalPassageiros(int valor) {
        this.totalPassageiros-=valor;
    }

    public String toString() {
        return "ID=" + ID +
                ",\nOrigem: '" + origem + '\'' +
                ",\nDestino: '" + destino + '\'' +
                ",\nTotal de passageiros: " + totalPassageiros +
                ",\nData: " + data +
                ",\nValor da passagem: " + preco +
                '}';
    }

}
