package projeto_tickets;

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
        System.out.println("|   15 - Consulta todos               |   35 Consulta parametrizada       |");
        System.out.println("|   16 - Consulta parametrizada       |   36 Consultar por tipo           |");
        System.out.println("|   17 - Consultar com ticket aberto  |   37 Consultar por datas          |");
        System.out.println("|   18 - Consultar por letra          |   38 Consultar por tipo cliente   |");
        System.out.println("|   19 - Consultar por tipo           |   39 Consultar por vencimento     |");
        System.out.println("|   20 - Eliminar Cliente por ID      |   40 Transformar em Rel, Orç, Rep |");
        System.out.println("|                                     |   41 Eliminar Ticket por ID       |");
        System.out.println("+--------------------------------------+--------------------------------- +");
        System.out.println("|   0 - Sair                                                              |");
        System.out.println("+--------------------------------------+--------------------------------- +\n");
    }

}