package view;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class JCalculadora extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDisplay;
	private Color corBotao;
	private Color corFundo;
	private Color corTexto;
	private Color corLinha;
	private int x;
	private int y;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCalculadora frame = new JCalculadora();
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
	public JCalculadora() {
		corBotao = new Color(70,71,74);
		corTexto = Color.white;
		corFundo = new Color(53,53,53);
		corLinha = new Color(53,53,53);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 520);
		contentPane = new JPanel();
		contentPane.setBackground(corFundo);
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		movimentarTela();
		JButton btnFechar = (criarBotao("x ", 280, 0, 40, 30));
		btnFechar.addActionListener(this);
		contentPane.add(btnFechar);
		
		textFieldDisplay = new JTextField();
		textFieldDisplay.setBorder(null);
		textFieldDisplay.setEditable(false);
		textFieldDisplay.setFont(new Font("Tahoma", Font.PLAIN,48));
		textFieldDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldDisplay.setText("0");
		textFieldDisplay.setForeground(Color.white);
		textFieldDisplay.setBounds(0,32,320,60);
		textFieldDisplay.setBackground(corFundo);
		contentPane.add(textFieldDisplay);
		textFieldDisplay.setColumns(10);
		
		JButton btnApagar = (criarBotao("C", 0, 90, 160, 80));
		btnApagar.addActionListener(this);
		contentPane.add(btnApagar);
		
		JButton btnMultiplicacao = (criarBotao("*", 160, 90, 80, 80));
		btnMultiplicacao.addActionListener(this);
		contentPane.add(btnMultiplicacao);
		
		JButton btnDivisao = (criarBotao("/", 240, 90, 80, 80));
		btnDivisao.addActionListener(this);
		contentPane.add(btnDivisao);
		
		JButton btnSubtracao = (criarBotao("-", 240, 170, 80, 80));
		btnSubtracao.addActionListener(this);
		contentPane.add(btnSubtracao);
		
		JButton btnAdicao = (criarBotao("+", 240, 250, 80, 80));
		btnAdicao.addActionListener(this);
		contentPane.add(btnAdicao);
		
		JButton btnIMC = (criarBotao("IMC", 240, 330, 80, 80));
		btnIMC.addActionListener(this);
		contentPane.add(btnIMC);
		
		JButton btnIgual = (criarBotao("=", 240, 400, 80, 80));
		btnIgual.addActionListener(this);
		contentPane.add(btnIgual);
		
		JButton btnZero = (criarBotao("0", 0, 410, 160, 80));
		btnZero.addActionListener(this);
		contentPane.add(btnZero);
	}
	private JButton criarBotao(String textoBotao, int x, int y, int width, int height) {
		JButton JButton = new JButton(textoBotao);
		JButton.setHorizontalAlignment(SwingConstants.CENTER);
		JButton.setFont(new Font("Tahoma", Font.PLAIN, textoBotao.equalsIgnoreCase("x") ? 20 : 36));
		JButton.setForeground(corTexto);
		JButton.setFocusPainted(false);
		JButton.setBackground(corBotao);
		JButton.setBorder(new LineBorder(corLinha, 2));
		JButton.setBounds(x, y, width, height);
		return JButton;
	}

	private void movimentarTela() {
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
				super.mouseDragged(e);
				
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
