package visualizacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketForm extends JFrame {
    private JTextField txtID;
    private JTextField txtIDCliente;
    private JTextField txtDescricao;
    private JTextField txtValorServicos;
    private JTextField txtValorPecas;
    private JButton btnSalvar;
    private JButton btnCancelar;

    public TicketForm() {
        // Configurações da janela de formulário
        setTitle("Cadastrar Ticket");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criação dos campos e botões
        txtID = new JTextField(15);
        txtIDCliente = new JTextField(15);
        txtDescricao = new JTextField(15);
        txtValorServicos = new JTextField(15);
        txtValorPecas = new JTextField(15);
        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");

        JPanel panel = new JPanel();
        panel.add(new JLabel("ID:"));
        panel.add(txtID);
        panel.add(new JLabel("ID Cliente:"));
        panel.add(txtIDCliente);
        panel.add(new JLabel("Descrição:"));
        panel.add(txtDescricao);
        panel.add(new JLabel("Valor Serviços:"));
        panel.add(txtValorServicos);
        panel.add(new JLabel("Valor Peças:"));
        panel.add(txtValorPecas);
        panel.add(btnSalvar);
        panel.add(btnCancelar);

        add(panel);

        // Ações dos botões
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para salvar ticket
                // Aqui você pode adicionar a lógica para salvar o ticket usando o código de controle
                JOptionPane.showMessageDialog(null, "Ticket salvo com sucesso!");
                dispose();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}