package repositories.tests;

import models.Voo;
import org.junit.Before;
import org.junit.Test;
import repositories.VooRepository;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VooRepositoryTest {

    private static VooRepository vooRepository;

    @Before
    public void setupVooRepository() {
        ArrayList<Voo> voos = new ArrayList<Voo>();
        vooRepository = new VooRepository(voos);
    }

    @Test
    public void checkCreated() {
        assertNotNull(vooRepository);
    }
}
