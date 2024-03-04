import models.Voo;
import repositories.ReservaRepository;
import repositories.VooRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class SystemVoo {

    public static void main(String[] args) {
        VooRepository voos = new VooRepository();
        ReservaRepository reservas = new ReservaRepository();
        Scanner scanner = new Scanner(System.in);
        String escolha = "";
        while (true) {
            escolha = menu(scanner);
            comando(escolha, voos, reservas, scanner);
        }
    }

    public static String menu(Scanner scanner) {
        System.out.println(
                """
                        (L)istar Voos
                        (F)azer uma reserva
                        (C)ancelar reserva
                        (V)erificar minha reserva
                        (F)inalizar operação.
                        Opção ->
                        """);
        return scanner.nextLine().toUpperCase();
    }

    private static void executarOperacao(String operacao, VooRepository voos, ReservaRepository reservas, Scanner scanner) {
        switch (operacao) {
            case "L" -> listarVoos(voos);
            case "F" -> criarReserva(scanner, voos, reservas);
            case "C" -> cancelarReserva(scanner, voos, reservas);
            case "V" -> verificarReserva(scanner, reservas);
            case "F" -> sair();
            default -> System.out.println("Opção inválida!");
        }
    }

    private static void listarVoos(VooRepository voos) {
        String resultadoVoos = "";
        ArrayList<Voo> resultados;
    }

}
