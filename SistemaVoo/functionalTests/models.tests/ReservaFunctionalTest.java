package models.tests;
import models.Reserva;
import org.junit.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
public class ReservaFunctionalTest {

    @Test
    public void testUsername() {
        try {
            new Reserva(null, "123456789", UUID.randomUUID(), 1, 100.0f);
            fail("Exceção esperada");
        } catch (NullPointerException e) {
            assertEquals("Nome de usuário nulo!", e.getMessage());
        }

        try {
            new Reserva("", "123456789", UUID.randomUUID(), 1, 100.0f);
            fail("Exceção esperada");
        } catch (IllegalArgumentException e) {
            assertEquals("Nome de usuário inválido!", e.getMessage());
        }

        try {
            new Reserva("username", "12345678911", UUID.randomUUID(), 1, 100.0f);
        } catch (IllegalArgumentException e) {
            fail("Reserva deveria ser cadastrada");
        }
    }

    @Test
    public void testPhonenumber() {
        // Testes para phoneNumber
        try {
            new Reserva("username", null, UUID.randomUUID(), 1, 100.0f);
            fail("Exceção esperada");
        } catch (NullPointerException e) {
            assertEquals("Número de telefone nulo!", e.getMessage());
        }

        try {
            new Reserva("username", "", UUID.randomUUID(), 1, 100.0f);
            fail("Exceção esperada");
        } catch (IllegalArgumentException e) {
            assertEquals("Número de telefone inválido!", e.getMessage());
        }

        try {
            new Reserva("username", "11235ghijkl", UUID.randomUUID(), 1, 0.0f);
            fail("Exceção esperada");
        } catch (IllegalArgumentException e) {
            assertEquals("Número de telefone não corresponde ao padrão de 11 dígitos.", e.getMessage());
        }

        try {
            new Reserva("username", "12345678911", UUID.randomUUID(), 1, 100.0f);
        } catch (IllegalArgumentException e) {
            fail("Reserva deve ser cadastrada");
        }

    }

    @Test
    public void testVooId() {

        try {
            new Reserva("username", "12345678911", null, 1, 100.0f);
            fail("Exceção esperada");
        } catch (NullPointerException e) {
            assertEquals("VooId nulo!", e.getMessage());
        }

        UUID vooId = UUID.randomUUID();
        try {
            new Reserva("username", "12345678911", vooId, 1, 100.0f);
        } catch (IllegalArgumentException e) {
            fail("Reserva deve ser cadastrada");
        }
    }

    @Test
    public void testAmountPassengers() {

        try {
            new Reserva("username", "12345678911", UUID.randomUUID(), -1, 100.0f);
            fail("Exceção esperada");
        } catch (IllegalArgumentException e) {
            assertEquals("AmountPassengers inválido!", e.getMessage());
        }

        try {
            new Reserva("username", "12345678119", UUID.randomUUID(), 0, 100.0f);
            fail("Exceção esperada");
        } catch (IllegalArgumentException e) {
            assertEquals("AmountPassengers inválido!", e.getMessage());
        }

        try {
            new Reserva("username", "12345678119", UUID.randomUUID(), 1, 100.0f);
        } catch (IllegalArgumentException e) {
            fail("Reserva deve ser cadastrada");
        }
    }

    @Test
    public void testValorTotal() {
        try {
            new Reserva("username", "12341156789", UUID.randomUUID(), 1, -1.0f);
            fail("Exceção esperada");
        } catch (IllegalArgumentException e) {
            assertEquals("ValorTotal inválido!", e.getMessage());
        }

        try {
            new Reserva("username", "12341156789", UUID.randomUUID(), 1, 0.0f);
            fail("Exceção esperada");
        } catch (IllegalArgumentException e) {
            assertEquals("ValorTotal inválido!", e.getMessage());
        }

        try {
            new Reserva("username", "11123456789", UUID.randomUUID(), 1, 100.0f);
        } catch (IllegalArgumentException e) {
            fail("Reserva deve ser cadastrada");
        }
    }
}