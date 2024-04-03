package models.tests;

import models.Voo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class VooUnitTests {

    @Test
    @DisplayName("1 - Teste de construtor com parâmetros válidos.")
    @Tag("TesteDebConstrutor")
    public void testConstructorValidParametersObjectCreated() {
        // Arrange
        String origem = "Origem";
        String destino = "Destino";
        int totalPassageiros = 100;
        LocalDate data = LocalDate.now().plusDays(1);
        float preco = 100.0f;

        // Act
        Voo voo = new Voo(origem, destino, totalPassageiros, data, preco);

        // Assert
        assertAll("Voo",
                () -> assertNotNull(voo),
                () -> assertEquals(origem, voo.getOrigem()),
                () -> assertEquals(destino, voo.getDestino()),
                () -> assertEquals(totalPassageiros, voo.getTotalPassageiros()),
                () -> assertEquals(data, voo.getData()),
                () -> assertEquals(preco, voo.getPreco())
        );
    }

    @Test
    @DisplayName("2 - Teste de construtor com origem null.")
    @Tag("TesteDeConstrutor")
    public void testConstructorNullOrigem() {
        assertThrows(NullPointerException.class, () -> new Voo(null, "Destino", 100, LocalDate.now().plusDays(1), 100.0f));
    }

    @Test
    @DisplayName("3 - Teste de construtor com origem curta demais.")
    @Tag("TesteDeConstrutor")
    public void testConstructorShortOrigem() {
        assertThrows(IllegalArgumentException.class, () -> new Voo("A", "Destino", 100, LocalDate.now().plusDays(1), 100.0f));
    }

    @Test
    @DisplayName("4 - Teste de construtor com destino nulo.")
    @Tag("TesteDeConstrutor")
    public void testConstructorNullDestino() {
        assertThrows(IllegalArgumentException.class, () -> new Voo("Origem", null, 100, LocalDate.now().plusDays(1), 100.0f));
    }

    @Test
    @DisplayName("5 - Teste de construtor com destino curto demais.")
    @Tag("TesteDeConstrutor")
    public void testConstructorShortDestino() {
        assertThrows(IllegalArgumentException.class, () -> new Voo("Origem", "A", 100, LocalDate.now().plusDays(1), 100.0f));
    }

    @Test
    @DisplayName("6 - Teste de construtor com número de passageiros negativos.")
    @Tag("TesteDeConstrutor")
    public void testConstructorNegativeTotalPassageiros() {
        assertThrows(IllegalArgumentException.class, () -> new Voo("Origem", "Destino", -100, LocalDate.now().plusDays(1), 100.0f));
    }

    @Test
    @DisplayName("7 - Teste de construtor com data nula")
    @Tag("TesteDeConstrutor")
    public void testConstructorNullData() {
        assertThrows(NullPointerException.class, () -> new Voo("Origem", "Destino", 100, null, 100.0f));
    }

    @Test
    @DisplayName("8 - Teste de construtor com data no passado.")
    @Tag("TesteDeConstrutor")
    public void testConstructorDataPassado() {
        assertThrows(IllegalArgumentException.class, () -> new Voo("Origem", "Destino", 100, LocalDate.now().minusDays(1), 100.0f));
    }

    @Test
    @DisplayName("9 - Teste de construtor com preço negativo.")
    @Tag("TesteDeConstrutor")
    public void testConstructorNegativePreco() {
        assertThrows(IllegalArgumentException.class, () -> new Voo("Origem", "Destino", 100, LocalDate.now().plusDays(1), -100.0f));
    }

    @Test
    @DisplayName("10 - Teste de decremento do total de passageiros.")
    @Tag("TesteDeFuncionalidade")
    public void testDecrementarTotalPassageirosValidTotalPassageirosDecremented() {
        Voo voo = new Voo("Origem", "Destino", 100, LocalDate.now().plusDays(1), 100.0f);

        voo.decrementarTotalPassageiros(50);

        assertEquals(50, voo.getTotalPassageiros());
    }

    @Test
    @DisplayName("11 - Teste da formatação do toString.")
    @Tag("TesteDeFuncionalidade")
    public void testToStringCorrectFormatReturnsFormattedString() {
        Voo voo = new Voo("Origem", "Destino", 100, LocalDate.of(2026, 1, 1), 100.0f);

        String result = voo.toString();

        assertAll("toString",
                () -> assertTrue(result.contains("ID=" + voo.getID())),
                () -> assertTrue(result.contains("Origem: 'Origem'")),
                () -> assertTrue(result.contains("Destino: 'Destino'")),
                () -> assertTrue(result.contains("Total de passageiros: 100")),
                () -> assertTrue(result.contains("Data: 2026-01-01")),
                () -> assertTrue(result.contains("Valor da passagem: 100.0"))
        );

    }
}
