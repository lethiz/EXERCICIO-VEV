package repositories.tests;

import models.Voo;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import repositories.VooRepository;

import java.time.LocalDate;
import java.util.UUID;

public class VooRepositoryFunctionalTest {

    private VooRepository vooRepository;

    @Before
    public void setUp() {
        vooRepository = new VooRepository();
    }

    @Test
    public void testAdicionarVooAoRepository() {
        VooRepository vooRepository = new VooRepository();

        // Criar um objeto Voo válido
        Voo vooValido = new Voo("Brasil", "Estados Unidos", 250, LocalDate.now(), 100.0f);

        // Teste de criação de um voo válido
        vooRepository.adicionarVoo(vooValido);
        assertEquals("Brasil", vooValido.getOrigem());
        assertEquals("Estados Unidos", vooValido.getDestino());
        assertEquals(250, vooValido.getTotalPassageiros());
        assertEquals(LocalDate.now(), vooValido.getData());
        assertEquals(100.0f, vooValido.getPreco(), 0.001);

    }

    @Test
    public void testAdicionarVooSemOrigemValidaAoRepository() {
        VooRepository vooRepository = new VooRepository();

        // Criar um objeto Voo sem origem válida
        Voo vooValido = new Voo("", "Estados Unidos", 250, LocalDate.now(), 100.0f);

        // Teste de criação de um voo válido
        vooRepository.adicionarVoo(vooValido);
        assertEquals("Brasil", vooValido.getOrigem());
        assertEquals("Estados Unidos", vooValido.getDestino());
        assertEquals(250, vooValido.getTotalPassageiros());
        assertEquals(LocalDate.now(), vooValido.getData());
        assertEquals(100.0f, vooValido.getPreco(), 0.001);

    }

    @Test
    public void testAdicionarVooSemDestinoAoRepository() {
        VooRepository vooRepository = new VooRepository();

        // Criar um objeto Voo sem um destino válido
        Voo vooValido = new Voo("Brasil", "", 250, LocalDate.now(), 100.0f);

        // Teste de criação de um voo válido
        vooRepository.adicionarVoo(vooValido);
        assertEquals("Brasil", vooValido.getOrigem());
        assertEquals("Estados Unidos", vooValido.getDestino());
        assertEquals(250, vooValido.getTotalPassageiros());
        assertEquals(LocalDate.now(), vooValido.getData());
        assertEquals(100.0f, vooValido.getPreco(), 0.001);

    }

    @Test
    public void testAdicionarVooTotalPassagInvalidoAoRepository() {
        VooRepository vooRepository = new VooRepository();

        // Criar um objeto Voo com total de passageiros negativo
        Voo vooValido = new Voo("Brasil", "Estados Unidos", -2938, LocalDate.now(), 100.0f);

        // Teste de criação de um voo válido
        vooRepository.adicionarVoo(vooValido);
        assertEquals("Brasil", vooValido.getOrigem());
        assertEquals("Estados Unidos", vooValido.getDestino());
        assertEquals(250, vooValido.getTotalPassageiros());
        assertEquals(LocalDate.now(), vooValido.getData());
        assertEquals(100.0f, vooValido.getPreco(), 0.001);

    }

    @Test
    public void testAdicionarVooSemDataAoRepository() {
        VooRepository vooRepository = new VooRepository();

        // Criar um objeto Voo válido
        Voo vooValido = new Voo("Brasil", "Estados Unidos", 2938, null, 100.0f);

        // Teste de criação de um voo válido
        vooRepository.adicionarVoo(vooValido);
        assertEquals("Brasil", vooValido.getOrigem());
        assertEquals("Estados Unidos", vooValido.getDestino());
        assertEquals(250, vooValido.getTotalPassageiros());
        assertEquals(LocalDate.now(), vooValido.getData());
        assertEquals(100.0f, vooValido.getPreco(), 0.001);

    }

    @Test
    public void testAdicionarVooPrecoInvalidoAoRepository() {
        VooRepository vooRepository = new VooRepository();

        // Criar um objeto Voo com preço inválido
        Voo vooValido = new Voo("Brasil", "Estados Unidos", 2938, LocalDate.now(), -100.0f);

        // Teste de criação de um voo válido
        vooRepository.adicionarVoo(vooValido);
        assertEquals("Brasil", vooValido.getOrigem());
        assertEquals("Estados Unidos", vooValido.getDestino());
        assertEquals(250, vooValido.getTotalPassageiros());
        assertEquals(LocalDate.now(), vooValido.getData());
        assertEquals(100.0f, vooValido.getPreco(), 0.001);

    }

}
