package br.com.projeto.view;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class TelaEdicaoResumoView extends JFrame {
	private String resumo, titulo;
	private JTextArea titulo_old, titulo_novo;
	private JLabel salvar;
	private JTextArea textArea, textArea_1;
	private TelaLeituraView view;
	public TelaEdicaoResumoView(String titulo, String resumo) {
		this.resumo = resumo;
		this.titulo = titulo;
		inicializarComponentes();
		
	}
	public void inicializarComponentes() {
		getContentPane().setBackground(new Color(230,228,242));
		setBounds(487,185,1900,1080);
		getContentPane().setLayout(null);
		
		JLabel salvar_2 = new JLabel();
		salvar_2.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\livro2.png"));
		salvar_2.setBounds(138, 634, 83, 97);
		getContentPane().add(salvar_2);
		
		JLabel salvar_3 = new JLabel();
		salvar_3.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\livro3.png"));
		salvar_3.setBounds(224, 634, 83, 97);
		getContentPane().add(salvar_3);
		
		JLabel salvar_1 = new JLabel();
		salvar_1.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\livro1.png"));
		salvar_1.setBounds(56, 634, 83, 97);
		getContentPane().add(salvar_1);

		JScrollPane pane1 = new JScrollPane();
		pane1.setBounds(65,235,590,365);
		pane1.setBackground(new Color(250, 250, 250));
        getContentPane().add(pane1);

		textArea = new JTextArea();
		textArea.setText(resumo);
		textArea.setBackground(new Color(250, 250, 250));
		textArea.setFont(new Font("Segoe UI Variable",Font.BOLD,20));textArea.setLineWrap(true);
		pane1.setViewportView(textArea);

		JLabel sair2 = new JLabel(new ImageIcon(
				"C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\Sair.png"));
		        sair2.setBounds(1420,487,130,113);
				getContentPane().add(sair2);

		JPanel panel_1 = new JPanel();panel_1.setBackground(new Color(255,128,64));panel_1.setBounds(0,131,1540,2);
		getContentPane().add(panel_1);
		
		/*JTextArea textArea_1 = new JTextArea();
		textArea_1.setText(titulo);
		textArea_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 17));
		textArea_1.setBounds(69, 45, 252, 57);
		getContentPane().add(textArea_1);*/
		
		//textArea_1.setOpaque(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		panel.setBounds(69, 220, 252, 5);
		getContentPane().add(panel);
		
		JScrollPane pane1_1 = new JScrollPane();
		pane1_1.setBounds(810, 235, 590, 365);
		getContentPane().add(pane1_1);
		
		textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		pane1_1.setViewportView(textArea_1);
		
		JLabel lblNewLabel = new JLabel("Resumo atual");
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 21));
		lblNewLabel.setBounds(79, 46, 153, 59);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNovoTexto = new JLabel("Novo Resumo");
		lblNovoTexto.setFont(new Font("Segoe UI Variable", Font.PLAIN, 21));
		lblNovoTexto.setBounds(1268, 46, 142, 59);
		getContentPane().add(lblNovoTexto);
		
		salvar = new JLabel();
		salvar.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\Salvar.png"));
		salvar.setBounds(1446, 257, 83, 97);
		getContentPane().add(salvar);
		
		JLabel borracha = new JLabel("");
		borracha.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\Borracha.png"));
		borracha.setBounds(1446, 380, 83, 97);
		getContentPane().add(borracha);
		
		titulo_old = new JTextArea();
		titulo_old.setText(titulo);
		titulo_old.setOpaque(false);
		titulo_old.setFont(new Font("Segoe UI Variable", Font.BOLD, 17));
		titulo_old.setBounds(69, 177, 252, 33);
		getContentPane().add(titulo_old);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 128, 0));
		panel_2.setBounds(1158, 220, 252, 5);
		getContentPane().add(panel_2);
		
		titulo_novo = new JTextArea();
		titulo_novo.setOpaque(false);
		titulo_novo.setFont(new Font("Segoe UI Variable", Font.BOLD, 17));
		titulo_novo.setBounds(1158, 177, 252, 33);
		getContentPane().add(titulo_novo);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Imagem.png"));
		lblNewLabel_1.setBounds(33, 155, 651, 536);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Imagem.png"));
		lblNewLabel_1_1.setBounds(779, 155, 710, 536);
		getContentPane().add(lblNewLabel_1_1);
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