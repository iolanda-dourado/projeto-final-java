package projeto_tickets;

import java.util.ArrayList;
import java.util.Scanner;

public class GestaoTicketMain {
    public static void main(String[] args) {
        //lista para nossos clientes e tickets
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Ticket> tickets = new ArrayList<>();

        //GestaoCliente gestaoCliente = new GestaoCliente(clientes);
        GestaoTickets gestaoTickets = new GestaoTickets(tickets, clientes);

        Scanner tec = new Scanner(System.in);

        //mostra menu
        //Menu.menuGestaoTickets(tec, gestaoCliente, gestaoTickets);

        tec.close();

    }

}