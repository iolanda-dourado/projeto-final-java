/*package visualizacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JButton btnCadastrarCliente;
    private JButton btnConsultarClientes;
    private JButton btnCadastrarTicket;
    private JButton btnConsultarTickets;
    private JButton btnSair;

    public MainFrame() {
        // Configurações da janela principal
        setTitle("Gestão de Clientes e Tickets");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criação dos botões
        btnCadastrarCliente = new JButton("Cadastrar Cliente");
        btnConsultarClientes = new JButton("Consultar Clientes");
        btnCadastrarTicket = new JButton("Cadastrar Ticket");
        btnConsultarTickets = new JButton("Consultar Tickets");
        btnSair = new JButton("Sair");

        // Adicionando botões ao painel
        JPanel panel = new JPanel();
        panel.add(btnCadastrarCliente);
        panel.add(btnConsultarClientes);
        panel.add(btnCadastrarTicket);
        panel.add(btnConsultarTickets);
        panel.add(btnSair);

        add(panel);

        // Ações dos botões
        btnCadastrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClienteForm().setVisible(true);
            }
        });

        btnConsultarClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConsultarClientesFrame().setVisible(true);
            }
        });

        btnCadastrarTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TicketForm().setVisible(true);
            }
        });

        btnConsultarTickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConsultarTicketsFrame().setVisible(true);
            }
        });

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
*/