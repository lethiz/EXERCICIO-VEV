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
        return this.reservas.size();
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


}
