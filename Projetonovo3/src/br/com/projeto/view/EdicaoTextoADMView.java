package br.com.projeto.view;

import java.awt.Color;
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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import br.com.projeto.controller.EdicaoADMController;
import br.com.projeto.controller.ExclusaoADMVController;
import br.com.projeto.model.vo.LoginVO;
import br.com.projeto.model.vo.TextosVO;

import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;

public class EdicaoTextoADMView extends JFrame {
	private JLabel image2, image3, txt1, sair, salvar, livro1, livro2, livro3;
	private JPanel p, p1, p2;
	private JButton b, btnSalvar, btnLer, btnLimpar, btnTxt1;
	private Container container;
	private ImageIcon i1, i2, i3, i, save, clean, book1, book2, book3;
	private Font fonte = new Font("Verdana", Font.BOLD, 20);
	private Font fonte1 = new Font("Calibri", Font.BOLD, 15);
	private Font fonte2 = new Font("Verdana", Font.BOLD, 9);
	private JTextArea text;
	private JScrollPane pane;
	private JPasswordField senha;
	private JButton btnLogin, btnCriarCadastro;
	private String texto;
	private JLabel livro1_1;
	private JLabel livro1_2;
	private JLabel info;
	private DefaultTableModel tableModel;
	private JTable table;
	JComboBox comboBox;
	public EdicaoTextoADMView() {
		inicializaComponentes();
	}

	public void inicializaComponentes() {
		setTitle("Read7");
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
		text = new JTextArea();
		senha = new JPasswordField("Senha");
		pane = new JScrollPane();
		btnLogin = new JButton("Login");
		btnCriarCadastro = new JButton("Criar");
		txt1 = new JLabel("Não possui cadastro?");
		i = new ImageIcon("Imagens/SairTR.png");
		save = new ImageIcon("Imagens/Salvar.png");
		clean = new ImageIcon("Imagens/Borracha.png");
		book1 = new ImageIcon("Imagens/livro1.png");
		book2 = new ImageIcon("Imagens/livro2.png");
		book3 = new ImageIcon("Imagens/livro3.png");
		i1 = new ImageIcon("Imagens/Fundo2.jpg");
		i2 = new ImageIcon("Imagens/Fundo1.jpg");
		i3 = new ImageIcon("Imagens/read.png");
		sair = new JLabel(i);
		salvar = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\Salvar.png"));
		livro1 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\livro1.png"));
		livro2 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\livro2.png"));
		livro3 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo2\\Imagens\\livro3.png"));
		image2 = new JLabel(i2);
		image3 = new JLabel(i3);
		p = new JPanel();
		//pane1.setBounds(793, 153, 590, 500);
		text.setLineWrap(true);
		senha.setBounds(597, 395, 350, 45);
		image3.setBounds(575, 65, 390, 320);
		txt1.setBounds(740, 537, 125, 20);
		p.setBounds(575, 250, 390, 315);
		sair.setBounds(1400, 0, 130, 113);
		salvar.setBounds(1393, 298, 130, 102);
		livro1.setBounds(36, 186, 100, 102);
		livro2.setBounds(36, 298, 100, 102);
		livro3.setBounds(36, 410, 100, 102);
		pane.setBounds(509, 212, 717, 433);
		p.add(image2);
		
		table = new JTable();
		tableModel = new DefaultTableModel(new Object[] {"Texto", "Classificação"}, 0);
		table.setModel(tableModel);
		table.setBounds(538, 221, 558, 433);
		table.setBackground(new Color(230, 228, 242));
		table.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		pane.setViewportView(table);
		
	/*	table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1) {
					try {
					int linha = table.getSelectedRow();
					String Nome = (String) table.getValueAt(linha, 0);
					String Senha = (String) table.getValueAt(linha, 1);
					TelaAcaodeADMView view = new TelaAcaodeADMView(Nome, Senha);
					String url = "jdbc:mysql://localhost:3306/BD";
					Connection conexao = DriverManager.getConnection (url, "root", "root");
					ExclusaoADMVController control = new ExclusaoADMVController(view, conexao);
					EdicaoADMController control2 = new EdicaoADMController(view, conexao);
					view.setVisible(true);
					}catch(SQLException sqle) {}
				}
				
			}   
		});*/

		btnLogin.setBackground(Color.BLUE);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(fonte);
		text.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		senha.setFont(fonte1);
		getContentPane().add(sair);
		getContentPane().add(salvar);
		getContentPane().add(livro1);
		getContentPane().add(livro2);
		getContentPane().add(livro3);
		getContentPane().add(pane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 64));
		panel.setBounds(174, 0, 2, 845);
		getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 64));
		panel_1.setBounds(-10, 110, 1540, 2);
		getContentPane().add(panel_1);
		
		livro1.setToolTipText("Texto 1");
		livro2.setToolTipText("Texto 2");
		livro3.setToolTipText("Texto 3");
		salvar.setToolTipText("Salvar");
		
		comboBox = new JComboBox();
		comboBox.setBounds(36, 139, 100, 37);
		comboBox.addItem("Ação");
		comboBox.addItem("Terror");
		comboBox.addItem("Ficção");
		comboBox.addItem("Romance");
		//String item = (String) comboBox.getSelectedItem();
		getContentPane().add(comboBox);
		
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



	public void setTexto(String texto) {
		text.setText(texto);
	}
	public String getGen() {
		return (String) comboBox.getSelectedItem();
	}
	public void addBtnTxtListener(ActionListener listener) {
		comboBox.addActionListener(listener);
	}
	public void addBtnPegaTxt(MouseListener listener) {
		livro1.addMouseListener(listener);
	}
	public void addBtnPegaTxt2(MouseListener listener) {
		livro2.addMouseListener(listener);
	}
	public void addBtnPegaTxt3(MouseListener listener) {
		livro3.addMouseListener(listener);
	}
	public void tabela(List<TextosVO> texto) {
		tableModel.setRowCount(0);
		for(TextosVO textos: texto) {
			tableModel.addRow(new Object[] {textos.getTexto(), textos.getClassificação()});
		}
	}

	public void addBtnSalvar(MouseListener salvarListener) {
		salvar.addMouseListener(salvarListener);
	}

	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

	public void mostrarMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro ao logar", JOptionPane.ERROR_MESSAGE);
	}
}