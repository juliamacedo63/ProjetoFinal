package view;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class JLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JLogin frame = new JLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Tamanho fixo da janela
        setResizable(false); // Impede o redimensionamento da janela
        
        // Centraliza a janela na tela do computador
        setLocationRelativeTo(null); // Isso vai fazer a janela abrir centralizada na tela

        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 192));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(150, 100, 500, 400); // Painel centralizado
        panel.setBackground(new Color(88, 82, 160));
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 40));
        lblNewLabel.setBounds(121, 52, 258, 95);
        panel.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(158, 185, 150, 20);
        panel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Senha");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Sitka Display", Font.PLAIN, 23));
        lblNewLabel_1.setBounds(158, 216, 89, 26);
        panel.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Entrar");
        btnNewButton.setBackground(new Color(192, 192, 192));
        btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField.getText() != null && !textField.getText().isEmpty() && passwordField.getText() != null && !passwordField.getText().isEmpty()) {
                    if (new String(passwordField.getPassword()).equals("1234")) {
                        JOptionPane.showMessageDialog(btnNewButton, "Informações válidas");
                        dispose();
                        JPrincipal jPrincipal = new JPrincipal();
                        jPrincipal.setLocationRelativeTo(null);
                        jPrincipal.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "Senha incorreta!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(btnNewButton, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton.setBounds(196, 298, 112, 33);
        panel.add(btnNewButton);

        JLabel lblNewLabel_2 = new JLabel("Usuário");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Sitka Display", Font.PLAIN, 22));
        lblNewLabel_2.setBounds(131, 146, 112, 28);
        panel.add(lblNewLabel_2);

        passwordField = new JPasswordField();
        passwordField.setBounds(158, 253, 150, 20);
        panel.add(passwordField);
    }
}
