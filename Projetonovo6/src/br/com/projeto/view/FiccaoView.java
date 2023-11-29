package br.com.projeto.view;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
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
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.itextpdf.text.FontFactory;

import br.com.projeto.controller.LimitadorController;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JCheckBox;

public class FiccaoView extends JFrame {
	private JLabel image2, image3, txt1, sair, salvar, limpar, livro1, livro2, livro3, Bold;
	private JPanel p, p1, p2;
	private JButton b, btnSalvar, btnLer, btnLimpar, btnTxt1;
	private Container container;
	private ImageIcon i1, i2, i3, i, save, clean, book1, book2, book3;
	private Font fonte = new Font("Verdana", Font.BOLD, 20);
	private Font fonte1 = new Font("Calibri", Font.BOLD, 15);
	private Font fonte2 = new Font("Verdana", Font.BOLD, 9);
	private JTextArea resumo;
	private JScrollPane pane;
	private JButton btnLogin, btnCriarCadastro;
	private String texto;
	private JTextField título;
	private JTextField emailAutor;
	private JLabel livro1_1;
	private JLabel livro1_2;
	private JTextField classificação;
	private JLabel info;
	private JLabel lblNewLabel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JComboBox fonteResumo;
	private JLabel AbrirR;
	private JLabel lblNewLabel_3_1_2;
	private JTextField fonteEditável;
	private JButton aumentaFonte;
	private JButton diminuiFonte;
	private JCheckBox NegritoBox, ItálicoBox;
	private int tamanho = 20;

	public FiccaoView() {
		inicializaComponentes();
	}

	public void inicializaComponentes() {
		LimitadorController documentoLimitado = new LimitadorController();
		ImageIcon read7 = new ImageIcon("Imagens/LOGOBRANCAnova.png");
		setIconImage(read7.getImage());
		setTitle("Read7 - Resumo Ficção");
		setBounds(0, 0, 1920, 1080);
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
		pane = new JScrollPane(resumo);
		pane.setBounds(225, 190, 932, 445);
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
		sair = new JLabel(new ImageIcon(
				"C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\SairTRNew.png"));
		sair.setBounds(1424, 48, 106, 77);
		salvar = new JLabel(new ImageIcon(
				"C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Captura de tela 2023-11-07 082030.png"));
		salvar.setBounds(911, 664, 224, 102);
		limpar = new JLabel(new ImageIcon(
				"C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Captura de tela 2023-11-07 082206.png"));
		limpar.setBounds(1145, 664, 197, 102);
		livro1 = new JLabel(new ImageIcon(
				"C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-07 081407.png"));
		livro1.setBounds(1217, 223, 100, 102);
		livro2 = new JLabel(new ImageIcon(
				"C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-07 081530.png"));
		livro2.setBounds(1217, 348, 100, 102);
		livro3 = new JLabel(new ImageIcon(
				"C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-07 081642.png"));
		livro3.setBounds(1217, 486, 100, 93);
		image2 = new JLabel(i2);
		image3 = new JLabel(i3);
		p = new JPanel();
		image3.setBounds(575, 65, 390, 320);
		txt1.setBounds(740, 537, 125, 20);
		p.setBounds(575, 250, 390, 315);
		p.add(image2);

		btnLogin.setBackground(Color.BLUE);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(fonte);
		resumo.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		getContentPane().setLayout(null);

		ItálicoBox = new JCheckBox("");
		ItálicoBox.setOpaque(false);
		ItálicoBox.setBounds(1112, 125, 27, 21);
		getContentPane().add(ItálicoBox);

		JLabel Italic = new JLabel(new ImageIcon(
				"C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-08 082440.png"));
		Italic.setBounds(1063, 82, 72, 66);
		Italic.setToolTipText("Itálico");
		getContentPane().add(Italic);

		NegritoBox = new JCheckBox("");
		NegritoBox.setBounds(1035, 125, 27, 21);
		NegritoBox.setOpaque(false);
		getContentPane().add(NegritoBox);
		NegritoBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Font atualFonte = resumo.getFont();
				if (NegritoBox.isSelected() == true) {
					resumo.setFont(new Font(atualFonte.getFontName(), atualFonte.BOLD, atualFonte.getSize()));
				} else if (NegritoBox.isSelected() == false) {
					resumo.setFont(new Font(atualFonte.getFontName(), atualFonte.PLAIN, atualFonte.getSize()));
				}
			}

		});

		fonteEditável = new JTextField();
		fonteEditável.setBounds(883, 98, 51, 33);
		String tamanhoString = Integer.toString(tamanho);
		fonteEditável.setText(tamanhoString);
		fonteEditável.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		getContentPane().add(fonteEditável);
		fonteEditável.setColumns(10);

		diminuiFonte = new JButton("");
		diminuiFonte.setBounds(840, 92, 43, 39);
		diminuiFonte.setOpaque(false);
		diminuiFonte.setContentAreaFilled(false);
		diminuiFonte.setBorderPainted(false);
		getContentPane().add(diminuiFonte);
		diminuiFonte.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int size = 0;
				size++;
				tamanho = tamanho - size;
				String tamanhoString = Integer.toString(tamanho);
				fonteEditável.setText(tamanhoString);
				Font atualFonte = resumo.getFont();
				resumo.setFont(new Font(atualFonte.getFontName(), atualFonte.getStyle(), tamanho));
			}

		});

		aumentaFonte = new JButton("");
		aumentaFonte.setBounds(931, 92, 43, 39);
		aumentaFonte.setOpaque(false);
		aumentaFonte.setContentAreaFilled(false);
		aumentaFonte.setBorderPainted(false);
		getContentPane().add(aumentaFonte);
		aumentaFonte.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int size = 0;
				size++;
				tamanho = tamanho + size;
				String tamanhoString = Integer.toString(tamanho);
				fonteEditável.setText(tamanhoString);
				Font atualFonte = resumo.getFont();
				resumo.setFont(new Font(atualFonte.getFontName(), atualFonte.getStyle(), tamanho));
			}

		});

		JLabel Regras = new JLabel(new ImageIcon(
				"C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-08 082307.png"));
		Regras.setBounds(1135, 82, 72, 66);
		Regras.setToolTipText("Regras para os resumos");
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
		Bold = new JLabel(new ImageIcon(
				"C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-08 082130.png"));
		Bold.setBounds(990, 82, 72, 66);
		Bold.setToolTipText("Negrito");
		getContentPane().add(Bold);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1205, 229, 2, 350);
		panel_1.setBackground(new Color(255, 128, 64));
		getContentPane().add(panel_1);

		panel_5 = new JPanel();
		panel_5.setBounds(1503, 10, 27, 24);
		panel_5.setBackground(new Color(255, 49, 49));
		getContentPane().add(panel_5);

		panel_4 = new JPanel();
		panel_4.setBounds(1477, 10, 27, 24);
		panel_4.setBackground(new Color(56, 182, 255));
		getContentPane().add(panel_4);

		panel_3 = new JPanel();
		panel_3.setBounds(1450, 10, 27, 24);
		panel_3.setBackground(new Color(92, 225, 230));
		getContentPane().add(panel_3);
		getContentPane().add(sair);
		getContentPane().add(salvar);
		getContentPane().add(limpar);
		getContentPane().add(livro1);
		getContentPane().add(livro2);
		getContentPane().add(livro3);
		getContentPane().add(pane);

		JPanel panel = new JPanel();
		panel.setBounds(119, 46, 2, 720);
		panel.setBackground(new Color(255, 128, 64));
		getContentPane().add(panel);

		título = new JTextField();
		título.setBounds(220, 92, 177, 39);
		título.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		título.setText("Título");
		título.setToolTipText("Dê um título ao seu resumo");
		título.setForeground(Color.LIGHT_GRAY);
		título.setOpaque(false);
		título.setBorder(BorderFactory.createEmptyBorder());
		getContentPane().add(título);
		título.setColumns(10);

		emailAutor = new JTextField();
		emailAutor.setBounds(437, 89, 177, 45);
		emailAutor.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		emailAutor.setText("Autor (Seu e-mail)");
		emailAutor.setToolTipText("Coloque seu e-mail");
		emailAutor.setForeground(Color.LIGHT_GRAY);
		emailAutor.setColumns(10);
		emailAutor.setOpaque(false);
		emailAutor.setBorder(BorderFactory.createEmptyBorder());
		getContentPane().add(emailAutor);

		livro1.setToolTipText("Texto 1");
		livro2.setToolTipText("Texto 2");
		livro3.setToolTipText("Texto 3");
		salvar.setToolTipText("Salvar");
		limpar.setToolTipText("Limpar");

		classificação = new JTextField("Ficção");
		classificação.setBounds(1287, 90, 72, 56);
		classificação.setForeground(Color.BLACK);
		classificação.setFont(new Font("Segoe UI Variable", Font.PLAIN, 25));
		classificação.setOpaque(false);
		classificação.setBorder(BorderFactory.createEmptyBorder());
		getContentPane().add(classificação);
		classificação.setColumns(10);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(205, 150, 1158, 519);
		lblNewLabel_2.setIcon(new ImageIcon(
				"C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-08 090106.png"));
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
		fonteResumo = new JComboBox();
		fonteResumo.setBounds(643, 95, 170, 37);
		getContentPane().add(fonteResumo);
		fonteResumo.setOpaque(false);
		fonteResumo.setToolTipText("Defina a fonte");
		fonteResumo.setBackground(Color.WHITE);
		fonteResumo.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(415, 65, 218, 93);
		lblNewLabel_3_1.setIcon(new ImageIcon(
				"C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-07 081153.png"));
		getContentPane().add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setBounds(205, 65, 218, 93);
		lblNewLabel_3_1_1.setIcon(new ImageIcon(
				"C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-07 081153.png"));
		getContentPane().add(lblNewLabel_3_1_1);

		String[] fontNames = { "COURIER", "HELVETICA", "SYMBOL", "TIMES_ROMAN", "UNDEFINED", "ZAPFDINGBATS" };
		for (String fontName : fontNames) {
			fonteResumo.addItem(fontName);
		}

		fonteResumo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedFont = (String) fonteResumo.getSelectedItem();
				Font currentFont = resumo.getFont();
				resumo.setFont(new Font(selectedFont, currentFont.getStyle(), currentFont.getSize()));
			}
		});
		AbrirR = new JLabel("");
		AbrirR.setBounds(1324, 80, 86, 66);
		AbrirR.setIcon(new ImageIcon(
				"C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\ProjetoNovo6\\Imagens\\AbrirResum.png"));
		getContentPane().add(AbrirR);

		JLabel Regras_1 = new JLabel(new ImageIcon(
				"C:\\Users\\pwneg\\OneDrive\\Imagens\\Capturas de tela\\Captura de tela 2023-11-22 165708.png"));
		Regras_1.setBounds(840, 82, 137, 66);
		Regras_1.setToolTipText("Aumente / diminua a fonte");
		getContentPane().add(Regras_1);

		lblNewLabel_3_1_2 = new JLabel("");
		lblNewLabel_3_1_2.setBounds(624, 65, 218, 93);
		lblNewLabel_3_1_2.setIcon(new ImageIcon(
				"C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Captura de tela 2023-11-07 081153.png"));
		getContentPane().add(lblNewLabel_3_1_2);

		JLabel Rascunho = new JLabel(new ImageIcon(
				"C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Captura de tela 2023-11-27 184752.png"));
		Rascunho.setToolTipText("Rascunho");
		Rascunho.setBounds(1205, 69, 72, 93);
		Rascunho.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				AbrirRView view2 = new AbrirRView();
				view2.setVisible(true);
				view2.setLocationRelativeTo(null);

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
		getContentPane().add(Rascunho);
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
		return classificação.getText();
	}

	public void setClassificacao(String classif) {
		classificação.setText(classif);
	}

	public Font getFont() {
		return resumo.getFont();
	}

	public String getFonteName() {
		return (String) fonteResumo.getSelectedItem();
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

	public boolean getSelectNegrito() {
		if (NegritoBox.isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean getSelectItalico() {
		if (ItálicoBox.isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

	public void mostrarMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro ao logar", JOptionPane.ERROR_MESSAGE);
	}
}
