package visualizacao;

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
        System.out.println("|   40 - Restaurar dados                                                  |");
        System.out.println("|    0 - Sair                                                             |");
        System.out.println("+--------------------------------------+--------------------------------- +\n");
    }
// CONSULTA PARAMETRIZADA CLIENTE:
// por ID inicial ao ID final, por tipo de cliente (F, R), por letra inicial a letra final
// Mostra tabela de acordo com as opções escolhidas


// CONSULTA PARAMETRIZADA TICKET:
// por ID inicial ao ID final, por tipo de ticket (Orç, Rel, Rep), por letra inicial a letra final, por tipo de cliente (F, R)
// Mostra tabela de acordo com as opções escolhidas


    // Método para imprimir o cabeçalho dos clientes
    public static void imprimeCabecalhoClientes() {
        System.out.printf("%-13s | %-5s | %-25s | %-11s | %-13s | %-30s | %-15s | %-20s | %-20s%n",
                "Tipo Cliente", "ID", "Nome", "NIF", "Telefone", "Email", "% Desc. Peças", "% Desc. Mão Obra", "% Desc. Pronto Pgto");
    }

    public static void imprimeCabecalhoTickets() {
        System.out.printf("%-5s | %-14s | %-29s | %-29s | %-11s | %-11s | %-10s%n",
                "ID", "Tipo Cliente", "Data Início", "Data Fim", "Descrição", "Val Serviço", "Val Peças");
    }

}


