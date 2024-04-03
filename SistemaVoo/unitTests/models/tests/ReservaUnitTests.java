package models.tests;

import models.Reserva;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaUnitTests {

    @Test
    @DisplayName("Teste de construtor com parâmetros válidos.")
    @Tag("TesteDeConstrutor")
    public void testConstructorValidParametersObjectCreated() {
        String username = "Alice";
        String phoneNumber = "83999999999";
        UUID vooId = UUID.randomUUID();
        int amountPassengers = 2;
        float valorTotal = 200.0f;

        Reserva reserva = new Reserva(username, phoneNumber, vooId, amountPassengers, valorTotal);

        assertAll("Reserva",
                () -> assertNotNull(reserva),
                () -> assertEquals(username, reserva.getUsername()),
                () -> assertEquals(phoneNumber, reserva.getPhoneNumber()),
                () -> assertEquals(vooId, reserva.getVooId()),
                () -> assertEquals(amountPassengers, reserva.getAmountPassengers()),
                () -> assertEquals(valorTotal, reserva.getValorTotal())
        );

    }

    @Test
    @DisplayName("Teste de construtor com username nulo.")
    @Tag("TesteDeConstrutor")
    public void testConstructorNullUsername() {
        assertThrows(NullPointerException.class, () -> new Reserva(null, "83999999999", UUID.randomUUID(), 2, 200.0f));
    }

    @Test
    @DisplayName("Teste de construtor com phoneNumber nulo.")
    @Tag("TesteDeConstrutor")
    public void testConstructorNullPhoneNumber() {
        assertThrows(NullPointerException.class, () -> new Reserva("Alice", null, UUID.randomUUID(), 2, 200.0f));
    }

    @Test
    @DisplayName("Teste de construtor com phoneNumber curto demais.")
    @Tag("TesteDeConstrutor")
    public void testConstructorShortPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Reserva("Alice", "83", UUID.randomUUID(), 2, 200.0f));
    }

    @Test
    @DisplayName("Teste de construtor com phoneNumber não corresponde ao padrão de 11 dígitos.")
    @Tag("TesteDeConstrutor")
    public void testConstructorInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Reserva("Alice", "8399999999", UUID.randomUUID(), 2, 200.0f));
    }

    @Test
    @DisplayName("Teste de construtor com vooId nulo.")
    @Tag("TesteDeConstrutor")
    public void testConstructorNullVooId() {
        assertThrows(NullPointerException.class, () -> new Reserva("Alice", "83999999999", null, 2, 200.0f));
    }

    @Test
    @DisplayName("Teste de construtor com amountPassengers inválido.")
    @Tag("TesteDeConstrutor")
    public void testConstructorNegativeAmountPassengers() {
        assertThrows(IllegalArgumentException.class, () -> new Reserva("Alice", "83999999999", UUID.randomUUID(), -2, 200.0f));
    }

    @Test
    @DisplayName("Teste de construtor com valorTotal inválido.")
    @Tag("TesteDeConstrutor")
    public void testConstructorNegativeValorTotal() {
        assertThrows(IllegalArgumentException.class, () -> new Reserva("Alice", "83999999999", UUID.randomUUID(), 2, -200.0f));
    }

    @Test
    @Tag("TesteDeConstrutor")
    public void testNullUsername() {
        assertThrows(NullPointerException.class, () -> new Reserva(null, "83999999999", UUID.randomUUID(), 1, 100.0f));
    }

    @Test
    @Tag("TesteDeConstrutor")
    public void testEmptyUsername() {
        assertThrows(IllegalArgumentException.class, () -> new Reserva("", "83999999999", UUID.randomUUID(), 1, 100.0f));
    }

    @Test
    @Tag("TesteDeConstrutor")
    public void testNullPhoneNumber() {
        assertThrows(NullPointerException.class, () -> new Reserva("Dewgong", null, UUID.randomUUID(), 1, 100.0f));
    }

    @Test
    @Tag("TesteDeConstrutor")
    public void testEmptyPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Reserva("Bulbasaur", "", UUID.randomUUID(), 1, 100.0f));
    }

    @Test
    @Tag("TesteDeConstrutor")
    public void testInvalidPhoneNumberFormat() {
        assertThrows(IllegalArgumentException.class, () -> new Reserva("Teresa", "1234567890", UUID.randomUUID(), 1, 100.0f));
    }

    @Test
    @Tag("TesteDeConstrutor")
    public void testNullVooId() {
        assertThrows(NullPointerException.class, () -> new Reserva("Pawmi", "83999999999", null, 1, 100.0f));
    }

    @Test
    @Tag("TesteDeConstrutor")
    public void testNegativeAmountPassengers() {
        assertThrows(IllegalArgumentException.class, () -> new Reserva("Pheromosa", "83999999999", UUID.randomUUID(), -1, 100.0f));
    }

    @Test
    @Tag("TesteDeConstrutor")
    public void testZeroValorTotal() {
        assertThrows(IllegalArgumentException.class, () -> new Reserva("Tsareena", "83999999999", UUID.randomUUID(), 1, 0.0f));
    }

    @Test
    @Tag("TesteDeConstrutor")
    public void testNegativeValorTotal() {
        assertThrows(IllegalArgumentException.class, () -> new Reserva("Hanani", "83999999999", UUID.randomUUID(), 1, -100.0f));
    }

    @Test
    @Tag("TesteDeConstrutor")
    public void testReservaCreation() {
        UUID vooId = UUID.randomUUID();
        Reserva reserva = new Reserva("username", "83999999999", vooId, 1, 100.0f);

        assertNotNull(reserva.getId());
        assertTrue(isValidUUID(reserva.getId().toString()));
    }

    // Método auxiliar
    private boolean isValidUUID(String uuid) {
        try {
            UUID.fromString(uuid);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Test
    @DisplayName("Teste do método toString.")
    @Tag("TesteDeFuncionalidade")
    public void testToStringCorrectFormatReturnsFormattedString() {
        Reserva reserva = new Reserva("Hanani", "83999999999", UUID.randomUUID(), 200, 1425);

        String result = reserva.toString();

        assertAll("toString",
                () -> assertTrue(result.contains("ID Reserva: " + reserva.getId())),
                () -> assertTrue(result.contains("Nome de usuário: 'Hanani'")),
                () -> assertTrue(result.contains("Número de telefone: '83999999999'")),
                () -> assertTrue(result.contains("ID do Voo: " + reserva.getVooId())),
                () -> assertTrue(result.contains("Total de passagens: 200")),
                () -> assertTrue(result.contains("Valor Total R$1425.0"))
        );

    }
}
