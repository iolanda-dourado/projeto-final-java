package projeto_tickets;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void menuCadastroCliente() {
        System.out.println("============================================");
        System.out.println("============= GESTÃO DE CLIENTE ============");
        System.out.println("============================================");;
        System.out.println("1 - Cadastrar Cliente Final");
        System.out.println("2 - Cadastrar Cliente Revendedor");
        System.out.println("3 - Visualizar Clientes");
        System.out.println("4 - Atualizar Cliente");
        System.out.println("0 - Sair");
        System.out.println("============================================");
    }

    //boolean executar = true;

    //while (executar){
    //Este método serve para exibir menu
    public static void menuGestaoTickets(Scanner tec, GestaoCliente gestaocliente, GestaoTickets gestaoTickets) {
        System.out.println("============================================");
        System.out.println("============= GESTÃO DE TICKETS ============");
        System.out.println("============================================");
        System.out.println("1. Cadastro Cliente");
        System.out.println("2. Gestão de Tickets");
        System.out.println("3. Alteração de Estado");
        System.out.println("4. Mostrar Clientes");
        System.out.println("0. Sair");

        int opcao = tec.nextInt();

        switch (opcao){
            case 1:
                //gestaoCliente.cadastrarCliente(tec);
                break;
            case 2:
                gestaoTickets.gerirTickets(tec);
                break;
            case 3:
                gestaoTickets.alterarEstado(tec);
                break;
            case 4:
                //gestaocliente.listarClientes(tec);
                break;
            case 5:
                //executar == false;
                break;
            default:
                System.out.println("Opção inválida, Tente novamente.");
        }
    }
}