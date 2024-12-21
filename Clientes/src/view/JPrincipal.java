package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class JPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPrincipal frame = new JPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1434, 881);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(88, 82, 160));
		panel.setBounds(231, 91, 1378, 820);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnJogoDaVelha = new JButton("Jogo da Velha");
		btnJogoDaVelha.setIcon(new ImageIcon("D:\\Aluno\\Imagens\\images.png"));
		btnJogoDaVelha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJogoDaVelha.setBounds(839, 257, 273, 252);
		panel.add(btnJogoDaVelha);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setIcon(new ImageIcon("D:\\Aluno\\Imagens\\sticker-png-math-calculator-computer-icons-squaremath-information-calculadora-service-logo-calculator-area-sales.png"));
		btnNewButton.setBounds(225, 257, 221, 197);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("CALCULADORA");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 23));
		lblNewLabel.setBounds(251, 191, 202, 58);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("JOGO DA  VELHA");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 23));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(867, 209, 201, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ESCOLHA");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 34));
		lblNewLabel_2.setBounds(640, 76, 144, 41);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("VOLTAR PARA A PÁGINA DE LOGIN");
		btnNewButton_1.setBounds(543, 518, 230, 23);
		panel.add(btnNewButton_1);
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
				btnNewButton_1.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        JLogin telaLogin = new JLogin();  
				        telaLogin.setVisible(true);        
				        dispose();                      
				    }
				});

			}
		});
		btnNewButton_1.setBackground(new Color(192, 192, 192));
	}

}
