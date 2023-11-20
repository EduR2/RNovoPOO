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
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import br.com.projeto.controller.EdicaoADMController;
import br.com.projeto.controller.ExclusaoADMVController;
import br.com.projeto.model.vo.LoginVO;
import br.com.projeto.model.vo.TextosVO;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import br.com.projeto.controller.AtualizaçãoNovoTextoADM;

public class EdicaoTextoADMView extends JFrame {
	private JLabel image2, image3, txt1, sair;
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
		//setUndecorated(true);
		getContentPane().setBackground(new Color(255, 255, 255));
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
		pane.setBackground(new Color(225, 225, 225));
		pane.setBorder(BorderFactory.createEmptyBorder());
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
		image2 = new JLabel(i2);
		image3 = new JLabel(i3);
		p = new JPanel();
		//pane1.setBounds(793, 153, 590, 500);
		text.setLineWrap(true);
		senha.setBounds(597, 395, 350, 45);
		image3.setBounds(575, 65, 390, 320);
		txt1.setBounds(740, 537, 125, 20);
		p.setBounds(575, 250, 390, 315);
		sair.setBounds(1413, 331, 130, 113);
		pane.setBounds(580, 106, 823, 623);
		p.add(image2);
		
		table = new JTable();
		tableModel = new DefaultTableModel(new Object[] {"Texto", "Classificação"}, 0);
		table.setModel(tableModel);
		table.setBounds(538, 221, 558, 433);
		table.setBackground(new Color(225, 225, 225));
		table.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		pane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1) {
					try {
					int linha = table.getSelectedRow();
					String Resumo = (String) table.getValueAt(linha, 0);
					//String Senha = (String) table.getValueAt(linha, 1);
					TelaEdicaodeTextoADMView view = new TelaEdicaodeTextoADMView(Resumo);
					view.setExtendedState(JFrame.MAXIMIZED_BOTH);
					String url = "jdbc:mysql://localhost:3306/BD";
					Connection conexao = DriverManager.getConnection (url, "root", "root");
					AtualizaçãoNovoTextoADM atlzNewTxt = new AtualizaçãoNovoTextoADM(view, conexao);
					view.setVisible(true);
					}catch(SQLException sqle) {}
				}
			 
			}   
		});

		btnLogin.setBackground(Color.BLUE);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(fonte);
		text.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		senha.setFont(fonte1);
		getContentPane().add(sair);
		getContentPane().add(pane);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI Variable", Font.PLAIN, 17));
		comboBox.setBounds(171, 207, 100, 37);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.addItem("Ação");
		comboBox.addItem("Terror");
		comboBox.addItem("Ficção");
		comboBox.addItem("Romance");
		String item = (String) comboBox.getSelectedItem();
		System.out.println ("Genero selecionado: " +getGen());
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Captura de tela 2023-11-14 153554.png"));
		lblNewLabel.setBounds(543, 66, 909, 721);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 64));
		panel.setBounds(112, 67, 2, 720);
		getContentPane().add(panel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(92, 225, 230));
		panel_3.setBounds(1425, 22, 27, 24);
		getContentPane().add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(56, 182, 255));
		panel_4.setBounds(1452, 22, 27, 24);
		getContentPane().add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 49, 49));
		panel_5.setBounds(1478, 22, 27, 24);
		getContentPane().add(panel_5);
		
		JLabel Generos = new JLabel("");
		Generos.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Captura de tela 2023-11-14 162359.png"));
		Generos.setBounds(171, 153, 310, 498);
		getContentPane().add(Generos);
		
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
	public void tabela(List<TextosVO> texto) {
		tableModel.setRowCount(0);
		for(TextosVO textos: texto) {
			tableModel.addRow(new Object[] {textos.getTexto(), textos.getClassificação()});
		}
	}
	
	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

	public void mostrarMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro ao logar", JOptionPane.ERROR_MESSAGE);
	}
}