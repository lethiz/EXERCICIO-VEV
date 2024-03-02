package repositories.tests;

import models.Voo;
import org.junit.Before;
import org.junit.Test;
import repositories.VooRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VooRepositoryTest {

    private static VooRepository vooRepository;

    @Before
    public void setupVooRepository() {
        ArrayList<Voo> voos = new ArrayList<Voo>();
        vooRepository = new VooRepository(voos);
    }

    @Test
    public void checkRepositorioCriado() {
        assertNotNull(vooRepository);
    }

    @Test
    public void checkTotalVoosCadastrados() {
        assertEquals(vooRepository.getTotalVoosCadastrados(), 0);
    }

    @Test
    public void checkAdicionarVoo() {
        Voo novoVoo = new Voo("Estados Unidos", "Brasil", 100, LocalDate.now());
        vooRepository.adicionarVoo(novoVoo);
        assertEquals(vooRepository.getTotalVoosCadastrados(), 1);

    }

    @Test
    public void checkRemoverVoo() {
        Voo novoVoo = new Voo("Estados Unidos", "Brasil", 100, LocalDate.now());
        vooRepository.adicionarVoo(novoVoo);
        vooRepository.removerVoo(novoVoo);
        assertEquals(vooRepository.getTotalVoosCadastrados(), 0);
    }

    @Test
    public void checkRemoverVooPorId() {
        Voo novoVoo = new Voo("Estados Unidos", "Brasil", 100, LocalDate.now());
        UUID novoVooId = novoVoo.getID();
        vooRepository.adicionarVoo(novoVoo);
        vooRepository.removerVooPorId(novoVooId);
        assertEquals(vooRepository.getTotalVoosCadastrados(), 0);
    }
}
