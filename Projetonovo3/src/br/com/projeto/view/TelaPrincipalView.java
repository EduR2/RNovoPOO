package br.com.projeto.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import java.awt.Component;
import java.awt.event.MouseAdapter;

import br.com.projeto.controller.GenerosController;
import br.com.projeto.controller.TerrorController;
import br.com.projeto.controller.FiccaoController;
import br.com.projeto.controller.RomanceController;
import br.com.projeto.controller.SaidaSong;
import br.com.projeto.controller.TapSong;
import br.com.projeto.controller.AberturaSong;
import br.com.projeto.controller.AcaoRController;
import br.com.projeto.controller.ManualUserController;
import br.com.projeto.controller.ConfigSong;
import br.com.projeto.model.dao.AcaoRDAO;
import br.com.projeto.model.vo.*;

public class TelaPrincipalView extends JFrame {
	private String nome;
	private ImageIcon i1, i2, i3, i4, logo, manual1, Con1, sair1, inf;
	private JLabel Gêneros, lblLogo, acao, manual2, con2, sair2, lblNewLabel, info;
	private Container container;

	public TelaPrincipalView(String nome) {
		super();
		this.nome = nome;
		inicializaComponentes();
	}

	public void inicializaComponentes() {
		setTitle("Read7");
		//setUndecorated(true);
		Font fontetip = new Font("Segoe UI Variable", Font.BOLD, 17);
		UIManager.put("ToolTip.font", fontetip);
		UIManager.put("ToolTip.background", (new Color(230, 228, 242)));

		lblNewLabel = new JLabel("Bem vindo, " + nome);
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 17));
		lblNewLabel.setBounds(186, 10, 238, 63);
		getContentPane().add(lblNewLabel);
		setBounds(0, 0, 1900, 1080);
		container = getContentPane();
		getContentPane().setBackground(new Color(255, 255, 255));
		logo = new ImageIcon("Imagens/LogoTela.png");
		i1 = new ImageIcon("Imagens/acao.png");
		i2 = new ImageIcon("Imagens/Terror.png");
		i3 = new ImageIcon("Imagens/Ficção.png");
		i4 = new ImageIcon("Imagens/Romance.png");
		manual1 = new ImageIcon("Imagens/Manual.png");
		Con1 = new ImageIcon("Imagens/Config.png");
		sair1 = new ImageIcon("Imagens/Sair.png");
		Gêneros = new JLabel(
				new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-10-30 08523.png"));
		Gêneros.setBounds(199, 102, 322, 300);
		lblLogo = new JLabel(new ImageIcon("C:\\Users\\pwneg\\Downloads\\LogoJO.png"));
		manual2 = new JLabel(
				new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\RESUMOS2.png"));
		con2 = new JLabel(
				new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\CONFIGNOVO.png"));
		sair2 = new JLabel(
				new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\SAIRNOVO.png"));
		getContentPane().setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 0, 0);
		getContentPane().add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 0, 0);
		getContentPane().add(panel_5);

		JPanel panel = new JPanel();
		panel.setBounds(174, 0, 2, 920);
		panel.setBackground(new Color(255, 128, 64));
		getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 83, 1540, 2);
		panel_1.setBackground(new Color(255, 128, 64));
		getContentPane().add(panel_1);

		sair2.setBounds(594, 451, 322, 300);
		sair2.setToolTipText("Sair");
		con2.setBounds(199, 451, 322, 300);
		con2.setToolTipText("Configurações");
		manual2.setBounds(594, 102, 322, 300);
		manual2.setToolTipText("Seus Resumos");
		lblLogo.setBounds(0, 328, 176, 168);
		getContentPane().add(lblLogo);
		getContentPane().add(Gêneros);
		getContentPane().add(con2);
		getContentPane().add(manual2);
		getContentPane().add(sair2);

		JLabel l2_1 = new JLabel((Icon) null);
		l2_1.setBounds(774, 186, 234, 213);
		getContentPane().add(l2_1);
		
		Gêneros.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				GenerosView view = new GenerosView();
				view.setVisible(true);
				/*try {
					
					/*TapSong.getSong();
					AcaoView view = new AcaoView();
					String url = "jdbc:mysql://localhost:3306/BD";
					Connection conexao = DriverManager.getConnection(url, "root", "root");
					GenerosController controller = new GenerosController(view, conexao);
					view.setVisible(true);
					view.setExtendedState(JFrame.MAXIMIZED_BOTH);*/
				//} //catch (SQLException sqle) {}

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
		con2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				ConfiguracoesView view = new ConfiguracoesView(nome);
				TapSong.getSong();
				view.setVisible(true);
				view.setExtendedState(JFrame.MAXIMIZED_BOTH);

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
		sair2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				TapSong.getSong();
				Thread.sleep(1500);
				System.exit(0);
				}catch(Exception exceptione) {}

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
		manual2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TapSong.getSong();
					TelaRAcaoView view = new TelaRAcaoView();
					String url = "jdbc:mysql://localhost:3306/BD";
					Connection conexao = DriverManager.getConnection(url, "root", "root");
					AcaoRController controle = new AcaoRController(view, conexao);
					AcaoRDAO acrDAO = new AcaoRDAO();
					List<GenerosVO> buscaResumo = acrDAO.buscarGeneros();
					view.tabela(buscaResumo);
					view.setVisible(true);
					view.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (SQLException sqle) {
				}

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
		
		JLabel Manual = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-10-30 09000.png"));
		Manual.setToolTipText("Manual do Usuário");
		Manual.setBounds(970, 83, 322, 333);
		getContentPane().add(Manual);
		Manual.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				TapSong.getSong();	
				ManualUserView view2 = new ManualUserView();
				String url = "jdbc:mysql://localhost:3306/BD";
				Connection conexao = DriverManager.getConnection(url, "root", "Hr102206");
				ManualUserController controller = new ManualUserController();
				view2.setVisible(true);
				view2.setExtendedState(JFrame.MAXIMIZED_BOTH);
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

		setVisible(true);
	}
}