package repositories.tests;

import models.Reserva;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import repositories.ReservaRepository;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaRepositoryUnitTests {

    @Test
    @DisplayName("1 - Teste de inicialização do Repositório de Reservas vazio.")
    @Tag("TesteDeConstrutor")
    public void testConstructorReservasListEmpty() {
        ReservaRepository repository = new ReservaRepository();

        int totalReservas = repository.getTotalReservas();

        assertEquals(0, totalReservas);
    }

    @Test
    @DisplayName("2 - Teste de adição de reserva ao Repositório.")
    @Tag("TesteDeFuncionalidade")
    public void testCriarReservaAddReservaToRepository() {
        ReservaRepository repository = new ReservaRepository();
        Reserva reserva = new Reserva("Alice", "83999999999", UUID.randomUUID(), 2, 200.0f);

        String resultado = repository.criarReserva(reserva);

        assertEquals(1, repository.getTotalReservas());
        assertTrue(resultado.contains("Reserva feita com sucesso."));
    }

    @Test
    @DisplayName("3 - Teste de remoção de reserva do Repositório.")
    @Tag("TesteDeFuncionalidade")
    public void testRemoverReservaRemoveReservaFromRepository() {
        ReservaRepository repository = new ReservaRepository();
        Reserva reserva = new Reserva("Alice", "83999999999", UUID.randomUUID(), 2, 200.0f);
        repository.criarReserva(reserva);

        repository.removerReserva(reserva.getId(), reserva.getUsername());

        assertEquals(0, repository.getTotalReservas());
    }

    @Test
    @DisplayName("4 - Teste de busca de reserva por ID.")
    @Tag("TesteDeFuncionalidade")
    public void testGetReservaPorIdReturnsReserva() {
        ReservaRepository repository = new ReservaRepository();
        Reserva reserva = new Reserva("Alice", "83999999999", UUID.randomUUID(), 2, 200.0f);
        repository.criarReserva(reserva);

        Reserva reservaEncontrada = repository.getReservaPorId(reserva.getId());

        assertNotNull(reservaEncontrada);
        assertEquals(reserva.getId(), reservaEncontrada.getId());
    }

    @Test
    @DisplayName("5 - Teste de busca de reserva por ID inexistente.")
    @Tag("TesteDeFuncionalidade")
    public void testGetReservaPorIdReturnsNullForNonExistingId() {

        ReservaRepository repository = new ReservaRepository();
        Reserva reserva = new Reserva("Alice", "83999999999", UUID.randomUUID(), 2, 200.0f);
        repository.criarReserva(reserva);

        Reserva reservaEncontrada = repository.getReservaPorId(UUID.randomUUID());

        assertNull(reservaEncontrada);
    }
}
