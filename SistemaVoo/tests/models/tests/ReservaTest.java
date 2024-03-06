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

    @Test
    public void testGetIdNotNull() {
        Reserva reserva = new Reserva("Glameow", "8398329487", UUID.randomUUID(), 1, 100.0f);

        assertNotNull(reserva.getId());
    }

    @Test
    public void testToString() {
        UUID vooId = UUID.randomUUID();
        Reserva reserva = new Reserva("Tsareena", "98293829372", vooId, 2, 2000.0f);

        String expected = "ID Reserva: " + reserva.getId() +
                "\nNome de usuário: '" + "Tsareena" + '\'' +
                "\nNúmero de telefone: '" + "98293829372" + '\'' +
                "\nID do Voo: " + vooId +
                "\nTotal de passagens: " + 2 +
                "\nValor Total R$" + 2000.f;

        assertEquals(expected, reserva.toString());
    }

    @Test
    public void testToStringNomeVazioTelefoneVazio() {
        UUID vooId = UUID.randomUUID();
        Reserva reserva = new Reserva("", "", vooId, 2, 100.0f);

        String expected = "ID Reserva: " + reserva.getId() +
                "\nNome de usuário: ''" +
                "\nNúmero de telefone: ''" +
                "\nID do Voo: " + vooId +
                "\nTotal de passagens: " + 2 +
                "\nValor Total R$" + 100.0f;

        assertEquals(expected, reserva.toString());
    }

    @Test
    public void testGetUsername() {
        String username = "Macaco Louco";
        Reserva reserva = new Reserva("Macaco Louco", "34523463623", UUID.randomUUID(), 2, 100.0f);
        assertEquals(username, reserva.getUsername());
    }

    @Test
    public void testGetVooId() {
        UUID vooId = UUID.randomUUID();
        Reserva reserva = new Reserva("Tsareena", "3245437432", vooId, 2, 100.0f);
        assertEquals(vooId, reserva.getVooId());
    }

    @Test
    public void testGetAmountPassengers() {
        int amountPassengers = 2;
        Reserva reserva = new Reserva("Evelynn", "23452346254", UUID.randomUUID(), amountPassengers, 100.0f);
        assertEquals(amountPassengers, reserva.getAmountPassengers());
    }

}
