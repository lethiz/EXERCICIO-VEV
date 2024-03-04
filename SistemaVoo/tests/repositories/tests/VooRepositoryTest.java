package repositories.tests;

import models.Voo;
import org.junit.Before;
import org.junit.Test;
import repositories.VooRepository;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    public void checkRepositorioConstrutorVazio() {
        VooRepository novoVooRepository = new VooRepository();
        assertNotNull(novoVooRepository);
    }

    @Test
    public void checkTotalVoosCadastrados() {
        assertEquals(0, vooRepository.getTotalVoosCadastrados());
    }

    @Test
    public void checkAdicionarVoo() {
        Voo novoVoo = new Voo("Estados Unidos", "Brasil", 100, LocalDate.now(), 983);
        vooRepository.adicionarVoo(novoVoo);
        assertEquals(1, vooRepository.getTotalVoosCadastrados());

    }

    @Test
    public void checkRemoverVoo() {
        Voo novoVoo = new Voo("Estados Unidos", "Brasil", 100, LocalDate.now(), 1202);
        vooRepository.adicionarVoo(novoVoo);
        vooRepository.removerVoo(novoVoo);
        assertEquals(0, vooRepository.getTotalVoosCadastrados());
    }
    @Test
    public void checkRemoverVooPorId() {
        Voo novoVoo = new Voo("Estados Unidos", "Brasil", 100, LocalDate.now(), 2308);
        UUID novoVooId = novoVoo.getID();
        vooRepository.adicionarVoo(novoVoo);
        vooRepository.removerVooPorId(novoVooId);
        assertEquals(0, vooRepository.getTotalVoosCadastrados());
    }

    @Test
    public void checkChecarVoosPorOrigem() {
        Voo vooAlpha = new Voo("Brasil", "Argentina", 50, LocalDate.now(), 2308);
        Voo vooBeta = new Voo("Brasil", "Estados Unidos", 80, LocalDate.now(), 2308);
        Voo vooGama = new Voo("Estados Unidos", "Reino Unido", 90, LocalDate.now(), 2308);
        Voo vooDelta = new Voo("Brasil", "Reino Unido", 200, LocalDate.now(), 2308);

        vooRepository.adicionarVoo(vooAlpha);
        vooRepository.adicionarVoo(vooBeta);
        vooRepository.adicionarVoo(vooGama);
        vooRepository.adicionarVoo(vooDelta);

        ArrayList<Voo> voosEsperados = new ArrayList<>(Arrays.asList(vooAlpha, vooBeta, vooDelta));
        assertEquals(voosEsperados, vooRepository.getVoosPorOrigem("Brasil"));
    }

    @Test
    public void checkChecarVoosPorDestino() {
        Voo vooAlpha = new Voo("Brasil", "Argentina", 50, LocalDate.now(), 2308);
        Voo vooBeta = new Voo("Brasil", "Estados Unidos", 80, LocalDate.now(), 2308);
        Voo vooGama = new Voo("Estados Unidos", "Reino Unido", 90, LocalDate.now(), 2308);
        Voo vooDelta = new Voo("Brasil", "Reino Unido", 200, LocalDate.now(), 2308);

        vooRepository.adicionarVoo(vooAlpha);
        vooRepository.adicionarVoo(vooBeta);
        vooRepository.adicionarVoo(vooGama);
        vooRepository.adicionarVoo(vooDelta);

        ArrayList<Voo> voosEsperados = new ArrayList<>(Arrays.asList(vooGama, vooDelta));

        assertEquals(voosEsperados, vooRepository.getVoosPorDestino("Reino Unido"));
    }

    @Test
    public void checkGetVoosPorNumPassageiros() {
        Voo vooAlpha = new Voo("Brasil", "Argentina", 50, LocalDate.now(), 2308);
        Voo vooBeta = new Voo("Brasil", "Estados Unidos", 80, LocalDate.now(), 2308);
        Voo vooGama = new Voo("Estados Unidos", "Reino Unido", 90, LocalDate.now(), 2308);
        Voo vooDelta = new Voo("Brasil", "Reino Unido", 200, LocalDate.now(), 2308);

        vooRepository.adicionarVoo(vooAlpha);
        vooRepository.adicionarVoo(vooBeta);
        vooRepository.adicionarVoo(vooGama);
        vooRepository.adicionarVoo(vooDelta);

        ArrayList<Voo> voosEsperados = new ArrayList<>(List.of(vooGama));

        assertEquals(voosEsperados, vooRepository.getVoosPorNumPassageiros(90));
    }

    @Test
    public void checkGetVoosPorData() {
        Voo vooAlpha = new Voo("Brasil", "Argentina", 50, LocalDate.now().plusDays(7), 2308);

        vooRepository.adicionarVoo(vooAlpha);

        ArrayList<Voo> voosEsperados = new ArrayList<>(List.of(vooAlpha));

        LocalDate hoje = LocalDate.now();
        LocalDate proxSemana = hoje.plusDays(7);
        assertEquals(voosEsperados, vooRepository.getVoosPorData(proxSemana));
    }

    @Test
    public void checkGetAllVoos() {
        Voo vooAlpha = new Voo("Brasil", "Argentina", 50, LocalDate.now(), 2308);
        Voo vooBeta = new Voo("Brasil", "Estados Unidos", 80, LocalDate.now(), 2308);
        Voo vooGama = new Voo("Estados Unidos", "Reino Unido", 90, LocalDate.now(), 2308);
        Voo vooDelta = new Voo("Brasil", "Reino Unido", 200, LocalDate.now(), 2308);

        vooRepository.adicionarVoo(vooAlpha);
        vooRepository.adicionarVoo(vooBeta);
        vooRepository.adicionarVoo(vooGama);
        vooRepository.adicionarVoo(vooDelta);

        ArrayList<Voo> voosEsperados = new ArrayList<>(Arrays.asList(vooAlpha, vooBeta, vooGama, vooDelta));

        assertEquals(voosEsperados, vooRepository.getVoos());
    }
}
