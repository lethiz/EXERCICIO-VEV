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
        // Arrange
        ReservaRepository repository = new ReservaRepository();

        // Act
        int totalReservas = repository.getTotalReservas();

        // Assert
        assertEquals(0, totalReservas);
    }

    @Test
    @DisplayName("2 - Teste de adição de reserva ao Repositório.")
    @Tag("TesteDeFuncionalidade")
    public void testCriarReservaAddReservaToRepository() {
        // Arrange
        ReservaRepository repository = new ReservaRepository();
        Reserva reserva = new Reserva("Alice", "83999999999", UUID.randomUUID(), 2, 200.0f);

        // Act
        String resultado = repository.criarReserva(reserva);

        // Assert
        assertEquals(1, repository.getTotalReservas());
        assertTrue(resultado.contains("Reserva feita com sucesso."));
    }

    @Test
    @DisplayName("3 - Teste de remoção de reserva do Repositório.")
    @Tag("TesteDeFuncionalidade")
    public void testRemoverReservaRemoveReservaFromRepository() {
        // Arrange
        ReservaRepository repository = new ReservaRepository();
        Reserva reserva = new Reserva("Alice", "83999999999", UUID.randomUUID(), 2, 200.0f);
        repository.criarReserva(reserva);

        // Act
        repository.removerReserva(reserva.getId(), reserva.getUsername());

        // Assert
        assertEquals(0, repository.getTotalReservas());
    }

    @Test
    @DisplayName("4 - Teste de busca de reserva por ID.")
    @Tag("TesteDeFuncionalidade")
    public void testGetReservaPorIdReturnsReserva() {
        // Arrange
        ReservaRepository repository = new ReservaRepository();
        Reserva reserva = new Reserva("Alice", "83999999999", UUID.randomUUID(), 2, 200.0f);
        repository.criarReserva(reserva);

        // Act
        Reserva reservaEncontrada = repository.getReservaPorId(reserva.getId());

        // Assert
        assertNotNull(reservaEncontrada);
        assertEquals(reserva.getId(), reservaEncontrada.getId());
    }

    @Test
    @DisplayName("5 - Teste de busca de reserva por ID inexistente.")
    @Tag("TesteDeFuncionalidade")
    public void testGetReservaPorIdReturnsNullForNonExistingId() {
        // Arrange
        ReservaRepository repository = new ReservaRepository();
        Reserva reserva = new Reserva("Alice", "83999999999", UUID.randomUUID(), 2, 200.0f);
        repository.criarReserva(reserva);

        // Act
        Reserva reservaEncontrada = repository.getReservaPorId(UUID.randomUUID());

        // Assert
        assertNull(reservaEncontrada);
    }
}
