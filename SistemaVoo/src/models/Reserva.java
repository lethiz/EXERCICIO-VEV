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

    public UUID getVooId() {
        return this.vooId;
    }

    public int getAmountPassengers() {
        return this.amountPassengers;
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
