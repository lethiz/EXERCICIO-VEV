import main.exceptions.InvalidIDException;
import main.exceptions.Model.*;
import main.exceptions.Service.InvalidComparacaoException;
import main.exceptions.Service.InvalidTarefaException;
import main.models.Tarefa;
import main.services.ITarefaService;
import main.services.TarefaService;
import main.util.TarefaPrioridade;

import java.util.List;
import java.util.Scanner;

public class SystemTarefas {

    public static void main(String[] args) throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException, InvalidComparacaoException, InvalidIDException, InvalidTarefaException {
        ITarefaService tarefaService = new TarefaService();

        tarefaService.criarTarefa("Titulo A", "Descrição A", "25/09/2024", "ALTA");
        tarefaService.criarTarefa("Titulo B", "Descrição B", "25/09/2024", "BAIXA");
        tarefaService.criarTarefa("Titulo C", "Descrição C", "26/09/2024", "MEDIA");
        tarefaService.criarTarefa("Titulo D", "Descrição D", "27/09/2024", "ALTA");

        Scanner scanner = new Scanner(System.in);
        String escolha = "";
        while (true) {
            escolha = menu(scanner);
            executarOperacao(escolha, tarefaService, scanner);
        }
    }

    public static String menu(Scanner scanner) {
        System.out.println(
                """
                    (L)istar Tarefas
                    (C)riar nova T  arefa
                    (R)remover Tarefa
                    (A)tualizar Tarefa
                    (M)arcar Prioridade de Tarefa
                    (E)ncerrar operação.
                    Opção -> """);
        return scanner.nextLine().toUpperCase();
    }

    private static void executarOperacao(String operacao, ITarefaService service, Scanner scanner) throws InvalidComparacaoException, InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException, InvalidIDException, InvalidTarefaException {
        switch (operacao) {
            case "L" -> listarTarefas(service, scanner);
            case "C" -> criarTarefa(service, scanner);
            case "R" -> removerTarefa(service, scanner);
            case "A" -> atualizarTarefa(service, scanner);
            case "M" -> marcarPrioridade(service, scanner);
            case "E" -> sair();
            default -> System.out.println("Opção inválida!");
        }
    }

    private static void listarTarefas(ITarefaService service, Scanner scanner) throws InvalidComparacaoException {

        System.out.println("\nSeleciona uma opção:");
        System.out.println("(1) - Listar todas as tarefas.");
        System.out.println("(2) - Listar com base em prioridade.");
        System.out.println("(3) - Listar com base em data de vencimento.");
        System.out.println("(4) - Listar com base prioriade e depois em data de vencimento.");
        System.out.println("(5) - Listar com base em data de vencimento e depois prioridade.");
        String escolha = scanner.nextLine();

        switch(escolha) {
            case "1" -> listarTodasTarefas(service);
            case "2" -> listarTodasTarefasPrioridade(service);
            case "3" -> listarTodasTarefasDataVencimento(service);
            case "4" -> listarTodasTarefasPDDV(service);
            case "5" -> listarTodasTarefasDVDP(service);
            default -> System.out.println("Opção inválida! Retornando ao menu inicial.");
        }


    }


    private static void listarTodasTarefas(ITarefaService service) {

        List<Tarefa> resultados = service.buscarTarefas();
        for (int i = 0; i < resultados.size(); i++) {
            System.out.printf("Tarefa " + (i+1) + " --------------------------------------------\n");
            System.out.println(resultados.get(i));
            System.out.println("--------------------------------------------------\n");
        }

    }

    private static void listarTodasTarefasPrioridade(ITarefaService service) {

        List<Tarefa> resultados = service.buscarTarefasPrioridade();
        for (int i = 0; i < resultados.size(); i++) {
            System.out.printf("Tarefa " + (i+1) + " --------------------------------------------\n");
            System.out.println(resultados.get(i));
            System.out.println("--------------------------------------------------\n");
        }

    }

    private static void listarTodasTarefasDataVencimento(ITarefaService service) {

        List<Tarefa> resultados = service.buscarTarefasDataVencimento();
        for (int i = 0; i < resultados.size(); i++) {
            System.out.printf("Tarefa " + (i+1) + " --------------------------------------------\n");
            System.out.println(resultados.get(i));
            System.out.println("--------------------------------------------------\n");
        }

    }

    private static void listarTodasTarefasPDDV(ITarefaService service) throws InvalidComparacaoException {

        List<Tarefa> resultados = service.buscarTarefasOrdenadas("PRIORIDADE");
        for (int i = 0; i < resultados.size(); i++) {
            System.out.printf("Tarefa " + (i+1) + " --------------------------------------------\n");
            System.out.println(resultados.get(i));
            System.out.println("--------------------------------------------------\n");
        }

    }

    private static void listarTodasTarefasDVDP(ITarefaService service) throws InvalidComparacaoException {

        List<Tarefa> resultados = service.buscarTarefasOrdenadas("DATA_VENCIMENTO");
        for (int i = 0; i < resultados.size(); i++) {
            System.out.printf("Tarefa " + (i+1) + " --------------------------------------------\n");
            System.out.println(resultados.get(i));
            System.out.println("--------------------------------------------------\n");
        }

    }

    public static void criarTarefa(ITarefaService service, Scanner scanner) throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException {
        System.out.println("Insira o seu título da tarefa: ");
        String titulo  = scanner.nextLine();

        System.out.println("Insira a descrição da tarefa: ");
        String descricao = scanner.nextLine();

        System.out.println("Insira a data de vencimento no formato dd/mm/yyyy: ");
        String dataVencimento = scanner.nextLine();

        System.out.println("Insira a data prioridade entre ALTA/BAIXA/MÉDIA: ");
        String prioridade = scanner.nextLine();


        Tarefa resultado = service.criarTarefa(titulo, descricao, dataVencimento, prioridade);
        System.out.println("Tarefa cadastrada com sucesso! Confira os detalhes abaixo:");
        System.out.println("--------------------------------------------\n");
        System.out.println(resultado);
        System.out.println("--------------------------------------------\n");
    }


    private static void removerTarefa(ITarefaService service, Scanner scanner) throws InvalidIDException, InvalidTarefaException {

        System.out.println("Digite o ID da tarefa a qual você deseja excluir: ");
        String tarefaId = scanner.nextLine();

        service.removerTarefa(tarefaId);
        System.out.println("\nTarefa removida com sucesso!\nVoltando ao menu inicial...\n");

    }

    public static void marcarPrioridade(ITarefaService service, Scanner scanner) throws InvalidPrioridadeException, InvalidIDException, InvalidTarefaException {
        System.out.println("Digite o ID da tarefa a qual você deseja marcar prioridade: ");
        String tarefaId = scanner.nextLine();

        System.out.println("Insira a data prioridade entre ALTA/BAIXA/MÉDIA: ");
        String prioridade = scanner.nextLine();


        Tarefa resultado = service.marcarPrioridade(tarefaId, prioridade);
        System.out.println("Tarefa marcada com sucesso! Confira os detalhes abaixo:");
        System.out.println("--------------------------------------------\n");
        System.out.println(resultado);
        System.out.println("--------------------------------------------\n");
    }

    public static void atualizarTarefa(ITarefaService service, Scanner scanner) throws InvalidPrioridadeException, InvalidDataVencimentoException, InvalidDataVencimentoFormatException, InvalidDescricaoException, InvalidTituloException, InvalidIDException {
        System.out.println("Digite o ID da tarefa a qual você deseja marcar atualizar: ");
        String tarefaId = scanner.nextLine();

        System.out.println("Insira o seu título da tarefa: ");
        String titulo  = scanner.nextLine();

        System.out.println("Insira a descrição da tarefa: ");
        String descricao = scanner.nextLine();

        System.out.println("Insira a data de vencimento no formato dd/mm/yyyy: ");
        String dataVencimento = scanner.nextLine();

        System.out.println("Insira a data prioridade entre ALTA/BAIXA/MÉDIA: ");
        String prioridade = scanner.nextLine();

        TarefaPrioridade tarefaPrioridade = TarefaPrioridade.PRIORIDADE_INDEFINIDA;
        if(prioridade.equalsIgnoreCase("ALTA")) tarefaPrioridade = TarefaPrioridade.PRIORIDADE_ALTA;
        else if(prioridade.equalsIgnoreCase("MEDIA") || prioridade.equalsIgnoreCase("MÉDIA") ) tarefaPrioridade = TarefaPrioridade.PRIORIDADE_MEDIA;
        else if(prioridade.equalsIgnoreCase("BAIXA")) tarefaPrioridade = TarefaPrioridade.PRIORIDADE_BAIXA;


        Tarefa tarefa = new Tarefa(titulo, descricao, dataVencimento, tarefaPrioridade);
        Tarefa resultado = service.atualizarTarefa(tarefaId, tarefa);
        System.out.println("Tarefa atualizada com sucesso! Confira os detalhes abaixo:");
        System.out.println("--------------------------------------------\n");
        System.out.println(resultado);
        System.out.println("--------------------------------------------\n");
    }


    // Finaliza o programa
    private static void sair() {
        System.out.println("\nObrigado por utilizar os nossos serviços!");
        System.exit(0);
    }

}
