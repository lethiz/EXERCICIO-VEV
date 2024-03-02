package repositories.tests;

import models.Voo;
import org.junit.Before;
import org.junit.Test;
import repositories.VooRepository;

import java.time.LocalDate;
import java.util.ArrayList;

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
}
