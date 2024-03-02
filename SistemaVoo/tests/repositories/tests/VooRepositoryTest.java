package repositories.tests;

import org.junit.Before;
import repositories.VooRepository;

public class VooRepositoryTest {

    private static VooRepository vooRepository;

    @Before
    private void setupVooRepository() {
        vooRepository = new VooRepository();
        assertNotNull(vooRepository);
    }
}
