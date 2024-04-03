package repositories.tests;

import models.Voo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import repositories.VooRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class VooRepositoryUnitTests {

    private VooRepository repository;
    private List<Voo> voos;

    @BeforeEach
    public void setUp() {
        voos = new ArrayList<>();
        voos.add(new Voo("Havaí", "Brasil", 100, LocalDate.now(), 100.0f));
        voos.add(new Voo("Alola", "Galar", 200, LocalDate.now().plusDays(1), 200.0f));
        voos.add(new Voo("Paldea", "Hoenn", 300, LocalDate.now().plusDays(2), 300.0f));
        repository = new VooRepository(new ArrayList<>(voos));
    }

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
        VooRepository repository = new VooRepository();
        Voo voo = new Voo("Origem", "Destino", 100, LocalDate.now().plusDays(1), 100.0f);

        repository.adicionarVoo(voo);

        assertEquals(1, repository.getTotalVoosCadastrados());
    }

    @Test
    @DisplayName("3 - Teste de remoção de voo do Repositório.")
    @Tag("TesteDeFuncionalidade")
    public void testRemoverVooRemoveVooFromRepository() {
        VooRepository repository = new VooRepository();
        Voo voo = new Voo("Origem", "Destino", 100, LocalDate.now().plusDays(1), 100.0f);
        repository.adicionarVoo(voo);

        repository.removerVoo(voo);

        assertEquals(0, repository.getTotalVoosCadastrados());
    }

    @Test
    @DisplayName("4 - Teste de busca de voo por ID.")
    @Tag("TesteDeFuncionalidade")
    public void testGetVooPorIdReturnsVoo() {
        VooRepository repository = new VooRepository();
        Voo voo = new Voo("Origem", "Destino", 100, LocalDate.now().plusDays(1), 100.0f);
        repository.adicionarVoo(voo);

        Voo vooEncontrado = repository.getVooPorId(voo.getID());

        assertNotNull(vooEncontrado);
        assertEquals(voo.getID(), vooEncontrado.getID());
    }

    @Test
    @DisplayName("5 - Teste de busca de voo por ID inexistente.")
    @Tag("TesteDeFuncionalidade")
    public void testGetVooPorIdReturnsNullForNonExistingId() {
        VooRepository repository = new VooRepository();
        Voo voo = new Voo("Origem", "Destino", 100, LocalDate.now().plusDays(1), 100.0f);
        repository.adicionarVoo(voo);

        Voo vooEncontrado = repository.getVooPorId(UUID.randomUUID());

        assertNull(vooEncontrado);
    }



    @Test
    @DisplayName("Teste do método getTotalVoosCadastrados")
    @Tag("TesteDeMetodo")
    public void testGetTotalVoosCadastrados() {
        assertEquals(3, repository.getTotalVoosCadastrados());
    }

    @Test
    @DisplayName("Teste do método adicionarVoo")
    @Tag("TesteDeMetodo")
    public void testAdicionarVoo() {
        repository.adicionarVoo(new Voo("Origem4", "Destino4", 400, LocalDate.now().plusDays(3), 400.0f));
        assertEquals(4, repository.getTotalVoosCadastrados());
    }

    @Test
    @DisplayName("Teste do método removerVoo")
    @Tag("TesteDeMetodo")
    public void testRemoverVoo() {
        repository.removerVoo(voos.get(0));
        assertEquals(2, repository.getTotalVoosCadastrados());
    }

    @Test
    @DisplayName("Teste do método getVooPorId")
    @Tag("TesteDeMetodo")
    public void testGetVooPorId() {
        UUID vooId = voos.get(0).getID();
        Voo voo = repository.getVooPorId(vooId);
        assertNotNull(voo);
        assertEquals(vooId, voo.getID());
    }

    @Test
    @DisplayName("Teste do método removerVooPorId")
    @Tag("TesteDeMetodo")
    public void testRemoverVooPorId() {
        UUID vooId = voos.get(0).getID();
        repository.removerVooPorId(vooId);
        assertNull(repository.getVooPorId(vooId));
    }

    @Test
    @DisplayName("Teste do método getVoosPorFiltros")
    @Tag("TesteDeMetodo")
    public void testGetVoosPorFiltros() {
        assertEquals(1, repository.getVoosPorFiltros("Havaí", "Brasil", LocalDate.now(), 100.0f, 100).size());
        assertEquals(0, repository.getVoosPorFiltros("Origem1", "Destino1", LocalDate.now(), 90.0f, 100).size());
    }

    @Test
    @DisplayName("Teste do método getVoosPorData")
    @Tag("TesteDeMetodo")
    public void testGetVoosPorData() {
        assertEquals(1, repository.getVoosPorData(LocalDate.now()).size());
        assertEquals(0, repository.getVoosPorData(LocalDate.now().plusDays(3)).size());
    }

    @Test
    @DisplayName("Teste do método getVoosPorNumPassageiros")
    @Tag("TesteDeMetodo")
    public void testGetVoosPorNumPassageiros() {
        assertEquals(1, repository.getVoosPorNumPassageiros(100).size());
        assertEquals(0, repository.getVoosPorNumPassageiros(500).size());
    }

    @Test
    @DisplayName("Teste do método getVoosPorDestino")
    @Tag("TesteDeMetodo")
    public void testGetVoosPorDestino() {
        assertEquals(1, repository.getVoosPorDestino("Brasil").size());
        assertEquals(0, repository.getVoosPorDestino("Belém do Pará").size());
    }

    @Test
    @DisplayName("Teste do método getVoosPorOrigem")
    @Tag("TesteDeMetodo")
    public void testGetVoosPorOrigem() {
        assertEquals(1, repository.getVoosPorOrigem("Alola").size());
        assertEquals(0, repository.getVoosPorOrigem("Coréia do Sul").size());
    }

}
