package br.com.projeto.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import br.com.projeto.controller.TapSong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import br.com.projeto.controller.GenerosController;
import br.com.projeto.controller.TerrorController;
import br.com.projeto.controller.FiccaoController;
import br.com.projeto.controller.RomanceController;
import javax.swing.ImageIcon;

public class GenerosView extends JFrame {
	public GenerosView() {
		inicializarComponentes();
	}
	public void inicializarComponentes() {
		setBounds(200,260, 1155, 276);
		//setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel l1 = new JLabel("New label");
		l1.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\acao.png"));
		l1.setBounds(21, 10, 218, 205);
		getContentPane().add(l1);
		
		JLabel l2 = new JLabel("New label");
		l2.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Terror.png"));
		l2.setBounds(266, 10, 218, 205);
		getContentPane().add(l2);
		
		JLabel l3 = new JLabel("New label");
		l3.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Ficção.png"));
		l3.setBounds(509, 10, 218, 205);
		getContentPane().add(l3);
		
		JLabel l4 = new JLabel("New label");
		l4.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Romance.png"));
		l4.setBounds(752, 10, 218, 205);
		getContentPane().add(l4);
		
		l1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				TapSong.getSong();
				AcaoView view = new AcaoView();
				String url = "jdbc:mysql://localhost:3306/BD";
				Connection conexao = DriverManager.getConnection(url, "root", "root");
				GenerosController controller = new GenerosController(view, conexao);
				view.setVisible(true);
				view.setExtendedState(JFrame.MAXIMIZED_BOTH);
				}catch(SQLException sqle) {}

			}

			@Override
			public void mousePressed(MouseEvent e) {
				setForeground(Color.ORANGE);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				setForeground(Color.ORANGE);
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
		l2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				TapSong.getSong();	
				TerrorView view = new TerrorView();
				String url = "jdbc:mysql://localhost:3306/BD";
				Connection conexao = DriverManager.getConnection(url, "root", "root");
				TerrorController controller = new TerrorController(view, conexao);
				view.setVisible(true);
				view.setExtendedState(JFrame.MAXIMIZED_BOTH);
				}catch(SQLException sqle) {}

			}

			@Override
			public void mousePressed(MouseEvent e) {
				setForeground(Color.ORANGE);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				setForeground(Color.ORANGE);
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
		l3.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				TapSong.getSong();	
				FiccaoView view = new FiccaoView();
				String url = "jdbc:mysql://localhost:3306/BD";
				Connection conexao = DriverManager.getConnection(url, "root", "root");
				FiccaoController controller = new FiccaoController(view, conexao);
				view.setVisible(true);
				view.setExtendedState(JFrame.MAXIMIZED_BOTH);
				}catch(SQLException sqle) {}

			}

			@Override
			public void mousePressed(MouseEvent e) {
				setForeground(Color.ORANGE);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				setForeground(Color.ORANGE);
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
		l4.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				TapSong.getSong();	
				RomanceView view = new RomanceView();
				String url = "jdbc:mysql://localhost:3306/BD";
				Connection conexao = DriverManager.getConnection(url, "root", "root");
				RomanceController controller = new RomanceController(view, conexao);
				view.setVisible(true);
				view.setExtendedState(JFrame.MAXIMIZED_BOTH);
				}catch(SQLException sqle) {}

			}

			@Override
			public void mousePressed(MouseEvent e) {
				setForeground(Color.ORANGE);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				setForeground(Color.ORANGE);
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
		
		JLabel sair = new JLabel("");
		sair.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Sair.png"));
		sair.setBounds(1034, 73, 70, 92);
		getContentPane().add(sair);
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

		
		
	}
}
