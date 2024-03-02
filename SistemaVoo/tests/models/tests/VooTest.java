package models.tests;

import models.Voo;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
public class VooTest {

    private static Voo novoVoo;

    @Before
    public void setupVoos() {
        novoVoo = new Voo("Brasil", "Argentina", 200, LocalDate.now());
    }

    @Test
    public void criarVoo() {
        Voo novoVoo = new Voo("Brasil", "Argentina", 200, LocalDate.now());
        assertNotNull(novoVoo);
    }

    @Test
    public void getVooOrigem() {
        assertEquals(novoVoo.getOrigem(), "Brasil");
    }

    @Test
    public void setVooOrigem() {
        novoVoo.setOrigem("Chile");
        assertEquals(novoVoo.getOrigem(), "Chile");
    }

    @Test
    public void getVooDestino() {
        assertEquals(novoVoo.getDestino(), "Argentina");
    }

    @ Test
    public void setVooDestino() {
        novoVoo.setDestino("Chile");
        assertEquals(novoVoo.getDestino(), "Chile");
    }

    @Test
    public void getTotalPassageiros() {
        assertEquals(novoVoo.getTotalPassageiros(), 200);
    }

    @Test
    public void setTotalPassageiros() {
        novoVoo.setTotalPassageiros(150);
        assertEquals(novoVoo.getTotalPassageiros(), 150);
    }

    @Test
    public void getData() {
        String dataVoo = novoVoo.getData().toString();
        assertEquals(dataVoo, LocalDate.now().toString());
    }

    @Test
    public void decrementarQuantidadePassageiros() {
        novoVoo.decrementarTotalPassageiros();
        assertEquals(novoVoo.getTotalPassageiros(), 199);
    }
}
