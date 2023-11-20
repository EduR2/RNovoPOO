package br.com.projeto.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.*;
import java.awt.Component;
import java.awt.event.MouseAdapter;

import br.com.projeto.controller.AcaoController;
import br.com.projeto.controller.TerrorController;
import br.com.projeto.controller.FiccaoController;
import br.com.projeto.controller.RomanceController;
import br.com.projeto.controller.ExclusaoController;
import br.com.projeto.controller.DataConfigController;

public class ConfiguracoesView extends JFrame {
	private String nome1;
	private ImageIcon i1, i2, i3, i4, logo, manual1, Con1, sair1, fundocon, excluir, lápis;
	private JLabel acao, sair2, log;
	private Container container;
	TelaPrincipalView login;
	private JTextField nome2;
	private JTextField txtNovaSenha;
	private JTextField txtNovoLogin;
	private JLabel Salvar, Deletar;
	private JTextField textField;

	public ConfiguracoesView(String nome) {
			this.nome1 = nome;
			this.login = login;
			setBounds(0, 0, 1900, 1080);
			container = getContentPane();
			getContentPane().setBackground(new Color(230, 228, 242));
			logo = new ImageIcon("Imagens/LogoTela.png");
			i1 = new ImageIcon("Imagens/read.png");
			manual1 = new ImageIcon("Imagens/Manual.png");
			Con1 = new ImageIcon("Imagens/Config.png");
			sair1 = new ImageIcon("Imagens/Sair.png");
			fundocon = new ImageIcon("Imagens/FundoCon.png");
			excluir = new ImageIcon("Imagens/Excluir.png");
			lápis = new ImageIcon("Imagens/Lápis.png");
			sair2 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo\\Imagens\\Sair.png"));
			log = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-10-31 103059.png"));
			getContentPane().setLayout(null);
			
			Deletar = new JLabel("");
			Deletar.setBounds(197, 603, 150, 50);
			getContentPane().add(Deletar);
			
			textField = new JTextField();
			textField.setBounds(209, 549, 350, 33);
			textField.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
			textField.setBorder(BorderFactory.createEmptyBorder());
			getContentPane().add(textField);
			textField.setColumns(10);
			
			txtNovaSenha = new JTextField("Nova Senha");
			txtNovaSenha.setForeground(Color.LIGHT_GRAY);
			txtNovaSenha.setOpaque(false);
			txtNovaSenha.setBorder(BorderFactory.createEmptyBorder());
			txtNovaSenha.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
			txtNovaSenha.setBounds(209, 341, 350, 45);
			getContentPane().add(txtNovaSenha);
			
			txtNovoLogin = new JTextField("Novo Login");
			txtNovoLogin.setForeground(Color.LIGHT_GRAY);
			txtNovoLogin.setOpaque(false);
			txtNovoLogin.setBorder(BorderFactory.createEmptyBorder());
			txtNovoLogin.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
			txtNovoLogin.setBounds(209, 145, 350, 45);
			getContentPane().add(txtNovoLogin);
			
			nome2 = new JTextField("E-mail");
			nome2.setForeground(Color.LIGHT_GRAY);
			nome2.setOpaque(false);
			nome2.setBorder(BorderFactory.createEmptyBorder());
			nome2.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
			nome2.setBounds(209, 241, 350, 45);
			getContentPane().add(nome2);
			
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setBounds(357, 399, 150, 50);
			getContentPane().add(lblNewLabel_2);
			
			Salvar = new JLabel("");
			Salvar.setBounds(197, 396, 150, 50);
			getContentPane().add(Salvar);

			JPanel panel_4 = new JPanel();
			panel_4.setBounds(0, 0, 0, 0);
			getContentPane().add(panel_4);

			JPanel panel_5 = new JPanel();
			panel_5.setBounds(0, 0, 0, 0);
			getContentPane().add(panel_5);

			JPanel panel = new JPanel();
			panel.setBounds(174, 0, 2, 845);
			panel.setBackground(new Color(255, 128, 64));
			getContentPane().add(panel);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(0, 93, 1540, 2);
			panel_1.setBackground(new Color(255, 128, 64));
			getContentPane().add(panel_1);

			sair2.setBounds(47, 107, 66, 83);
			sair2.setToolTipText("Sair");
			log.setBounds(1147, 113, 206, 236);
		     
			Font fontetip = new Font("Segoe UI Variable", Font.BOLD, 17);
			UIManager.put("ToolTip.font", fontetip);
			UIManager.put("ToolTip.background", (new Color(230, 228, 242)));
			sair2.setToolTipText("Voltar para a tela principal");
			getContentPane().add(sair2);
			getContentPane().add(log);
			
			String log = nome1;
			JLabel lblNewLabel_1 = new JLabel(log);
			lblNewLabel_1.setForeground(new Color(0, 0, 0));
			lblNewLabel_1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 33));
			lblNewLabel_1.setBounds(1197, 339, 184, 63);
			getContentPane().add(lblNewLabel_1);
			
			JLabel Usuários = new JLabel("");
			Usuários.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-10-31 090638.png"));
			Usuários.setBounds(186, 96, 446, 365);
			getContentPane().add(Usuários);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(255, 128, 64));
			panel_2.setBounds(174, 459, 1200, 2);
			getContentPane().add(panel_2);
			
			JLabel Usuários_1 = new JLabel("");
			Usuários_1.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-10-31 090708.png"));
			Usuários_1.setBounds(186, 497, 446, 168);
			getContentPane().add(Usuários_1);
			
			sair2.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();

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
			nome2.addFocusListener(new FocusListener() {

				@Override
				public void focusGained(FocusEvent e) {
					if (nome2.getText().equals("E-mail")) {
	 					nome2.setText("");
	 					nome2.setForeground(Color.black);
	 				}
					
				}

				@Override
				public void focusLost(FocusEvent e) {
					if (nome2.getText().isEmpty()) {
	 					nome2.setText("E-mail");
	 					nome2.setForeground(Color.LIGHT_GRAY);
	 				}
					
				}
				
			});
			txtNovoLogin.addFocusListener(new FocusListener() {

				@Override
				public void focusGained(FocusEvent e) {
					if (txtNovoLogin.getText().equals("Novo Login")) {
						txtNovoLogin.setText("");
						txtNovoLogin.setForeground(Color.black);
					
				}
				}

					public void focusLost(FocusEvent e) {
		  				if (txtNovoLogin.getText().isEmpty()) {
		  					txtNovoLogin.setText("Novo Login");
		  					txtNovoLogin.setForeground(Color.LIGHT_GRAY);
		  				}
		  			}
			
				
			});
			txtNovaSenha.addFocusListener(new FocusListener() {

				@Override
				public void focusGained(FocusEvent e) {
					if (txtNovaSenha.getText().equals("Nova Senha")){
						txtNovaSenha.setText("");
						txtNovaSenha.setForeground(Color.black);
					
				}
					
				}

				@Override
				public void focusLost(FocusEvent e) {
					if (txtNovaSenha.getText().isEmpty()) {
	  					txtNovaSenha.setText("Nova Senha");
	  					txtNovaSenha.setForeground(Color.LIGHT_GRAY);
	  				}
					
				}
				
			});
	         
			setVisible(true);
		}

	public String getLogin(String nome) {
		return nome;
	}

	public String getEmail() {
		return nome2.getText();
	}

	public String getSenha() {
		return txtNovaSenha.getText();
	}

	public String getNome() {
		return txtNovoLogin.getText();
	}

	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
	
	public String getEmailDel() {
		return textField.getText();
	}
	public void mensagemAtencao(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro ao Alterar", JOptionPane.ERROR_MESSAGE);
	}
	public void mensagemErro(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
	public void addBtnLembrarSenha(MouseListener lembraListener) {
		Salvar.addMouseListener(lembraListener);
	}
	public void addBtnExcluir(MouseListener excluiListener) {
		Deletar.addMouseListener(excluiListener);
	}
}
