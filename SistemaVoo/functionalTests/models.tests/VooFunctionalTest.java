package models.tests;

import models.Voo;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class VooFunctionalTest {

    @Test
    public void testOrigem() {
        try {
            new Voo("", "Destino", 1, LocalDate.now(), 100.0f);
            fail("Exceção esperada.");
        } catch (IllegalArgumentException e) {
            assertEquals("Origem inválida!", e.getMessage());
        }

        try {
            new Voo("São Paulo", "Destino", 1, LocalDate.now(), 100.0f);
        } catch (IllegalArgumentException e) {
            fail("Exceção esperada.");
        }

        try {
            new Voo(null, "Destino", 1, LocalDate.now(), 100.0f);
            fail("Exceção esperada.");
        } catch (NullPointerException e) {
            assertEquals("Origem nula!", e.getMessage());
        }

        try {
            new Voo("A", "Destino", 1, LocalDate.now(), 100.0f);
            fail("Exceção esperada.");
        } catch (IllegalArgumentException e) {
            assertEquals("Origem inválida!", e.getMessage());
        }

    }

    @Test
    public void testDestino() {
        try {
            new Voo("Origem", "", 1, LocalDate.now(), 100.0f);
            fail("Exceção esperada");
        } catch (IllegalArgumentException e) {
            assertEquals("Destino inválido!", e.getMessage());
        }

        try {
            new Voo("Origem", "A", 1, LocalDate.now(), 100.0f);
            fail("Exceção esperada");
        } catch (IllegalArgumentException e) {
            assertEquals("Destino inválido!", e.getMessage());
        }

        try {
            new Voo("Origem", "Rio de Janeiro", 1, LocalDate.now(), 100.0f);
        } catch (IllegalArgumentException e) {
            fail("Não deveria ter lançado uma exceção");
        }

        try {
            new Voo("Origem", null, 1, LocalDate.now(), 100.0f);
            fail("Deveria ter lançado uma exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("Destino inválido!", e.getMessage());
        }
    }

    @Test
    public void testPrecoVoo() {
        try {
            new Voo("Origem", "Destino", -1, LocalDate.now(), 100.0f);
            fail("Deveria ter lançado uma exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("Total de passageiros inválido!", e.getMessage());
        }

        try {
            new Voo("Origem", "Destino", 0, LocalDate.now(), 100.0f);
            fail("Deveria ter lançado uma exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("Total de passageiros inválido!", e.getMessage());
        }

        try {
            new Voo("Origem", "Destino", 1, LocalDate.now(), 100.0f);
        } catch (IllegalArgumentException e) {
            fail("Voo deveria ter sido criado.");
        }
    }

    @Test
    public void testData() {
        try {
            new Voo("Origem", "Destino", 1, null, 100.0f);
            fail("Exceção esperada.");
        } catch (NullPointerException e) {
            assertEquals("Data nula!", e.getMessage());
        }

        LocalDate dataFutura = LocalDate.now().plusDays(1);
        try {
            new Voo("Origem", "Destino", 1, dataFutura, 100.0f);
        } catch (IllegalArgumentException e) {
            fail("Voo deveria ter sido criado.");
        }

        LocalDate dataPassada = LocalDate.of(2022, 3, 17);
        try {
            new Voo("Origem", "Destino", 1, dataPassada, 100.0f);
        } catch (IllegalArgumentException e) {
            assertEquals("Data no passado!", e.getMessage());
        }
    }

    @Test
    public void testPreco() {

        try {
            new Voo("Origem", "Destino", 1, LocalDate.now(), -1.0f);
            fail("Exceção esperada");
        } catch (IllegalArgumentException e) {
            assertEquals("Preço inválido!", e.getMessage());
        }

        try {
            new Voo("Origem", "Destino", 1, LocalDate.now(), 0.0f);
            fail("Deveria ter lançado uma exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("Preço inválido!", e.getMessage());
        }

        try {
            new Voo("Origem", "Destino", 1, LocalDate.now(), 100.0f);
        } catch (IllegalArgumentException e) {
            fail("Não deveria ter lançado uma exceção");
        }
    }
}
