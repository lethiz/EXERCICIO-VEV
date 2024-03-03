package models.tests;

import models.Reserva;
import models.Voo;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
public class ReservaTest {


    private Voo voo = new Voo("Brasil", "EUA", 100, LocalDate.now(), 2302);
    private UUID vooId = voo.getID();
    private Reserva reservaUm;

    @Before
    public void setupReserva() {
        reservaUm = new Reserva("Kingambit", "83999991234", vooId, 3, 2302 * 3);
    }

    @Test
    public void checkCreateReserva() {
        Reserva reserva = new Reserva("Clay", "83999991334", vooId, 3, 2302 * 3);
        assertNotNull(reserva);
    }


}
