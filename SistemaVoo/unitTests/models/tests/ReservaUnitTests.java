package models.tests;

import models.Reserva;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaUnitTests {

    @Test
    @DisplayName("1 - Teste de construtor com parâmetros válidos.")
    @Tag("TesteDeConstrutor")
    public void testConstructorValidParametersObjectCreated() {
        // Arrange
        String username = "Alice";
        String phoneNumber = "83999999999";
        UUID vooId = UUID.randomUUID();
        int amountPassengers = 2;
        float valorTotal = 200.0f;

        // Act
        Reserva reserva = new Reserva(username, phoneNumber, vooId, amountPassengers, valorTotal);

        // Assert
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
    @DisplayName("2 - Teste de construtor com username nulo.")
    @Tag("TesteDeConstrutor")
    public void testConstructorNullUsername() {
        assertThrows(NullPointerException.class, () -> new Reserva(null, "83999999999", UUID.randomUUID(), 2, 200.0f));
    }

    @Test
    @DisplayName("3 - Teste de construtor com phoneNumber nulo.")
    @Tag("TesteDeConstrutor")
    public void testConstructorNullPhoneNumber() {
        assertThrows(NullPointerException.class, () -> new Reserva("Alice", null, UUID.randomUUID(), 2, 200.0f));
    }

    @Test
    @DisplayName("4 - Teste de construtor com phoneNumber curto demais.")
    @Tag("TesteDeConstrutor")
    public void testConstructorShortPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Reserva("Alice", "83", UUID.randomUUID(), 2, 200.0f));
    }

    @Test
    @DisplayName("5 - Teste de construtor com phoneNumber não corresponde ao padrão de 11 dígitos.")
    @Tag("TesteDeConstrutor")
    public void testConstructorInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Reserva("Alice", "8399999999", UUID.randomUUID(), 2, 200.0f));
    }

    @Test
    @DisplayName("6 - Teste de construtor com vooId nulo.")
    @Tag("TesteDeConstrutor")
    public void testConstructorNullVooId() {
        assertThrows(NullPointerException.class, () -> new Reserva("Alice", "83999999999", null, 2, 200.0f));
    }

    @Test
    @DisplayName("7 - Teste de construtor com amountPassengers inválido.")
    @Tag("TesteDeConstrutor")
    public void testConstructorNegativeAmountPassengers() {
        assertThrows(IllegalArgumentException.class, () -> new Reserva("Alice", "83999999999", UUID.randomUUID(), -2, 200.0f));
    }

    @Test
    @DisplayName("8 - Teste de construtor com valorTotal inválido.")
    @Tag("TesteDeConstrutor")
    public void testConstructorNegativeValorTotal() {
        assertThrows(IllegalArgumentException.class, () -> new Reserva("Alice", "83999999999", UUID.randomUUID(), 2, -200.0f));
    }

    @Test
    @DisplayName("9 - Teste do método toString.")
    @Tag("TesteDeFuncionalidade")
    public void testToStringCorrectFormatReturnsFormattedString() {
        // Arrange
        Reserva reserva = new Reserva("Hanani", "83999999999", UUID.randomUUID(), 200, 1425);

        // Act
        String result = reserva.toString();

        // Assert
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
