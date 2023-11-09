package br.com.projeto.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class EstatisticasView extends JFrame {
	private int numUsers, numResum;
	private JTextField textField;
	private JTextField RF;
	public EstatisticasView(int numUsers, int numResum) {
		this.numUsers = numUsers;
		this.numResum = numResum;
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		getContentPane().setLayout(null);
		setBounds(0, 0, 1920, 1080);
		getContentPane().setBackground(new Color(230, 228, 242));
		RF = new JTextField();
		RF.setText(" 0");
		RF.setFont(new Font("Segoe UI Variable", Font.PLAIN, 23));
		RF.setOpaque(false);
		RF.setBorder(BorderFactory.createEmptyBorder());
		RF.setColumns(10);
		RF.setText(" " +numResum);
		RF.setBounds(453, 231, 101, 60);
		getContentPane().add(RF);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Imagens\\Capturas de tela\\Captura de tela 2023-10-31 183423.png"));
		lblNewLabel.setBounds(192, 94, 552, 455);
		getContentPane().add(lblNewLabel);
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI Variable", Font.PLAIN, 23));
		textField.setBounds(993, 231, 101, 60);
		textField.setOpaque(false);
		textField.setBorder(BorderFactory.createEmptyBorder());
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(" " +numUsers);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Imagens\\Capturas de tela\\Captura de tela 2023-10-31 183451.png"));
		lblNewLabel_1.setBounds(754, 153, 650, 256);
		getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 64));
		panel.setBounds(174, 0, 2, 920);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 64));
		panel_1.setBounds(0, 83, 1540, 2);
		getContentPane().add(panel_1);
		
		JLabel sair = new JLabel("");
		sair.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Sair.png"));
		sair.setBounds(791, 384, 76, 101);
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
		setBounds(487, 185, 1129, 775);
		setVisible(true);
		
		
	}
}
