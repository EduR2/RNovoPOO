package br.com.projeto.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import br.com.projeto.model.vo.GenerosVO;
import br.com.projeto.model.vo.LoginVO;
import br.com.projeto.controller.ExclusaoADMVController;
import br.com.projeto.controller.EdicaoADMController;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class UsuariosCadastrosView extends JFrame {

	private JLabel image2, image3, txt1, sair, livro1;
	private JPanel p, p1, p2;
	private JButton b, btnSalvar, btnLer, btnLimpar, btnTxt1;
	private Container container;
	private ImageIcon i1, i2, i3, i, save, clean, book1, search;
	private Font fonte = new Font("Verdana", Font.BOLD, 20);
	private Font fonte1 = new Font("Calibri", Font.BOLD, 15);
	private Font fonte2 = new Font("Verdana", Font.BOLD, 9);
	private JScrollPane pane;
	private JPasswordField senha;
	private JButton btnLogin, btnCriarCadastro;
	private String texto;
	private JLabel l1;
	private DefaultTableModel tableModel;
	private JTable table;
	private JTextField txtAutor;
	private JLabel exclusao;
	private JPanel panel_2;

	public UsuariosCadastrosView() {
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
		pane = new JScrollPane();
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
		sair = new JLabel(i);
		image2 = new JLabel(i2);
		livro1 = new JLabel(book1);
		image3 = new JLabel(i3);
		p = new JPanel();
		
		pane.setBounds(509, 212, 717, 433);
		senha.setBounds(597, 395, 350, 45);
		image3.setBounds(575, 65, 390, 320);
		txt1.setBounds(740, 537, 125, 20);
		p.setBounds(575, 250, 390, 315);
		sair.setBounds(1400, 0, 130, 113);
		livro1.setBounds(152, 0, 100, 102);
		p.add(image2);
		
		table = new JTable();
		tableModel = new DefaultTableModel(new Object[] {"Nome", "Senha", "E-mail"}, 0);
		table.setModel(tableModel);
		table.setBounds(538, 221, 558, 433);
		table.setBackground(new Color(230, 228, 242));
		table.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		pane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1) {
					try {
					int linha = table.getSelectedRow();
					String Nome = (String) table.getValueAt(linha, 0);
					String Senha = (String) table.getValueAt(linha, 1);
					String Email = (String) table.getValueAt(linha, 2);
					TelaAcaodeADMView view = new TelaAcaodeADMView(Nome, Senha, Email);
					String url = "jdbc:mysql://localhost:3306/BD";
					Connection conexao = DriverManager.getConnection (url, "root", "root");
					ExclusaoADMVController control = new ExclusaoADMVController(view, conexao);
					EdicaoADMController control2 = new EdicaoADMController(view, conexao);
					view.setVisible(true);
					}catch(SQLException sqle) {}
				}
				
			}   
		});
		btnLogin.setBackground(Color.BLUE);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(fonte);
		senha.setFont(fonte1);
		getContentPane().add(sair);
		getContentPane().add(livro1);
		getContentPane().add(pane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 64));
		panel.setBounds(418, 0, 2, 845);
		getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 64));
		panel_1.setBounds(-10, 110, 1550, 2);
		getContentPane().add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("Usuários Cadastrados");
		lblNewLabel_1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 27));
		lblNewLabel_1.setBounds(430, 10, 519, 90);
		getContentPane().add(lblNewLabel_1);
		
		l1 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\LogoJO.png"));
		l1.setBounds(87, 294, 234, 213);
		getContentPane().add(l1);
		
		txtAutor = new JTextField();
		txtAutor.setHorizontalAlignment(SwingConstants.LEFT);
		txtAutor.setForeground(new Color(0, 0, 0));
		txtAutor.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		txtAutor.setColumns(10);
		txtAutor.setBounds(609, 142, 238, 50);
		txtAutor.setOpaque(false);
		txtAutor.setBorder(BorderFactory.createEmptyBorder());
		getContentPane().add(txtAutor);
		
		JLabel l1_1 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\loupe-et-icone-de-recherche-de-c.png"));
		l1_1.setBounds(509, 122, 90, 90);
		getContentPane().add(l1_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 128, 0));
		panel_2.setBounds(610, 188, 237, 4);
		getContentPane().add(panel_2);
		
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

	public DefaultTableModel getTexto() {
		return tableModel;
	}
	
	public void tabela(List<LoginVO> usuario) {
		tableModel.setRowCount(0);
		for(LoginVO usuarios: usuario) {
			tableModel.addRow(new Object[] {usuarios.getNome(), usuarios.getSenha(), usuarios.getEmail()});
		}
	}
	public String getAutor() {
		return txtAutor.getText();
	}
	
	public void addTxtListener(DocumentListener listener) {
		txtAutor.getDocument().addDocumentListener(listener);
	}
	
	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

	public void mostrarMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro ao logar", JOptionPane.ERROR_MESSAGE);
	}
}
