package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class imc extends JFrame {
    private JTextField textFieldAltura;  // Campo para a altura
    private JTextField textFieldPeso;    // Campo para o peso
    private JTextField textFieldIdade;   // Campo para a idade
    private JLabel lblResultado;   
    private JLabel msgerro;
    
    // Label para mostrar o IMC
    private String sexoSelecionado = ""; // Variável para armazenar o sexo selecionado

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    imc frame = new imc();
                    frame.setVisible(true);
                    frame.setSize(500, 500); // Tamanho fixo da janela
                    frame.setLocationRelativeTo(null);  // Centraliza a janela na tela
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public imc() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Centraliza a janela
        setSize(500, 500);  // Tamanho fixo da janela
        setResizable(false);  // Impede redimensionar a janela
        
        getContentPane().setBackground(new Color(128, 128, 192));
        getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Selecione o Sexo");
        lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(118, 11, 239, 41);
        getContentPane().add(lblNewLabel);
        
        JButton btnFeminino = new JButton("Feminino");
        btnFeminino.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnFeminino.setBackground(new Color(255, 128, 192));
        btnFeminino.setBounds(118, 63, 99, 23);
        getContentPane().add(btnFeminino);
        
        JButton btnMasculino = new JButton("Masculino");
        btnMasculino.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnMasculino.setBackground(new Color(0, 128, 255));
        btnMasculino.setBounds(245, 63, 112, 23);
        getContentPane().add(btnMasculino);
        
        // Ação para o botão Feminino
        btnFeminino.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sexoSelecionado = "Feminino";  // Define o sexo como feminino
                btnMasculino.setEnabled(false); // Desativa o botão "Masculino"
                btnFeminino.setEnabled(false);  // Desativa o botão "Feminino"
            }
        });
        
        // Ação para o botão Masculino
        btnMasculino.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sexoSelecionado = "Masculino";  // Define o sexo como masculino
                btnMasculino.setEnabled(false); // Desativa o botão "Masculino"
                btnFeminino.setEnabled(false);  // Desativa o botão "Feminino"
            }
        });
        
        JLabel lblNewLabel_1 = new JLabel("Idade:");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(191, 97, 89, 25);
        getContentPane().add(lblNewLabel_1);
        
        textFieldIdade = new JTextField();
        textFieldIdade.setBounds(164, 133, 142, 20);
        getContentPane().add(textFieldIdade);
        textFieldIdade.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Altura:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(198, 171, 69, 23);
        getContentPane().add(lblNewLabel_2);
        
        textFieldAltura = new JTextField();
        textFieldAltura.setColumns(10);
        textFieldAltura.setBounds(164, 205, 142, 20);
        getContentPane().add(textFieldAltura);
        
        JLabel lblNewLabel_2_1 = new JLabel("Peso:");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_2_1.setBounds(201, 236, 69, 23);
        getContentPane().add(lblNewLabel_2_1);
        
        textFieldPeso = new JTextField();
        textFieldPeso.setColumns(10);
        textFieldPeso.setBounds(164, 264, 142, 20);
        getContentPane().add(textFieldPeso);
        
        JButton btnNewButton_2 = new JButton("Limpar");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldIdade.setText("");
                textFieldAltura.setText("");
                textFieldPeso.setText("");
                lblResultado.setText(""); // Limpa o resultado
                sexoSelecionado = ""; // Limpa a seleção de sexo
                btnMasculino.setEnabled(true); // Reativa os botões de sexo
                btnFeminino.setEnabled(true); 
            }
        });
        btnNewButton_2.setBounds(77, 313, 89, 23);
        getContentPane().add(btnNewButton_2);
        
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(299, 313, 89, 23);
        getContentPane().add(btnCalcular);
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sexoSelecionado.isEmpty()) {
                	JOptionPane.showMessageDialog(msgerro, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return; // Se o sexo não for selecionado, não realiza o cálculo
                }
                
                try {
                    double altura = Double.parseDouble(textFieldAltura.getText());  // Converte a altura
                    double peso = Double.parseDouble(textFieldPeso.getText());      // Converte o peso
                    
                    double imc = peso / (altura * altura);  // Cálculo do IMC
                    
                    // Classificação do IMC baseada no sexo
                    String classificacao = "";
                    if (sexoSelecionado.equals("Feminino")) {
                        if (imc < 18.5) {
                            classificacao = "Abaixo do peso";
                            lblResultado.setForeground(new Color(255, 128, 128)); // Cor vermelha clara
                        } else if (imc >= 18.5 && imc < 24.9) {
                            classificacao = "Peso normal";
                            lblResultado.setForeground(Color.GREEN); // Cor verde
                        } else if (imc >= 25 && imc < 30) {
                            classificacao = "Sobrepeso";
                            lblResultado.setForeground(Color.ORANGE); // Cor laranja
                        } else {
                            classificacao = "Obesidade";
                            lblResultado.setForeground(Color.RED); // Cor vermelha
                        }
                    } else if (sexoSelecionado.equals("Masculino")) {
                        if (imc < 18.5) {
                            classificacao = "Abaixo do peso";
                            lblResultado.setForeground(new Color(255, 128, 128)); // Cor vermelha clara
                        } else if (imc >= 18.5 && imc < 24.9) {
                            classificacao = "Peso normal";
                            lblResultado.setForeground(Color.GREEN); // Cor verde
                        } else if (imc >= 25 && imc < 29.9) {
                            classificacao = "Sobrepeso";
                            lblResultado.setForeground(Color.ORANGE); // Cor laranja
                        } else {
                            classificacao = "Obesidade";
                            lblResultado.setForeground(Color.RED); // Cor vermelha
                        }
                    }
                    
                    lblResultado.setText(String.format("IMC: %.2f - %s", imc, classificacao));
                } catch (NumberFormatException ex) {
                	JOptionPane.showMessageDialog(msgerro, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        lblResultado = new JLabel("");
        lblResultado.setForeground(new Color(0, 0, 0));
        lblResultado.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
        lblResultado.setBounds(87, 356, 298, 71);
        getContentPane().add(lblResultado);
    }
}
