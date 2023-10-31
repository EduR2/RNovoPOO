package br.com.projeto.view;

import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import br.com.projeto.controller.TapSong;
import br.com.projeto.controller.TapSong2;

public class TelaBemVindoView extends JFrame {
	private ImageIcon image, image2;
	private JLabel i, i2;
	private Container container;
	public TelaBemVindoView() {
		inicializarComponentes();
	}
	public void inicializarComponentes() {
		
		TapSong2.getSong();
		setBounds(487, 185, 585, 500);
		setUndecorated(true);
		setBackground(Color.ORANGE);
		container = getContentPane();
		image = new ImageIcon("Imagens/LogoJO.png");
		image2 = new ImageIcon("Imagens/FundoBemVindo.png");
		i = new JLabel(new ImageIcon("C:\\Users\\eduar\\OneDrive\\Área de Trabalho\\ProjetoREAD7NOVO\\ProjetoREAD7\\Imagens\\LogoJO.png"));
		i.setBackground(new Color(230, 228, 242));
		getContentPane().add(i);
		setVisible(true);
		
		
		}

}