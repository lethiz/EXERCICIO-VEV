package models;

import java.util.UUID;

public class Reserva {

    private String username;

    private String phoneNumber;

    private UUID vooId;

    private int amountPassengers;

    private float valorTotal;

    public Reserva(String username, String phoneNumber, UUID vooId, int amountPassengers, float valorTotal) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.vooId = vooId;
        this.amountPassengers = amountPassengers;
        this.valorTotal = valorTotal;
    }
}
