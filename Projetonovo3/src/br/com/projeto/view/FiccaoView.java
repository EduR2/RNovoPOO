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
import javax.swing.UIManager;
import javax.swing.BorderFactory;
import javax.swing.Icon;

public class FiccaoView extends JFrame {
	private JLabel image2, image3, txt1, sair, salvar, limpar, livro1, livro2, livro3;
	private JPanel p, p1, p2;
	private JButton b, btnSalvar, btnLer, btnLimpar, btnTxt1;
	private Container container;
	private ImageIcon i1, i2, i3, i, save, clean, book1, book2, book3;
	private Font fonte = new Font("Verdana", Font.BOLD, 20);
	private Font fonte1 = new Font("Calibri", Font.BOLD, 15);
	private Font fonte2 = new Font("Verdana", Font.BOLD, 9);
	private JTextArea nome, text;
	private JScrollPane pane, pane1;
	private JPasswordField senha;
	private JButton btnLogin, btnCriarCadastro;
	private String texto;
	private JTextField txtA;
	private JTextField txtAutor;
	private JLabel livro1_1;
	private JLabel livro1_2;
	private JTextField classi;
	private JLabel info;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;

	public FiccaoView() {
		inicializaComponentes();
	}

	public void inicializaComponentes() {
		setTitle("Read7");
		setBounds(0, 0, 1920, 1080);
		//setUndecorated(true);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(255, 255, 255));
		Font fontetip = new Font("Segoe UI Variable", Font.BOLD, 17);
		UIManager.put("ToolTip.font", fontetip);
		UIManager.put("ToolTip.background", (new Color(230, 228, 242)));
		b = new JButton("Voltar");
		btnSalvar = new JButton("Salvar");
		btnLer = new JButton("Ler");
		btnLimpar = new JButton("Limpar");
		btnTxt1 = new JButton("Texto 1");
		nome = new JTextArea();
		nome.setBorder(BorderFactory.createEmptyBorder());
		text = new JTextArea();
		text.setBorder(BorderFactory.createEmptyBorder());
		senha = new JPasswordField("Senha");
		pane = new JScrollPane(nome);
		pane.setBorder(BorderFactory.createEmptyBorder());
		pane.setBackground(new Color(250, 250, 250));
		pane1 = new JScrollPane(text);
		pane1.setBorder(BorderFactory.createEmptyBorder());
		pane1.setBackground(getForeground());
		//pane.setBackground(new Color(219,219,219));
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

		pane.setBounds(869, 173, 650, 462);
		pane1.setBounds(175, 173, 558, 462);
		nome.setLineWrap(true);
		text.setLineWrap(true);
		senha.setBounds(597, 395, 350, 45);
		image3.setBounds(575, 65, 390, 320);
		txt1.setBounds(740, 537, 125, 20);
		p.setBounds(575, 250, 390, 315);
		sair.setBounds(1424, 48, 106, 77);
		salvar.setBounds(966, 664, 224, 102);
		limpar.setBounds(1200, 664, 197, 102);
		livro1.setBounds(321, 34, 100, 102);
		livro2.setBounds(420, 34, 100, 102);
		livro3.setBounds(530, 43, 100, 93);
		p.add(image2);

		btnLogin.setBackground(Color.BLUE);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(fonte);
		nome.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		text.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		senha.setFont(fonte1);
		
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
		getContentPane().add(pane1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 64));
		panel.setBounds(119, 46, 2, 720);
		getContentPane().add(panel);

		txtA = new JTextField();
		txtA.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		txtA.setText("Título");
		txtA.setForeground(Color.LIGHT_GRAY);
		txtA.setBounds(871, 33, 218, 50);
		txtA.setOpaque(false);
		txtA.setBorder(BorderFactory.createEmptyBorder());
		getContentPane().add(txtA);
		txtA.setColumns(10);

		txtAutor = new JTextField();
		txtAutor.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		txtAutor.setText("Autor (Seu e-mail)");
		txtAutor.setForeground(Color.LIGHT_GRAY);
		txtAutor.setColumns(10);
		txtAutor.setBounds(871, 91, 177, 45);
		txtAutor.setOpaque(false);
		txtAutor.setBorder(BorderFactory.createEmptyBorder());
		getContentPane().add(txtAutor);
		
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
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-01 09164.png"));
		lblNewLabel.setBounds(131, 139, 670, 536);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Escolha um texto: ");
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(144, 81, 218, 45);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-10-19 07540 (3).png"));
		lblNewLabel_2.setBounds(834, 135, 706, 536);
		getContentPane().add(lblNewLabel_2);
		
		JLabel Regras = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-07 090707.png"));
		Regras.setToolTipText("Regras para os resumos");
		Regras.setBounds(1268, 48, 72, 66);
		getContentPane().add(Regras);
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
		
		txtA.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (txtA.getText().equals("Título")) {
					txtA.setText("");
					txtA.setForeground(Color.black);
				}
			}

			public void focusLost(FocusEvent e) {
				if (txtA.getText().isEmpty()) {
					txtA.setText("Título");
					txtA.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtAutor.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent g) {
				if (txtAutor.getText().equals("Autor (Seu e-mail)")) {
					txtAutor.setText("");
					txtAutor.setForeground(Color.black);
				}

			}

			public void focusLost(FocusEvent e) {
				if (txtAutor.getText().isEmpty()) {
					txtAutor.setText("Autor (Seu e-mail)");
					txtAutor.setForeground(Color.LIGHT_GRAY);
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
				nome.setText("");

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
		comboBox.setBounds(1073, 100, 185, 32);
		getContentPane().add(comboBox);

		JLabel lbl2 = new JLabel("Fonte");
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl2.setBackground(new Color(230, 228, 242));
		lbl2.setBounds(1073, 76, 45, 25);
		getContentPane().add(lbl2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-07 080739.png"));
		lblNewLabel_3.setBounds(857, 23, 277, 118);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-07 081153.png"));
		lblNewLabel_3_1.setBounds(1058, 8, 218, 93);
		getContentPane().add(lblNewLabel_3_1);

		String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String fontName : fontNames) {
            comboBox.addItem(fontName);
        }


        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFont = (String) comboBox.getSelectedItem();
                Font currentFont = nome.getFont();
                nome.setFont(new Font(selectedFont, currentFont.getStyle(), currentFont.getSize()));
            }
        });
	}

	public String getTitulo() {
		return txtA.getText();
	}

	public String getTexto() {
		return nome.getText();
	}

	public String getAutor() {
		return txtAutor.getText();
	}
	
	public String getClassificacao() {
		return classi.getText();
	}

	public void setTexto(String texto) {
		text.setText(texto);
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