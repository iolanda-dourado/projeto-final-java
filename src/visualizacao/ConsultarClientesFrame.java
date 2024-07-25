package visualizacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarClientesFrame extends JFrame {
    private JTable tabelaClientes;
    private JButton btnConsultar;

    public ConsultarClientesFrame() {
        setTitle("Consultar Clientes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criação dos componentes
        tabelaClientes = new JTable();
        btnConsultar = new JButton("Consultar");

        // Layout e adição de componentes
        setLayout(new BorderLayout());
        add(new JScrollPane(tabelaClientes), BorderLayout.CENTER);
        add(btnConsultar, BorderLayout.SOUTH);

        // Ações do botão
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarClientes();
            }
        });
    }

    private void consultarClientes() {
        // Código para consultar clientes e atualizar a tabela
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConsultarClientesFrame().setVisible(true);
            }
        });
    }
}
