package repositories.tests;

import org.junit.Test;
import repositories.ReservaRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ReservaRepositoryTest {

    @Test
    public static void ReservaRepositoryTest() {
        ReservaRepository reservaRepository = new ReservaRepository();
        assertNotNull(reservaRepository);
    }
}
