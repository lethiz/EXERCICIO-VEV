import models.Voo;
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
}
