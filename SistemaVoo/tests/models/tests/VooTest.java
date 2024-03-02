package models.tests;

import models.Voo;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
public class VooTest {

    private static Voo novoVoo;
    private static UUID vooId;

    @Before
    public void setupVoos() {
        novoVoo = new Voo("Brasil", "Argentina", 200, LocalDate.now(), 3289);
        vooId = novoVoo.getID();
    }

    @Test
    public void testCriarVoo() {
        Voo novoVoo = new Voo("Brasil", "Argentina", 200, LocalDate.now(), 2344);
        assertNotNull(novoVoo);
    }

    @Test
    public void testGetId() {
        assertEquals(novoVoo.getID(), vooId);
    }

    @Test
    public void testGetVooOrigem() {
        assertEquals(novoVoo.getOrigem(), "Brasil");
    }

    @Test
    public void testSetVooOrigem() {
        novoVoo.setOrigem("Chile");
        assertEquals(novoVoo.getOrigem(), "Chile");
    }

    @Test
    public void testGetVooDestino() {
        assertEquals(novoVoo.getDestino(), "Argentina");
    }

    @ Test
    public void testSetVooDestino() {
        novoVoo.setDestino("Chile");
        assertEquals(novoVoo.getDestino(), "Chile");
    }

    @Test
    public void testGetTotalPassageiros() {
        assertEquals(novoVoo.getTotalPassageiros(), 200);
    }

    @Test
    public void testSetTotalPassageiros() {
        novoVoo.setTotalPassageiros(150);
        assertEquals(novoVoo.getTotalPassageiros(), 150);
    }

    @Test
    public void testGetData() {
        String dataVoo = novoVoo.getData().toString();
        assertEquals(dataVoo, LocalDate.now().toString());
    }

    @Test
    public void testDecrementarQuantidadePassageiros() {
        novoVoo.decrementarTotalPassageiros();
        assertEquals(novoVoo.getTotalPassageiros(), 199);
    }
}
