package repositories.tests;

import models.Reserva;
import models.Voo;
import org.junit.Before;
import org.junit.Test;
import repositories.ReservaRepository;
import repositories.VooRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.UUID;

public class ReservaRepositoryFunctionalTest {

    private ReservaRepository reservaRepository;
    private VooRepository vooRepository;

    private UUID vooId;
    @Before
    public void setUp() {
        reservaRepository = new ReservaRepository();
        vooRepository = new VooRepository();

        Voo vooValido = new Voo("Brasil", "Estados Unidos", 250, LocalDate.now(), 100.0f);
        vooId = vooValido.getID();
        vooRepository.adicionarVoo(vooValido);
    }

    @Test
    public void testCriarReservaValida() {
        Reserva reserva = new Reserva("Fulano de tal", "83993939939", vooId, 2, 200);
        reservaRepository.criarReserva(reserva);

        assertEquals("Fulano de tal", reserva.getUsername());
        assertEquals("83993939939", reserva.getPhoneNumber());
        assertEquals(vooId, reserva.getVooId());
        assertEquals(2, reserva.getAmountPassengers());
        assertEquals(200, reserva.getValorTotal(), 0.001);

    }

    @Test
    public void testCriarReservaSemNome() {
        Reserva reserva = new Reserva("", "83993939939", vooId, 2, 200);
        reservaRepository.criarReserva(reserva);

        assertEquals("Fulano de tal", reserva.getUsername());
        assertEquals("83993939939", reserva.getPhoneNumber());
        assertEquals(vooId, reserva.getVooId());
        assertEquals(2, reserva.getAmountPassengers());
        assertEquals(200, reserva.getValorTotal(), 0.001);

    }

    @Test
    public void testCriarReservaSemNumeroDeTelefoneValido() {
        Reserva reserva = new Reserva("Fulano de tal", "abcdefghijk", vooId, 2, 200);
        reservaRepository.criarReserva(reserva);

        assertEquals("Fulano de tal", reserva.getUsername());
        assertEquals("83993939939", reserva.getPhoneNumber());
        assertEquals(vooId, reserva.getVooId());
        assertEquals(2, reserva.getAmountPassengers());
        assertEquals(200, reserva.getValorTotal(), 0.001);

    }

    @Test
    public void testCriarReservaSemIdDoVoo() {
        Reserva reserva = new Reserva("Fulano de tal", "83993939939", null, 2, 200);
        reservaRepository.criarReserva(reserva);

        assertEquals("Fulano de tal", reserva.getUsername());
        assertEquals("83993939939", reserva.getPhoneNumber());
        assertEquals(vooId, reserva.getVooId());
        assertEquals(2, reserva.getAmountPassengers());
        assertEquals(200, reserva.getValorTotal(), 0.001);

    }

    @Test
    public void testCriarReservaQtdPassageirosInv() {
        Reserva reserva = new Reserva("Fulano de tal", "83993939939", vooId, -200, 200);
        reservaRepository.criarReserva(reserva);

        assertEquals("Fulano de tal", reserva.getUsername());
        assertEquals("83993939939", reserva.getPhoneNumber());
        assertEquals(vooId, reserva.getVooId());
        assertEquals(2, reserva.getAmountPassengers());
        assertEquals(200, reserva.getValorTotal(), 0.001);

    }

    @Test
    public void testCancelarReservaCredencialValida() {
        Reserva reserva = new Reserva("Fulano de tal", "83993939939", vooId, 2, 200);
        UUID reservaId = reserva.getId();
        reservaRepository.criarReserva(reserva);

        reservaRepository.removerReserva(reservaId, "Fulano de tal");
        assertEquals(0, reservaRepository.getTotalReservas());
    }
    @Test
    public void testCancelarReservaCredencialInvalida() {
        Reserva reserva = new Reserva("Fulano de tal", "83993939939", vooId, 2, 200);
        UUID reservaId = reserva.getId();
        reservaRepository.criarReserva(reserva);

        reservaRepository.removerReserva(reservaId, "Pongos");
        assertEquals(1, reservaRepository.getTotalReservas());
    }

    @Test
    public void testCancelarReservaCredencialNula() {
        Reserva reserva = new Reserva("Fulano de tal", "83993939939", vooId, 2, 200);
        UUID reservaId = reserva.getId();
        reservaRepository.criarReserva(reserva);

        reservaRepository.removerReserva(reservaId, null);
        assertEquals(1, reservaRepository.getTotalReservas());
    }


}
