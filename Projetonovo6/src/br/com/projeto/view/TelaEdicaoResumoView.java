package br.com.projeto.view;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class TelaEdicaoResumoView extends JFrame {
	private String resumo, titulo;
	private JTextArea titulo_old, titulo_novo;
	private JLabel salvar, título;
	private JTextArea textArea, textArea_1;
	private TelaLeituraView view;
	public TelaEdicaoResumoView(String titulo, String resumo) {
		this.resumo = resumo;
		this.titulo = titulo;
		inicializarComponentes();
		
	}
	public void inicializarComponentes() {
		ImageIcon read7 = new ImageIcon("Imagens/LOGOBRANCAnova.png");
		setIconImage(read7.getImage());
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(487,185,1900,1080);
		setTitle("Edição de resumos");
		getContentPane().setLayout(null);

		JScrollPane pane1 = new JScrollPane();
		pane1.setBounds(62,235,590,365);
		pane1.setBorder(BorderFactory.createEmptyBorder());
		pane1.setBackground(new Color(250, 250, 250));
        getContentPane().add(pane1);

		textArea = new JTextArea();
		textArea.setText(resumo);
		textArea.setBorder(BorderFactory.createEmptyBorder());
		textArea.setBackground(new Color(237, 237, 237));
		textArea.setFont(new Font("Segoe UI Variable",Font.BOLD,20));textArea.setLineWrap(true);
		pane1.setViewportView(textArea);

		JLabel sair2 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\SairTRNew.png"));
		        sair2.setBounds(1400,0,130,113);
				getContentPane().add(sair2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		panel.setBounds(69, 220, 252, 5);
		getContentPane().add(panel);
		
		JScrollPane pane1_1 = new JScrollPane();
		pane1_1.setBounds(810, 235, 720, 365);
		pane1_1.setBorder(BorderFactory.createEmptyBorder());
		getContentPane().add(pane1_1);
		
		textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(237, 237, 237));
		textArea_1.setLineWrap(true);
		textArea_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		pane1_1.setViewportView(textArea_1);
		
		JLabel lblNewLabel = new JLabel("Resumo atual");
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 21));
		lblNewLabel.setBounds(278, 81, 153, 59);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNovoTexto = new JLabel("Novo Resumo");
		lblNovoTexto.setFont(new Font("Segoe UI Variable", Font.PLAIN, 21));
		lblNovoTexto.setBounds(1125, 81, 142, 59);
		getContentPane().add(lblNovoTexto);
		
		salvar = new JLabel();
		salvar.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Captura de tela 2023-11-07 082030.png"));
		salvar.setBounds(1101, 701, 209, 97);
		getContentPane().add(salvar);
		
		JLabel borracha = new JLabel("");
		borracha.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Captura de tela 2023-11-07 082206.png"));
		borracha.setBounds(1320, 701, 209, 97);
		getContentPane().add(borracha);
		
		titulo_old = new JTextArea();
		titulo_old.setText(titulo);
		titulo_old.setOpaque(false);
		titulo_old.setFont(new Font("Segoe UI Variable", Font.BOLD, 17));
		titulo_old.setBounds(62, 192, 252, 33);
		getContentPane().add(titulo_old);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 128, 0));
		panel_2.setBounds(1278, 220, 252, 5);
		getContentPane().add(panel_2);
		
		titulo_novo = new JTextArea("Novo Título");
		titulo_novo.setOpaque(false);
		titulo_novo.setForeground(Color.LIGHT_GRAY);
		titulo_novo.setFont(new Font("Segoe UI Variable", Font.BOLD, 17));
		titulo_novo.setBounds(1278, 192, 252, 33);
		getContentPane().add(titulo_novo);

		titulo_novo .addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (titulo_novo.getText().equals("Novo Título")) {
					titulo_novo.setText("");
					titulo_novo.setForeground(Color.black);
				}
			}

			public void focusLost(FocusEvent e) {
				if (titulo_novo.getText().isEmpty()) {
					titulo_novo.setText("Novo Título");
					titulo_novo.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-01 09164.png"));
		lblNewLabel_1.setBounds(33, 155, 651, 536);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-10-19 07540.png"));
		lblNewLabel_1_1.setBounds(779, 155, 769, 536);
		getContentPane().add(lblNewLabel_1_1);
		
		título = new JLabel("New label");
		título.setBounds(62, 182, 252, 33);
		getContentPane().add(título);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(92, 225, 230));
		panel_3.setBounds(20, 30, 27, 24);
		getContentPane().add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(56, 182, 255));
		panel_4.setBounds(47, 30, 27, 24);
		getContentPane().add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 49, 49));
		panel_5.setBounds(73, 30, 27, 24);
		getContentPane().add(panel_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 0));
		panel_1.setBounds(0, 78, 928, 2);
		getContentPane().add(panel_1);
		borracha.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textArea_1.setText("");
				
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


		sair2.addMouseListener(new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent e) {
			dispose();
			String url = "jdbc:mysql://localhost:3306/BD";
			//String titulo = 
			//TelaLeituraView view = new TelaLeituraView(Título, Resumo);
			//Connection conexao = DriverManager.getConnection(url, "root", "root");
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

		setVisible(true);
	}
	public void addBtnSalvar(MouseListener listener) {
		salvar.addMouseListener(listener);
	}
	public String getTitulo() {
		return titulo_old.getText();
	}
	public String getNewTitulo() {
		return titulo_novo.getText();
	}
	public String getTexto() {
		return textArea.getText();
	}
	public String getNewTexto() {
		return textArea_1.getText();
	}
	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
}