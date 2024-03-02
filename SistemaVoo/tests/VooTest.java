import models.Voo;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
public class VooTest {

    @Test
    public void criarVoo() {
        Voo novoVoo = new Voo("Brasil", "Argentina", 200, new Date());
        assertNotNull(novoVoo);
    }

    @Test
    public void getVooOrigem() {
        Voo novoVoo = new Voo("Brasil", "Argentina", 200, new Date());
        assertEquals(novoVoo.getOrigem(), "Brasil");
    }

    @Test
    public void setVooOrigem() {
        Voo novoVoo = new Voo("Brasil", "Argentina", 200, new Date());
        novoVoo.setOrigem("Chile");
        assertEquals(novoVoo.getOrigem(), "Chile");
    }

    @Test
    public void getVooDestino() {
        Voo novoVoo = new Voo("Brasil", "Argentina", 200, new Date());
        assertEquals(novoVoo.getDestino(), "Argentina");
    }

    @ Test
    public void setVooDestino() {
        Voo novoVoo = new Voo("Brasil", "Argentina", 200, new Date());
        novoVoo.setDestino("Chile");
        assertEquals(novoVoo.getDestino(), "Chile");
    }

    @Test
    public void getTotalPassageiros() {
        Voo novoVoo = new Voo("Brasil", "Argentina", 200, new Date());
        assertEquals(novoVoo.getTotalPassageiros(), 200);
    }

    @Test
    public void setTotalPassageiros() {
        Voo novoVoo = new Voo("Brasil", "Argentina", 200, new Date());
        novoVoo.setTotalPassageiros(150);
        assertEquals(novoVoo.getTotalPassageiros(), 150);
    }
}
