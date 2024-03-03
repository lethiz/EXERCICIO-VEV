package repositories;

import models.Reserva;
import models.Voo;

import java.util.ArrayList;

public class ReservaRepository {

    private ArrayList<Reserva> reservas;

    private VooRepository vooRepository;

    public ReservaRepository() {
        this.reservas = new ArrayList<Reserva>();
        this.vooRepository = new VooRepository();
    }

    public int getTotalReservas() {
        return 0;
    }


}
