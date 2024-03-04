import models.Reserva;
import models.Voo;
import repositories.ReservaRepository;
import repositories.VooRepository;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class SystemVoo {

    public static void main(String[] args) {
        VooRepository voos = new VooRepository();

        Voo vooAlpha = new Voo("Brasil", "Argentina", 50, LocalDate.now(), 2308);
        Voo vooBeta = new Voo("Brasil", "Estados Unidos", 80, LocalDate.now(), 2308);
        Voo vooGama = new Voo("Estados Unidos", "Reino Unido", 90, LocalDate.now(), 2308);
        Voo vooDelta = new Voo("Brasil", "Reino Unido", 200, LocalDate.now(), 2308);

        voos.adicionarVoo(vooAlpha);
        voos.adicionarVoo(vooBeta);
        voos.adicionarVoo(vooGama);
        voos.adicionarVoo(vooDelta);

        ReservaRepository reservas = new ReservaRepository();
        Scanner scanner = new Scanner(System.in);
        String escolha = "";
        while (true) {
            escolha = menu(scanner);
            executarOperacao(escolha, voos, reservas, scanner);
        }
    }

    public static String menu(Scanner scanner) {
        System.out.println(
                """
                    (L)istar Voos
                    (F)azer uma reserva
                    (C)ancelar reserva
                    (V)erificar minha reserva
                    (E)ncerrar operação.
                    Opção -> """);
        return scanner.nextLine().toUpperCase();
    }

    private static void executarOperacao(String operacao, VooRepository voos, ReservaRepository reservas, Scanner scanner) {
        switch (operacao) {
            case "L" -> listarVoosMenu(voos, scanner);
            case "F" -> criarReserva(voos, reservas, scanner);
            /*case "C" -> cancelarReserva(scanner, voos, reservas);*/
            case "V" -> verificarReserva(scanner, reservas);
            case "E" -> sair();
            default -> System.out.println("Opção inválida!");
        }
    }

    /*private static void cancelarReservaMenu(Scanner scanner, VooRepository voos, ReservaRepository reservas) {
        System.out.println("Digite o ID da reserva a qual você deseja cancelar: ");

        System.out.println("Digite o seu nome de usuário: ");
    }*/

    private static void verificarReserva(Scanner scanner, ReservaRepository reservas) {
        System.out.println("Digite o ID da reserva a qual você deseja ver: ");
        String reservaId = scanner.nextLine();

        UUID reservaUUid;
        try {
            reservaUUid = UUID.fromString(reservaId);
        } catch (Exception e) {
            System.out.println("\nO código de reserva fornecido está inválido!\nRetornando ao menu principal...\n");
            return;
        }

        Reserva targetReserva = reservas.getReservaPorId(reservaUUid);
        String result = targetReserva == null ? "Não foi possível encontrar uma reserva cadastrada em nosso sistema com o ID fornecido" :
                targetReserva.toString();

        System.out.println(result);

    }

    private static void listarVoosMenu(VooRepository voos, Scanner scanner) {

        System.out.println("\nSeleciona uma opção:");
        System.out.println("(1) - Listar todos os voos.");
        System.out.println("(2) - Listar com base em algum critério.");
        String escolha = scanner.nextLine();

        switch(escolha) {
            case "1" -> listarTodosVoos(voos);
            case "2" -> coletarFiltros(voos, scanner);
            default -> System.out.println("Opção inválida! Retornando ao menu inicial.");
        }


    }

    private static void coletarFiltros(VooRepository voos, Scanner scanner) {
        System.out.println("\nDigite os critérios pelos quais deseja filtrar os voos, ou deixe vazio caso o filtro não seja relevante.\n");

        System.out.println("Origem: ");
        String origem = scanner.nextLine();

        System.out.println("Destino: ");
        String destino = scanner.nextLine();

        System.out.println("Quantidade de passageiros: ");
        String quantidadePassageiros = scanner.nextLine();

        System.out.println("Data (AAAA-MM-DD): ");
        String data = scanner.nextLine();

        System.out.println("Valor da passagem: ");
        String valor = scanner.nextLine();

        listarVoosPorCriterio(voos, origem, destino, quantidadePassageiros, data, valor);

    }

    private static void listarVoosPorCriterio(VooRepository voos, String origem, String destino, String quantidadePassageiros, String data, String valor) {

        // Parte do casting
        LocalDate dataConvertida = data == "" ? null : LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        float valorConvertido = valor == "" ? 0 : Float.parseFloat(valor);
        int quantidadePassageirosConvertida = quantidadePassageiros == "" ? 0 : Integer.parseInt(quantidadePassageiros);

        List<Voo> resultados = voos.getVoosPorFiltros(origem, destino, dataConvertida, valorConvertido, quantidadePassageirosConvertida);
        for (int i = 0; i < resultados.size(); i++) {
            System.out.printf("Voo " + (i+1) + " --------------------------------------------\n");
            System.out.println(resultados.get(i));
            System.out.println("--------------------------------------------------\n");
        }

    }

    // RESERVA

    public static void criarReserva(VooRepository voos, ReservaRepository reservas, Scanner scanner) {

        System.out.println("Insira o ID do Voo no qual você irá embarcar:");
        String vooId  = scanner.nextLine();

        System.out.println("Insira o seu nome: ");
        String username  = scanner.nextLine();

        System.out.println("Insira o seu número de telefone: ");
        String phonenumber = scanner.nextLine();

        System.out.println("Insira a quantidade de passagens que deseja comprar: ");
        String quantidadePassageiros = scanner.nextLine();

        List<String> credenciais = new ArrayList<>(List.of(vooId, username, phonenumber, quantidadePassageiros));

        try {
            validarCredenciais(credenciais);
        } catch (Exception e) {
            System.out.println("As credenciais fornecidas são inválidas! Retornando ao menu inicial.");
            return;
        }


        // Parsing para UUID
        UUID vooUuid = UUID.fromString(vooId);
        // Parsing para Integer
        int quantidadePassageirosParsed = Integer.parseInt(quantidadePassageiros);

        // Parte que calcula o valor total
        float valorTotal = calcularValorTotal(vooUuid, quantidadePassageirosParsed, voos);

        // Atualiza a quantidade de passageiros dentro dos voos
        voos.atualizarQtdPassageirosDisponiveis(vooUuid, quantidadePassageirosParsed);

        // Criação da reserva
        Reserva novaReserva = new Reserva(username, phonenumber, vooUuid, quantidadePassageirosParsed, valorTotal);
        reservas.criarReserva(novaReserva);
        System.out.println("Reserva realizada com sucesso! Confira os detalhes abaixo:");
        System.out.println("--------------------------------------------\n");
        System.out.println(novaReserva);
    }

    public static float calcularValorTotal(UUID vooId, int quantidadePassageiros, VooRepository voos) {
        Voo voo = voos.getVooPorId(vooId);
        return voo.getPreco() * quantidadePassageiros;
    }

    public static void validarCredenciais(List<String> credenciais) {
        for (String c : credenciais) {
            if (c.isEmpty()) {
                throw new IllegalArgumentException("A quantidade de passageiros fornecida está vazia!");
            }
        }
    }
    private static void listarTodosVoos(VooRepository voos) {

        List<Voo> resultados = voos.getVoos();
        for (int i = 0; i < resultados.size(); i++) {
            System.out.printf("Voo " + (i+1) + " --------------------------------------------\n");
            System.out.println(resultados.get(i));
            System.out.println("--------------------------------------------------\n");
        }

    }
    private static void sair() {
        System.out.println("\nObrigado por utilizar os nossos serviços!");
        System.exit(0);
    }

}
