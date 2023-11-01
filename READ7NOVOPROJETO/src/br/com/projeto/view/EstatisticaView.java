package br.com.projeto.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.Component;
import java.awt.event.MouseAdapter;

import br.com.projeto.controller.GenerosController;
import br.com.projeto.controller.ManualUserController;
import br.com.projeto.controller.TerrorController;
import br.com.projeto.controller.FiccaoController;
import br.com.projeto.controller.RomanceController;
import br.com.projeto.controller.TapSong;
import br.com.projeto.controller.AcaoRController;
import br.com.projeto.model.dao.AcaoRDAO;
import br.com.projeto.model.vo.*;
public class EstatisticaView extends JFrame {
	private String nome;
	private ImageIcon i1, i2, i3, i4, logo, manual1, Con1, sair1, inf;
	private JLabel lblLogo, acao, sair2, info;
	private Container container;
	private JTextField textField;
	private JTextField textField_1;

	public EstatisticaView(String nome) {
		super();
		this.nome = nome;
		inicializaComponentes();
		setVisible(true);
	}
	public void inicializaComponentes() {
		setTitle("Read7");
		
		Font fontetip = new Font("Segoe UI Variable", Font.BOLD, 17);
		UIManager.put("ToolTip.font", fontetip);
		UIManager.put("ToolTip.background", (new Color(230, 228, 242)));
		setBounds(0, 0, 1900, 1080);
		container = getContentPane();
		getContentPane().setBackground(new Color(230, 228, 242));
		logo = new ImageIcon("Imagens/LogoTela.png");
		i1 = new ImageIcon("Imagens/acao.png");
		i2 = new ImageIcon("Imagens/Terror.png");
		i3 = new ImageIcon("Imagens/Ficção.png");
		i4 = new ImageIcon("Imagens/Romance.png");
		manual1 = new ImageIcon("Imagens/Manual.png");
		Con1 = new ImageIcon("Imagens/Config.png");
		sair1 = new ImageIcon("Imagens/Sair.png");
		lblLogo = new JLabel(new ImageIcon("C:\\Users\\eduar\\OneDrive\\Área de Trabalho\\ProjetoREAD7NOVO\\ProjetoREAD7\\Imagens\\LogoTela.png"));
		sair2 = new JLabel(new ImageIcon("C:\\Users\\eduar\\OneDrive\\Imagens\\Capturas de tela\\saidaestatist.png"));
		getContentPane().setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 0, 0);
		getContentPane().add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 0, 0);
		getContentPane().add(panel_5);

		JPanel panel = new JPanel();
		panel.setBounds(174, 0, 2, 845);
		panel.setBackground(new Color(0, 0, 0));
		getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 70, 1540, 2);
		panel_1.setBackground(new Color(0, 0, 0));
		getContentPane().add(panel_1);

		sair2.setBounds(57, 434, 93, 83);
		sair2.setToolTipText("Sair");
		lblLogo.setBounds(43, 79, 74, 77);
		getContentPane().add(lblLogo);
		getContentPane().add(sair2);
		sair2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				TapSong.getSong();
				System.exit(0);

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
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\eduar\\OneDrive\\Imagens\\Capturas de tela\\imrprimi.png"));
		lblNewLabel_3.setBounds(344, 453, 60, 60);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\eduar\\OneDrive\\Imagens\\Capturas de tela\\estatiGeral.png"));
		lblNewLabel.setBounds(208, -46, 1071, 697);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\eduar\\OneDrive\\Imagens\\Capturas de tela\\textoestatis.png"));
		lblNewLabel_1.setBounds(186, 38, 376, 435);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(344, 140, 146, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(364, 190, 126, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}



	         



	


