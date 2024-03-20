package models;

import java.util.UUID;

public class Reserva {

    private final UUID reservaID;
    private String username;

    private String phoneNumber;

    private UUID vooId;

    private int amountPassengers;

    private float valorTotal;

    public Reserva(String username, String phoneNumber, UUID vooId, int amountPassengers, float valorTotal) {
        this.reservaID = UUID.randomUUID();

        if (username == null) {
            throw new NullPointerException("Nome de usuário nulo!");
        } else if (username.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome de usuário inválido!");
        }

        if (phoneNumber == null) {
            throw new NullPointerException("Número de telefone nulo!");
        } else if (phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Número de telefone inválido!");
        } else if (!phoneNumber.matches("^\\d{11}$")) {
            throw new IllegalArgumentException("Número de telefone não corresponde ao padrão de 11 dígitos.");
        }

        if (vooId == null) {
            throw new NullPointerException("VooId nulo!");
        }
        this.vooId = vooId;

        if (amountPassengers <= 0) {
            throw new IllegalArgumentException("AmountPassengers inválido!");
        }
        this.amountPassengers = amountPassengers;

        if (valorTotal <= 0) {
            throw new IllegalArgumentException("ValorTotal inválido!");
        }
        this.valorTotal = valorTotal;

        this.username = username;
        this.phoneNumber = phoneNumber;
        this.vooId = vooId;
        this.amountPassengers = amountPassengers;
        this.valorTotal = valorTotal;
    }

    public UUID getId() {
        return this.reservaID;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public UUID getVooId() {
        return this.vooId;
    }

    public int getAmountPassengers() {
        return this.amountPassengers;
    }

    public float getValorTotal() {
        return this.valorTotal;
    }

    @Override
    public String toString() {
        return "ID Reserva: " + reservaID +
                "\nNome de usuário: '" + username + '\'' +
                "\nNúmero de telefone: '" + phoneNumber + '\'' +
                "\nID do Voo: " + vooId +
                "\nTotal de passagens: " + amountPassengers +
                "\nValor Total R$" + valorTotal;
    }
}
