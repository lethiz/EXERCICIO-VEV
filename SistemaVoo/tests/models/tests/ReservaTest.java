package models.tests;

import models.Reserva;
import models.Voo;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
public class ReservaTest {


    @Test
    public void checkCreateReserva() {
        Reserva reserva = new Reserva();
        assertNotNull(reserva);
    }
}
