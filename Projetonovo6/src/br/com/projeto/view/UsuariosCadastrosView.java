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

	private JLabel image2, image3, txt1, sair;
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
	private DefaultTableModel tableModel;
	private JTable table;
	private JTextField txtAutor;
	private JLabel exclusao;

	public UsuariosCadastrosView() {
		inicializaComponentes();
	}

	public void inicializaComponentes() {
		ImageIcon read7 = new ImageIcon("Imagens/LOGOBRANCAnova.png");
		setIconImage(read7.getImage());
		setBounds(0, 0, 1920, 1080);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(255, 255, 255));
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
		sair = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\SairTRNew.png"));
		image2 = new JLabel(i2);
		image3 = new JLabel(i3);
		p = new JPanel();
		
		pane.setBounds(424, 213, 717, 433);
		senha.setBounds(597, 395, 350, 45);
		image3.setBounds(575, 65, 390, 320);
		txt1.setBounds(740, 537, 125, 20);
		p.setBounds(575, 250, 390, 315);
		sair.setBounds(1429, 55, 101, 130);
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
		getContentPane().add(pane);
		
		txtAutor = new JTextField();
		txtAutor.setHorizontalAlignment(SwingConstants.LEFT);
		txtAutor.setForeground(new Color(0, 0, 0));
		txtAutor.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		txtAutor.setColumns(10);
		txtAutor.setBounds(361, 75, 770, 50);
		txtAutor.setOpaque(false);
		txtAutor.setBorder(BorderFactory.createEmptyBorder());
		getContentPane().add(txtAutor);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura_de_tela_2023-10-17_17035 (1).png"));
		lblNewLabel.setBounds(273, 21, 1209, 752);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		panel.setBounds(196, 0, 2, 845);
		getContentPane().add(panel);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 49, 49));
		panel_5.setBounds(1503, 21, 27, 24);
		getContentPane().add(panel_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(56, 182, 255));
		panel_4.setBounds(1477, 21, 27, 24);
		getContentPane().add(panel_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(92, 225, 230));
		panel_3.setBounds(1450, 21, 27, 24);
		getContentPane().add(panel_3);
		
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
