package br.com.projeto.view;

import javax.swing.JFrame;

public class EstatisticaView extends JFrame {
	public EstatisticaView() {
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setBounds(487, 185, 585, 500);
	}

}