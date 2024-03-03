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
}
