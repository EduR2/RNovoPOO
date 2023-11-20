package br.com.projeto.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import br.com.projeto.controller.EdiçãoResumosController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Icon;

public class TelaLeituraView extends JFrame {
	private String Resumo;
	private String titulo;
	private String emailtxt;
	private JTextArea textArea, textArea_1, email;
	private JLabel download;

	public TelaLeituraView(String titulo, String Resumo, String email) {
		this.titulo = titulo;
		this.Resumo = Resumo;
		this.emailtxt = email;
		inicializarComponentes();

	}

	public void inicializarComponentes() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(200, 50, 1150, 750);
		getContentPane().setLayout(null);

		JScrollPane pane1 = new JScrollPane();
		pane1.setBounds(51, 126, 1075, 445);
		pane1.setBorder(BorderFactory.createEmptyBorder());
		pane1.setBackground(new Color(250, 250, 250));
		pane1.setOpaque(false);
		getContentPane().add(pane1);

		textArea = new JTextArea();
		textArea.setBackground(new Color(250, 250, 250));
		textArea.setText(Resumo);
		textArea.setBorder(BorderFactory.createEmptyBorder());
		textArea.setOpaque(false);
		textArea.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		textArea.setLineWrap(true);
		pane1.setViewportView(textArea);

		JLabel sair2 = new JLabel(
				new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\SaídaRegras.png"));
		sair2.setBounds(780, 10, 94, 89);
		getContentPane().add(sair2);

		textArea_1 = new JTextArea();
		textArea_1.setText(titulo);
		textArea_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 17));
		textArea_1.setBounds(79, 39, 252, 57);
		getContentPane().add(textArea_1);

		textArea_1.setOpaque(false);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		panel.setBounds(69, 75, 252, 2);
		getContentPane().add(panel);

		JLabel lblDesejaEditarSeu = new JLabel("Deseja editar seu resumo?");
		lblDesejaEditarSeu.setFont(new Font("Segoe UI Variable", Font.PLAIN, 17));
		lblDesejaEditarSeu.setBounds(40, 624, 207, 42);
		getContentPane().add(lblDesejaEditarSeu);

		JLabel lblCliqueAqui = new JLabel("Clique aqui");
		lblCliqueAqui.setForeground(new Color(0, 0, 255));
		lblCliqueAqui.setFont(new Font("Segoe UI Variable", Font.PLAIN, 17));
		lblCliqueAqui.setBounds(245, 624, 94, 42);
		getContentPane().add(lblCliqueAqui);
		
		download = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Download.png"));
		download.setBounds(708, 26, 77, 51);
		getContentPane().add(download);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Captura de tela 2023-11-08 090106.png"));
		lblNewLabel.setBounds(25, 80, 1111, 534);
		getContentPane().add(lblNewLabel);
		
		email = new JTextArea();
		email.setText(emailtxt);
		email.setOpaque(false);
		email.setFont(new Font("Segoe UI Variable", Font.BOLD, 17));
		email.setBounds(341, 39, 252, 57);
		getContentPane().add(email);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 0));
		panel_1.setBounds(341, 75, 252, 2);
		getContentPane().add(panel_1);
		lblCliqueAqui.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				dispose();
				TelaEdicaoResumoView view = new TelaEdicaoResumoView(titulo, Resumo);
				String url = "jdbc:mysql://localhost:3306/BD";
				Connection conexao = DriverManager.getConnection(url, "root", "root");
				EdiçãoResumosController controle = new EdiçãoResumosController(view, conexao);
				view.setVisible(true);
				view.setExtendedState(JFrame.MAXIMIZED_BOTH);
				}catch(SQLException sqle) {}
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

		setResizable(false);

		sair2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
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

	public String pegaTitutlo() {
		return textArea_1.getText();
	}

	public String pegaResumo() {
		return textArea.getText();
	}
	public String pegaAutor() {
		return email.getText();
	}

	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
	public void addBtnDownload(MouseListener listener) {
		download.addMouseListener(listener);
	}
}