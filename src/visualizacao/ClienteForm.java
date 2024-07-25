package visualizacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteForm extends JFrame {
    private JTextField txtID;
    private JTextField txtNome;
    private JTextField txtNIF;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JButton btnSalvar;
    private JButton btnCancelar;

    public ClienteForm() {
        // Configurações da janela de formulário
        setTitle("Cadastrar Cliente");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criação dos campos e botões
        txtID = new JTextField(15);
        txtNome = new JTextField(15);
        txtNIF = new JTextField(15);
        txtTelefone = new JTextField(15);
        txtEmail = new JTextField(15);
        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");

        JPanel panel = new JPanel();
        panel.add(new JLabel("ID:"));
        panel.add(txtID);
        panel.add(new JLabel("Nome:"));
        panel.add(txtNome);
        panel.add(new JLabel("NIF:"));
        panel.add(txtNIF);
        panel.add(new JLabel("Telefone:"));
        panel.add(txtTelefone);
        panel.add(new JLabel("Email:"));
        panel.add(txtEmail);
        panel.add(btnSalvar);
        panel.add(btnCancelar);

        add(panel);

        // Ações dos botões
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para salvar cliente
                // Aqui você pode adicionar a lógica para salvar o cliente usando o código de controle
                JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
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
