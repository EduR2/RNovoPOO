package br.com.projeto.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.BorderFactory;
import javax.swing.Icon;

public class RomanceView extends JFrame {
	private JLabel image2, image3, txt1, sair, salvar, limpar, livro1, livro2, livro3;
	private JPanel p, p1, p2;
	private JButton b, btnSalvar, btnLer, btnLimpar, btnTxt1;
	private Container container;
	private ImageIcon i1, i2, i3, i, save, clean, book1, book2, book3;
	private Font fonte = new Font("Verdana", Font.BOLD, 20);
	private Font fonte1 = new Font("Calibri", Font.BOLD, 15);
	private Font fonte2 = new Font("Verdana", Font.BOLD, 9);
	private JTextArea resumo;
	private JScrollPane pane;
	private JPasswordField senha;
	private JButton btnLogin, btnCriarCadastro;
	private String texto;
	private JTextField título;
	private JTextField emailAutor;
	private JLabel livro1_1;
	private JLabel livro1_2;
	private JTextField classi;
	private JLabel info;
	private JLabel lblNewLabel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;

	public RomanceView() {
		inicializaComponentes();
	}

	public void inicializaComponentes() {
		setTitle("Read7");
		setBounds(0, 0, 1920, 1080);
		//setUndecorated(true);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(255, 255, 255));
		Font fontetip = new Font("Segoe UI Variable", Font.BOLD, 17);
		Font fonteBox = new Font("Segoe UI Variable", Font.BOLD, 10);
		UIManager.put("ToolTip.font", fontetip);
		UIManager.put("ToolTip.background", (new Color(230, 228, 242)));
		b = new JButton("Voltar");
		btnSalvar = new JButton("Salvar");
		btnLer = new JButton("Ler");
		btnLimpar = new JButton("Limpar");
		btnTxt1 = new JButton("Texto 1");
		resumo = new JTextArea();
		resumo.setLineWrap(true);
		resumo.setBorder(BorderFactory.createEmptyBorder());
		senha = new JPasswordField("Senha");
		pane = new JScrollPane(resumo);
		pane.setBorder(BorderFactory.createEmptyBorder());
		pane.setBackground(new Color(250, 250, 250));
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
		sair = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\SairTRNew.png"));
		salvar = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Imagens\\Capturas de tela\\Captura de tela 2023-11-07 082030.png"));
		limpar = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Imagens\\Capturas de tela\\Captura de tela 2023-11-07 082206.png"));
		livro1 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-07 081407.png"));
		livro2 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-07 081530.png"));
		livro3 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-07 081642.png"));
		image2 = new JLabel(i2);
		image3 = new JLabel(i3);
		p = new JPanel();

		pane.setBounds(225, 190, 932, 445);
		senha.setBounds(597, 395, 350, 45);
		image3.setBounds(575, 65, 390, 320);
		txt1.setBounds(740, 537, 125, 20);
		p.setBounds(575, 250, 390, 315);
		sair.setBounds(1424, 48, 106, 77);
		salvar.setBounds(911, 664, 224, 102);
		limpar.setBounds(1145, 664, 197, 102);
		livro1.setBounds(1217, 223, 100, 102);
		livro2.setBounds(1217, 348, 100, 102);
		livro3.setBounds(1217, 486, 100, 93);
		p.add(image2);

		btnLogin.setBackground(Color.BLUE);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(fonte);
		resumo.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		senha.setFont(fonte1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 64));
		panel_1.setBounds(1205, 229, 2, 350);
		getContentPane().add(panel_1);
		
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 49, 49));
		panel_5.setBounds(1503, 10, 27, 24);
		getContentPane().add(panel_5);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(56, 182, 255));
		panel_4.setBounds(1477, 10, 27, 24);
		getContentPane().add(panel_4);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(92, 225, 230));
		panel_3.setBounds(1450, 10, 27, 24);
		getContentPane().add(panel_3);
		getContentPane().add(sair);
		getContentPane().add(salvar);
		getContentPane().add(limpar);
		getContentPane().add(livro1);
		getContentPane().add(livro2);
		getContentPane().add(livro3);
		getContentPane().add(pane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 64));
		panel.setBounds(119, 46, 2, 720);
		getContentPane().add(panel);

		título = new JTextField();
		título.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		título.setText("Título");
		título.setForeground(Color.LIGHT_GRAY);
		título.setBounds(220, 96, 177, 39);
		título.setOpaque(false);
		título.setBorder(BorderFactory.createEmptyBorder());
		getContentPane().add(título);
		título.setColumns(10);

		emailAutor = new JTextField();
		emailAutor.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		emailAutor.setText("Autor (Seu e-mail)");
		emailAutor.setForeground(Color.LIGHT_GRAY);
		emailAutor.setColumns(10);
		emailAutor.setBounds(437, 93, 177, 45);
		emailAutor.setOpaque(false);
		emailAutor.setBorder(BorderFactory.createEmptyBorder());
		getContentPane().add(emailAutor);
		
		livro1.setToolTipText("Texto 1");
		livro2.setToolTipText("Texto 2");
		livro3.setToolTipText("Texto 3");
		salvar.setToolTipText("Salvar");
		limpar.setToolTipText("Limpar");
		
		classi = new JTextField("");
		classi.setForeground(Color.BLACK);
		classi.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		classi.setBounds(1084, 33, 107, 39);
		classi.setOpaque(false);
		classi.setBorder(BorderFactory.createEmptyBorder());
		getContentPane().add(classi);
		classi.setColumns(10);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-08 090106.png"));
		lblNewLabel_2.setBounds(205, 150, 1158, 519);
		getContentPane().add(lblNewLabel_2);
	
		
		título.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (título.getText().equals("Título")) {
					título.setText("");
					título.setForeground(Color.black);
				}
			}

			public void focusLost(FocusEvent e) {
				if (título.getText().isEmpty()) {
					título.setText("Título");
					título.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		emailAutor.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent g) {
				if (emailAutor.getText().equals("Autor (Seu e-mail)")) {
					emailAutor.setText("");
					emailAutor.setForeground(Color.black);
				}

			}

			public void focusLost(FocusEvent e) {
				if (emailAutor.getText().isEmpty()) {
					emailAutor.setText("Autor (Seu e-mail)");
					emailAutor.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		
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

		limpar.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				resumo.setText("");

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
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(624, 102, 100, 32);
		getContentPane().add(comboBox);
		comboBox.setBackground(new Color(219, 219, 219));
		comboBox.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-07 081153.png"));
		lblNewLabel_3_1.setBounds(415, 69, 218, 93);
		getContentPane().add(lblNewLabel_3_1);
		
		JLabel Regras = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-08 082307.png"));
		Regras.setToolTipText("Regras para os resumos");
		Regras.setBounds(734, 85, 72, 66);
		getContentPane().add(Regras);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-07 081153.png"));
		lblNewLabel_3_1_1.setBounds(205, 69, 218, 93);
		getContentPane().add(lblNewLabel_3_1_1);
		
		JLabel Bold = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-08 082130.png"));
		Bold.setToolTipText("Regras para os resumos");
		Bold.setBounds(813, 85, 72, 66);
		getContentPane().add(Bold);
		
		JLabel Italic = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-08 082440.png"));
		Italic.setToolTipText("Regras para os resumos");
		Italic.setBounds(889, 85, 72, 66);
		getContentPane().add(Italic);
		Regras.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				RegrasView view = new RegrasView();
				view.setVisible(true);
				view.setResizable(false);
				
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

		String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String fontName : fontNames) {
            comboBox.addItem(fontName);
        }


        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFont = (String) comboBox.getSelectedItem();
                Font currentFont = resumo.getFont();
                resumo.setFont(new Font(selectedFont, currentFont.getStyle(), currentFont.getSize()));
            }
        });
	}

	public String getTitulo() {
		return título.getText();
	}

	public String getTexto() {
		return resumo.getText();
	}

	public String getAutor() {
		return emailAutor.getText();
	}
	
	public String getClassificacao() {
		return classi.getText();
	}
	
	public void setClassificacao(String classif) {
		classi.setText(classif);
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

