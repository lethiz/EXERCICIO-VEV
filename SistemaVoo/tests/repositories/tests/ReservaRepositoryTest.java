package repositories.tests;

import models.Reserva;
import models.Voo;
import org.junit.Test;
import repositories.ReservaRepository;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ReservaRepositoryTest {

    private Voo voo = new Voo("Brasil", "EUA", 100, LocalDate.now(), 2302);
    private UUID vooId = voo.getID();
    public ReservaRepository reservaRepository = new ReservaRepository();

    @Test
    public void ReservaRepositoryTest() {
        ReservaRepository reservaRepositoryConstructor = new ReservaRepository();
        assertNotNull(reservaRepositoryConstructor);
    }

    @Test
    public void checkReservaRepositorySize() {
        ReservaRepository novoReservaRepository = new ReservaRepository();
        assertEquals(0, novoReservaRepository.getTotalReservas());
    }

    @Test
    public void checkCriarReserva() {
        Reserva reserva = new Reserva("Clay", "83999991334", vooId, 3, 2302 * 3);
        reservaRepository.criarReserva(reserva);
    }
}
