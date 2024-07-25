package visualizacao;

import modelo.Cliente;

public class Menu {
    public static void mostraMenu() {
        System.out.println("\n+=========================================================================+");
        System.out.println("+                  |MENU| SOFTWARE DE GESTÃO DE TICKETS                   +");
        System.out.println("+=========================================================================+");
        System.out.println("+------------- CLIENTES --------------|------------ TICKETS --------------+");
        System.out.println("|   11 - Adicionar Cliente Final      |   31 Registar Ticket              |");
        System.out.println("|   12 - Adicionar Cliente Revendedor |   32 Alterar por ID               |");
        System.out.println("|   13 - Alterar por ID               |   33 Consultar por ID             |");
        System.out.println("|   14 - Consultar por ID             |   34 Consultar todos              |");
        System.out.println("|   15 - Consultar todos              |   35 Consulta parametrizada       |");
        System.out.println("|   16 - Consulta parametrizada       |   36 Consulta tickets abertos     |");  // TICKETS RELATÓRIO E ORÇAMENTO
        System.out.println("|   17 - Consultar com ticket aberto  |   37 Consulta tickets finalizados |");  // TICKETS REPARAÇÃO
        System.out.println("|   18 - Consultar com ticket fechado |   38 Alterar p/ Rel, Orç, Rep     |");
        System.out.println("|   19 - Eliminar Cliente por ID      |   39 Eliminar Ticket por ID       |");
        System.out.println("+--------------------------------------+--------------------------------- +");
        System.out.println("|    0 - Sair                                                             |");
        System.out.println("+--------------------------------------+--------------------------------- +\n");
    }


    // Método para imprimir o cabeçalho dos clientes
    public static void imprimeCabecalhoClientes() {
        System.out.println("+--------------+-------+---------------------------+-------------+---------------+------------+------------+------------+");
        System.out.printf("%-14s | %-5s | %-25s | %-11s | %-13s | %-12s | %-10s | %-10s |",
                "| Tipo Cliente", "ID", "Nome", "NIF", "Telefone", "% Desc PE", "% Desc. MO", "% Desc. PP");
        System.out.println("\n+--------------+-------+---------------------------+-------------+---------------+------------+------------+------------+");
    }

    public static void imprimeFimClientes() {
        System.out.println("+--------------+-------+---------------------------+-------------+---------------+------------+------------+------------|");
    }


    public static void imprimeCabecalhoTickets() {
        System.out.println("+-------+--------+-------------+-------------+--------------------------------+-------------+-------------+----------+--------------+------------+--------------+-----------+------------+-------------------+");
        System.out.printf("| %-5s | %-6s | %-11s | %-11s | %-30s | %-10s | %-10s | %-8s | %-12s | %-10s | %-12s | %-9s | %-10s | %-17s |%n",
                "ID", "ID Cli", "Data Início", "Data Fim", "Histórico", "Valor Serv.", "Valor Peças", "Status", "Tipo", "Aprovado", "Cia Seguro", "Cobertura", "Contato", "Email");
        System.out.println("+-------+--------+-------------+-------------+--------------------------------+-------------+-------------+----------+--------------+------------+--------------+-----------+------------+-------------------+");
    }

    public static void imprimeFimTickets() {
        System.out.println("+-------+--------+-------------+-------------+--------------------------------+-------------+-------------+----------+--------------+------------+--------------+-----------+------------+-------------------+");
    }

}


