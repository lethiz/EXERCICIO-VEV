package repositories.tests;

import models.Voo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import repositories.VooRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class VooRepositoryUnitTests {

    @Test
    @DisplayName("1 - Teste de inicialização do Repositório de Voos vazio.")
    @Tag("TesteDeConstrutor")
    public void testConstructorVoosListEmpty() {
        // Arrange
        VooRepository repository = new VooRepository();

        // Act
        int totalVoos = repository.getTotalVoosCadastrados();

        // Assert
        assertEquals(0, totalVoos);
    }

    @Test
    @DisplayName("2 - Teste de adição de voo ao Repositório.")
    @Tag("TesteDeFuncionalidade")
    public void testAdicionarVooAddVooToRepository() {
        // Arrange
        VooRepository repository = new VooRepository();
        Voo voo = new Voo("Origem", "Destino", 100, LocalDate.now().plusDays(1), 100.0f);

        // Act
        repository.adicionarVoo(voo);

        // Assert
        assertEquals(1, repository.getTotalVoosCadastrados());
    }

    @Test
    @DisplayName("3 - Teste de remoção de voo do Repositório.")
    @Tag("TesteDeFuncionalidade")
    public void testRemoverVooRemoveVooFromRepository() {
        // Arrange
        VooRepository repository = new VooRepository();
        Voo voo = new Voo("Origem", "Destino", 100, LocalDate.now().plusDays(1), 100.0f);
        repository.adicionarVoo(voo);

        // Act
        repository.removerVoo(voo);

        // Assert
        assertEquals(0, repository.getTotalVoosCadastrados());
    }

    @Test
    @DisplayName("4 - Teste de busca de voo por ID.")
    @Tag("TesteDeFuncionalidade")
    public void testGetVooPorIdReturnsVoo() {
        // Arrange
        VooRepository repository = new VooRepository();
        Voo voo = new Voo("Origem", "Destino", 100, LocalDate.now().plusDays(1), 100.0f);
        repository.adicionarVoo(voo);

        // Act
        Voo vooEncontrado = repository.getVooPorId(voo.getID());

        // Assert
        assertNotNull(vooEncontrado);
        assertEquals(voo.getID(), vooEncontrado.getID());
    }

    @Test
    @DisplayName("5 - Teste de busca de voo por ID inexistente.")
    @Tag("TesteDeFuncionalidade")
    public void testGetVooPorIdReturnsNullForNonExistingId() {
        // Arrange
        VooRepository repository = new VooRepository();
        Voo voo = new Voo("Origem", "Destino", 100, LocalDate.now().plusDays(1), 100.0f);
        repository.adicionarVoo(voo);

        // Act
        Voo vooEncontrado = repository.getVooPorId(UUID.randomUUID());

        // Assert
        assertNull(vooEncontrado);
    }

}
