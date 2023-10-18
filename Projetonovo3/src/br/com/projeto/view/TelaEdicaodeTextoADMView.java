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

public class TelaEdicaodeTextoADMView extends JFrame {
	private String Texto;
	private JLabel salvar;
	private JTextArea textArea, textArea_1;
	public TelaEdicaodeTextoADMView (String Texto) {
		this.Texto = Texto;
		inicializarComponentes();
		
	}
	public void inicializarComponentes() {
		getContentPane().setBackground(new Color(230,228,242));
		setBounds(487,185,1900,1080);
		getContentPane().setLayout(null);

		JScrollPane pane1 = new JScrollPane();
		pane1.setBounds(69,235,590,365);
        getContentPane().add(pane1);

		textArea = new JTextArea();
		textArea.setText(Texto);
		textArea.setOpaque(false);
		textArea.setFont(new Font("Segoe UI Variable",Font.BOLD,20));textArea.setLineWrap(true);
		pane1.setViewportView(textArea);

		JLabel sair2 = new JLabel(new ImageIcon(
				"C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\Sair.png"));
		        sair2.setBounds(1400,8,130,113);
				getContentPane().add(sair2);

		JPanel panel_1 = new JPanel();panel_1.setBackground(new Color(255,128,64));panel_1.setBounds(0,131,1540,2);
		getContentPane().add(panel_1);
		
		JScrollPane pane1_1 = new JScrollPane();
		pane1_1.setBounds(820, 235, 590, 365);
		getContentPane().add(pane1_1);
		
		textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		pane1_1.setViewportView(textArea_1);
		
		JLabel lblNewLabel = new JLabel("Texto atual");
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 21));
		lblNewLabel.setBounds(317, 166, 119, 59);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNovoTexto = new JLabel("Novo Texto");
		lblNovoTexto.setFont(new Font("Segoe UI Variable", Font.PLAIN, 21));
		lblNovoTexto.setBounds(1064, 166, 119, 59);
		getContentPane().add(lblNovoTexto);
		
		salvar = new JLabel();
		salvar.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\Salvar.png"));
		salvar.setBounds(1204, 617, 83, 97);
		getContentPane().add(salvar);
		
		JLabel borracha = new JLabel("");
		borracha.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\Borracha.png"));
		borracha.setBounds(1327, 617, 83, 97);
		getContentPane().add(borracha);
		
		JLabel salvar_1 = new JLabel();
		salvar_1.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\livro1.png"));
		salvar_1.setBounds(71, 635, 83, 97);
		getContentPane().add(salvar_1);
		
		JLabel salvar_2 = new JLabel();
		salvar_2.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\livro2.png"));
		salvar_2.setBounds(115, 635, 83, 97);
		getContentPane().add(salvar_2);
		
		JLabel salvar_3 = new JLabel();
		salvar_3.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\livro3.png"));
		salvar_3.setBounds(164, 635, 83, 97);
		getContentPane().add(salvar_3);
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
	public void addBtnSalvar(MouseListener listener) {
		salvar.addMouseListener(listener);
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