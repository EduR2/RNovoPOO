package br.com.projeto.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import br.com.projeto.controller.TapSong;
import br.com.projeto.model.vo.GenerosVO;

public class ManualTelaTextosView extends JFrame {
	
	private JLabel image2, image3, txt1, sair, livro1;
	private JPanel p, p1, p2;
	private JButton b, btnSalvar, btnLer, btnLimpar, btnTxt1;
	private Container container;
	private ImageIcon i1, i2, i3, i, save, clean, book1, search;
	private Font fonte = new Font("Verdana", Font.BOLD, 20);
	private Font fonte1 = new Font("Calibri", Font.BOLD, 15);
	private Font fonte2 = new Font("Verdana", Font.BOLD, 9);
	private JPasswordField senha;
	private JButton btnLogin, btnCriarCadastro;
	private String texto;
	private JLabel l1;
	private DefaultTableModel tableModel;

	public ManualTelaTextosView() {
		inicializaComponentes();
	}

	public void inicializaComponentes() {
		setBounds(0, 0, 1920, 1080);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(230, 228, 242));
		Font fontetip = new Font("Segoe UI Variable", Font.BOLD, 17);
		UIManager.put("ToolTip.font", fontetip);
		UIManager.put("ToolTip.background", (new Color(230, 228, 242)));
		b = new JButton("Voltar");
		btnSalvar = new JButton("Salvar");
		btnLer = new JButton("Ler");
		btnLimpar = new JButton("Limpar");
		btnTxt1 = new JButton("Texto 1");
		senha = new JPasswordField("Senha");
		btnLogin = new JButton("Login");
		btnCriarCadastro = new JButton("Criar");
		txt1 = new JLabel("Não possui cadastro?");
		i = new ImageIcon("Imagens/SairTR.png");
		save = new ImageIcon("Imagens/Salvar.png");
		clean = new ImageIcon("Imagens/Borracha.png");
		book1 = new ImageIcon("Imagens/manual.png");
		i1 = new ImageIcon("Imagens/Fundo2.jpg");
		i2 = new ImageIcon("Imagens/Fundo1.jpg");
		i3 = new ImageIcon("Imagens/read.png");
		search = new ImageIcon("Imagens/Lupa.png");
		sair = new JLabel(new ImageIcon("C:\\\\Users\\\\eduar\\\\OneDrive\\\\Área de Trabalho\\\\ImagensProjeto\\\\SairTR.png"));
		image2 = new JLabel(i2);
		livro1 = new JLabel(book1);
		image3 = new JLabel(i3);
		p = new JPanel();
		senha.setBounds(597, 395, 350, 45);
		image3.setBounds(575, 65, 390, 320);
		txt1.setBounds(740, 537, 125, 20);
		p.setBounds(575, 250, 390, 315);
		sair.setBounds(1400, 0, 130, 113);
		livro1.setBounds(10, 0, 100, 102);
		p.add(image2);
		tableModel = new DefaultTableModel(new Object[] {"E-mail", "Título", "Resumo", "Classificação"}, 0);
		
		btnLogin.setBackground(Color.BLUE);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(fonte);
		senha.setFont(fonte1);
		getContentPane().add(sair);
		getContentPane().add(livro1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 64));
		panel_1.setBounds(-10, 110, 1550, 2);
		getContentPane().add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("Guia para o uso das telas de textos e resumos");
		lblNewLabel_1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 27));
		lblNewLabel_1.setBounds(454, 10, 586, 90);
		getContentPane().add(lblNewLabel_1);
		
		l1 = new JLabel(new ImageIcon("C:\\Users\\eduar\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\loupe-et-icone-de-recherche-de-c.png"));
		l1.setBounds(509, 122, 90, 90);
		getContentPane().add(l1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\eduar\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Imagem do WhatsApp de 2023-10-17 à(s) 22.57.09_169756e2.jpg"));
		lblNewLabel.setBounds(181, 143, 1217, 572);
		getContentPane().add(lblNewLabel);

		sair.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TapSong.getSong();
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
		setVisible(true);
	}
	

	public DefaultTableModel getTexto() {
		return tableModel;
	}
	
	public void tabela(List<GenerosVO> generos) {
		tableModel.setRowCount(0);
		for(GenerosVO genero: generos) {
			tableModel.addRow(new Object[] {genero.getId(), genero.getAutor(), genero.getTitulo(), genero.getClassificao()});
		}
	}

	
	public void mostrarMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro ao logar", JOptionPane.ERROR_MESSAGE);
	}
}