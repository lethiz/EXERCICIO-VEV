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
        assertNotNull(novoVoo);
    }

    @Test
    public void testGetId() {
        assertEquals(vooId, novoVoo.getID());
    }

    @Test
    public void testGetVooOrigem() {
        assertEquals("Brasil", novoVoo.getOrigem());
    }

    @Test
    public void testSetVooOrigem() {
        novoVoo.setOrigem("Chile");
        assertEquals("Chile", novoVoo.getOrigem());
    }

    @Test
    public void testGetVooDestino() {
        assertEquals("Argentina", novoVoo.getDestino());
    }

    @Test
    public void testSetVooDestino() {
        novoVoo.setDestino("Chile");
        assertEquals("Chile", novoVoo.getDestino());
    }

    @Test
    public void testGetTotalPassageiros() {
        assertEquals(200, novoVoo.getTotalPassageiros());
    }

    @Test
    public void testSetTotalPassageiros() {
        novoVoo.setTotalPassageiros(150);
        assertEquals(150, novoVoo.getTotalPassageiros());
    }

    @Test
    public void testGetData() {
        String dataVoo = novoVoo.getData().toString();
        assertEquals(LocalDate.now().toString(), dataVoo);
    }

    @Test
    public void testDecrementarQuantidadePassageiros() {
        novoVoo.decrementarTotalPassageiros(1);
        assertEquals(199, novoVoo.getTotalPassageiros());
    }

    @Test
    public void testToString() {
        Voo voo = new Voo("Origem", "Destino", 10, LocalDate.of(2022, 12, 31), 100.0f);

        String expected = "ID=" + voo.getID() +
                ",\nOrigem: '" + voo.getOrigem() + '\'' +
                ",\nDestino: '" + voo.getDestino() + '\'' +
                ",\nTotal de passageiros: " + voo.getTotalPassageiros() +
                ",\nData: " + voo.getData() +
                ",\nValor da passagem: " + voo.getPreco() +
                '}';

        assertEquals(expected, voo.toString());
    }

    @Test
    public void testToStringEmptyOrigemAndDestino() {
        Voo voo = new Voo("", "", 10, LocalDate.of(2022, 12, 31), 100.0f);

        String expected = "ID=" + voo.getID() +
                ",\nOrigem: ''" +
                ",\nDestino: ''" +
                ",\nTotal de passageiros: " + voo.getTotalPassageiros() +
                ",\nData: " + voo.getData() +
                ",\nValor da passagem: " + voo.getPreco() +
                '}';

        assertEquals(expected, voo.toString());
    }

}
