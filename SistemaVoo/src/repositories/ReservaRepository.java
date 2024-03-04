package repositories;

import models.Reserva;
import models.Voo;

import java.util.ArrayList;
import java.util.UUID;

public class ReservaRepository {

    private ArrayList<Reserva> reservas;

    private VooRepository vooRepository;

    public ReservaRepository() {
        this.reservas = new ArrayList<Reserva>();
        this.vooRepository = new VooRepository();
    }

    public int getTotalReservas() {
        return this.reservas.size();
    }

    public Reserva getReservaPorId(UUID reservaId) {
        for (Reserva reserva : reservas) {
            if (reserva.getId().equals(reservaId)) {
                return reserva;
            }
        }
        return null;
    }

    public String criarReserva(Reserva reserva) {

        try {
            this.reservas.add(reserva);

            String reservaSucesso = "Reserva feita com sucesso." + "\nDados da reserva:\n";

            return reservaSucesso;

        } catch (Exception e){
            return e.toString();
        }
    }



    public void removerReserva(UUID reservaId) {
        this.reservas.removeIf(reserva -> reserva.getId().equals(reservaId));
    }


}
