package projeto_tickets;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void menu() {
        System.out.println("\n+=======================================================================+");
        System.out.println("+                  MENU SOFTWARE DE GESTÃO DE TICKETS                   +");
        System.out.println("+=======================================================================+");
        System.out.println("+------------- CLIENTES ---------------|------------ TICKETS -----------+");
        System.out.println("|    31 - Adicionar Cliente Final      |    41. Registar Ticket         |");
        System.out.println("|    32 - Adicionar Cliente Revendedor |    42. Alterar dados ticket    |");
        System.out.println("|    33 - Visualizar Clientes          |    43. Consultar ticket        |");
        System.out.println("|    34 - Atualizar Cliente            |    44. Eliminar ticket por ID  |");
        System.out.println("|    35 - Eliminar Cliente por ID      |    45. Consulta Parametrizada  |");
        System.out.println("+------------------------------------+----------------------------------+");
        System.out.println("|\t 0 - Sair                                                           |");
        System.out.println("+------------------------------------+----------------------------------+\n");
    }

}