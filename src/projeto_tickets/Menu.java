package projeto_tickets;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void menu() {
        System.out.println("+=======================================================================+");
        System.out.println("+                  MENU SOFTWARE DE GESTÃO DE TICKETS                   +");
        System.out.println("+=======================================================================+");
        System.out.println("+------------ CLIENTES ---------------|------------ TICKETS ------------+");
        System.out.println("|\t31 - Adicionar Cliente Final      |\t41. Registar Ticket             |");
        System.out.println("|\t32 - Cadastrar Cliente Revendedor |\t42. Alterar dados ticket        |");
        System.out.println("|\t33 - Visualizar Clientes          |\t43. Consultar ticket            |");
        System.out.println("|\t34 - Atualizar Cliente            |\t44. Eliminar ticket por ID      |");
        System.out.println("|\t35 - Eliminar Cliente por ID      |\t45. Consulta Parametrizada      |");
        System.out.println("+------------------------------------+----------------------------------+");
        System.out.println("|\t 0 - Sair                                                           |");
        System.out.println("+------------------------------------+----------------------------------+\n");
    }

}