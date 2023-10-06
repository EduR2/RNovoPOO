package br.com.projeto.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class EdicaoTextoADMView extends JFrame {
	private JLabel image2, image3, txt1, sair, salvar, livro1, livro2, livro3;
	private JPanel p, p1, p2;
	private JButton b, btnSalvar, btnLer, btnLimpar, btnTxt1;
	private Container container;
	private ImageIcon i1, i2, i3, i, save, clean, book1, book2, book3;
	private Font fonte = new Font("Verdana", Font.BOLD, 20);
	private Font fonte1 = new Font("Calibri", Font.BOLD, 15);
	private Font fonte2 = new Font("Verdana", Font.BOLD, 9);
	private JTextArea text;
	private JScrollPane pane1;
	private JPasswordField senha;
	private JButton btnLogin, btnCriarCadastro;
	private String texto;
	private JLabel livro1_1;
	private JLabel livro1_2;
	private JLabel info;
	private JPanel panel_3;

	public EdicaoTextoADMView() {
		inicializaComponentes();
	}

	public void inicializaComponentes() {
		setTitle("Read7");
		setBounds(0, 0, 1920, 1080);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(230, 228, 242));
		Font fontetip = new Font("Segoe UI Variable", Font.BOLD, 17);
		UIManager.put("ToolTip.font", fontetip);
		UIManager.put("ToolTip.background", (new Color(230, 228, 242)));
		b = new JButton("Voltar");
		btnSalvar = new JButton("Salvar");
		btnLer = new JButton("Ler");
		btnLimpar = new JButton("Limpar");
		btnTxt1 = new JButton("Texto 1");
		text = new JTextArea();
		senha = new JPasswordField("Senha");
		pane1 = new JScrollPane(text);
		btnLogin = new JButton("Login");
		btnCriarCadastro = new JButton("Criar");
		txt1 = new JLabel("Não possui cadastro?");
		i = new ImageIcon("Imagens/SairTR.png");
		save = new ImageIcon("Imagens/Salvar.png");
		clean = new ImageIcon("Imagens/Borracha.png");
		book1 = new ImageIcon("Imagens/livro1.png");
		book2 = new ImageIcon("Imagens/livro2.png");
		book3 = new ImageIcon("Imagens/livro3.png");
		i1 = new ImageIcon("Imagens/Fundo2.jpg");
		i2 = new ImageIcon("Imagens/Fundo1.jpg");
		i3 = new ImageIcon("Imagens/read.png");
		sair = new JLabel(i);
		salvar = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\Salvar.png"));
		livro1 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\livro1.png"));
		livro2 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\livro2.png"));
		livro3 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\livro3.png"));
		image2 = new JLabel(i2);
		image3 = new JLabel(i3);
		p = new JPanel();
		pane1.setBounds(793, 153, 590, 500);
		text.setLineWrap(true);
		senha.setBounds(597, 395, 350, 45);
		image3.setBounds(575, 65, 390, 320);
		txt1.setBounds(740, 537, 125, 20);
		p.setBounds(575, 250, 390, 315);
		sair.setBounds(1400, 0, 130, 113);
		salvar.setBounds(1393, 298, 130, 102);
		livro1.setBounds(36, 186, 100, 102);
		livro2.setBounds(36, 298, 100, 102);
		livro3.setBounds(36, 410, 100, 102);
		p.add(image2);

		btnLogin.setBackground(Color.BLUE);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(fonte);
		text.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		senha.setFont(fonte1);
		getContentPane().add(sair);
		getContentPane().add(salvar);
		getContentPane().add(livro1);
		getContentPane().add(livro2);
		getContentPane().add(livro3);
		getContentPane().add(pane1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 64));
		panel.setBounds(174, 0, 2, 845);
		getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 64));
		panel_1.setBounds(-10, 110, 1540, 2);
		getContentPane().add(panel_1);
		
		livro1.setToolTipText("Texto 1");
		livro2.setToolTipText("Texto 2");
		livro3.setToolTipText("Texto 3");
		salvar.setToolTipText("Salvar");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 128, 64));
		panel_2.setBounds(349, 110, 2, 400);
		getContentPane().add(panel_2);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 128, 64));
		panel_3.setBounds(515, 110, 2, 400);
		getContentPane().add(panel_3);
		
		JLabel livro1_3 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\livro1.png"));
		livro1_3.setToolTipText("Texto 1");
		livro1_3.setBounds(211, 186, 100, 102);
		getContentPane().add(livro1_3);
		
		JLabel livro2_1 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\livro2.png"));
		livro2_1.setToolTipText("Texto 2");
		livro2_1.setBounds(211, 298, 100, 102);
		getContentPane().add(livro2_1);
		
		JLabel livro3_1 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\livro3.png"));
		livro3_1.setToolTipText("Texto 3");
		livro3_1.setBounds(211, 410, 100, 102);
		getContentPane().add(livro3_1);
		
		JLabel livro1_3_1 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\livro1.png"));
		livro1_3_1.setToolTipText("Texto 1");
		livro1_3_1.setBounds(382, 186, 100, 102);
		getContentPane().add(livro1_3_1);
		
		JLabel livro2_1_1 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\livro2.png"));
		livro2_1_1.setToolTipText("Texto 2");
		livro2_1_1.setBounds(382, 298, 100, 102);
		getContentPane().add(livro2_1_1);
		
		JLabel livro3_1_1 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\livro3.png"));
		livro3_1_1.setToolTipText("Texto 3");
		livro3_1_1.setBounds(382, 410, 100, 102);
		getContentPane().add(livro3_1_1);
		
		JLabel lblNewLabel = new JLabel("Ação");
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		lblNewLabel.setBounds(63, 128, 45, 48);
		getContentPane().add(lblNewLabel);
		
		JLabel lblTerror = new JLabel("Terror");
		lblTerror.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		lblTerror.setBounds(233, 128, 60, 48);
		getContentPane().add(lblTerror);
		
		JLabel lblFico = new JLabel("Ficção");
		lblFico.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		lblFico.setBounds(401, 128, 60, 48);
		getContentPane().add(lblFico);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(255, 128, 64));
		panel_3_1.setBounds(675, 110, 2, 400);
		getContentPane().add(panel_3_1);
		
		JLabel livro2_1_1_1 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\livro2.png"));
		livro2_1_1_1.setToolTipText("Texto 2");
		livro2_1_1_1.setBounds(544, 298, 100, 102);
		getContentPane().add(livro2_1_1_1);
		
		JLabel livro1_3_1_1 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\livro1.png"));
		livro1_3_1_1.setToolTipText("Texto 1");
		livro1_3_1_1.setBounds(544, 186, 100, 102);
		getContentPane().add(livro1_3_1_1);
		
		JLabel livro3_1_1_1 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\livro3.png"));
		livro3_1_1_1.setToolTipText("Texto 3");
		livro3_1_1_1.setBounds(544, 410, 100, 102);
		getContentPane().add(livro3_1_1_1);
		
		JLabel lblRomance = new JLabel("Romance");
		lblRomance.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		lblRomance.setBounds(554, 128, 83, 48);
		getContentPane().add(lblRomance);
		
		sair.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}



	public void setTexto(String texto) {
		text.setText(texto);
	}

	public void addBtnPegaTxt(MouseListener listener) {
		livro1.addMouseListener(listener);
	}
	public void addBtnPegaTxt2(MouseListener listener) {
		livro2.addMouseListener(listener);
	}
	public void addBtnPegaTxt3(MouseListener listener) {
		livro3.addMouseListener(listener);
	}
	

	public void addBtnSalvar(MouseListener salvarListener) {
		salvar.addMouseListener(salvarListener);
	}

	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

	public void mostrarMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro ao logar", JOptionPane.ERROR_MESSAGE);
	}
}