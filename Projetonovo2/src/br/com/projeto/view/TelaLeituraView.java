package br.com.projeto.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TelaLeituraView extends JFrame {
	private String Resumo;
	private String titulo;
	public TelaLeituraView(String titulo, String Resumo) {
		this.titulo = titulo;
		this.Resumo = Resumo;
		inicializarComponentes();
		
	}
	public void inicializarComponentes() {
		getContentPane().setBackground(new Color(230,228,242));
		setBounds(487,185,744,571);
		getContentPane().setLayout(null);

		JScrollPane pane1 = new JScrollPane();
		pane1.setBounds(69,159,590,365);
        getContentPane().add(pane1);

		JTextArea textArea = new JTextArea();textArea.setText(Resumo);
		textArea.setFont(new Font("Segoe UI Variable",Font.BOLD,20));textArea.setLineWrap(true);
		pane1.setViewportView(textArea);

		JLabel sair2 = new JLabel(new ImageIcon(
				"C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\Sair.png"));
		        sair2.setBounds(590,8,130,113);
				getContentPane().add(sair2);

		JPanel panel_1 = new JPanel();panel_1.setBackground(new Color(255,128,64));panel_1.setBounds(0,131,1540,2);
		getContentPane().add(panel_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText(titulo);
		textArea_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 17));
		textArea_1.setBounds(69, 45, 252, 57);
		getContentPane().add(textArea_1);
		
		textArea_1.setOpaque(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		panel.setBounds(69, 75, 252, 5);
		getContentPane().add(panel);

		setResizable(false);

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
}