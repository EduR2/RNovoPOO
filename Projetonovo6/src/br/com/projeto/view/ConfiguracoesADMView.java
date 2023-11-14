package br.com.projeto.view;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConfiguracoesADMView extends JFrame {
	private JLabel image3;
	private Container container;
	private ImageIcon i1, i2, i3;
	private Font fonte = new Font("Verdana", Font.BOLD, 20);
	private Font fonte1 = new Font("Calibri", Font.BOLD, 15);
	private Font fonte2 = new Font("Verdana", Font.BOLD, 9);
	private Font fonte3 = new Font ("Calibri", Font.BOLD, 35);
    private JTextField nome, senha;
    private JLabel save;
    private JLabel Sair;
    public ConfiguracoesADMView () {
    	inicializaComponentes();    	
    }
    public void inicializaComponentes() {
    	 setTitle("Configurações de dados de ADM");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         getContentPane().setLayout(null);
         getContentPane().setBackground(new Color(230, 228, 242));
         setBounds(487, 185, 594, 500);
         nome = new JTextField("Crie um login");
    	 nome.setOpaque(false);
    	 nome.setBorder(BorderFactory.createEmptyBorder());
         senha = new JTextField("Crie uma senha");
         senha.setOpaque(false);
    	 senha.setBorder(BorderFactory.createEmptyBorder());
         i1 = new ImageIcon ("Imagens/Fundo.jpg");
         i2 = new ImageIcon("Imagens/Fundo1.jpg");
         i3 = new ImageIcon ("Imagens/read.png");
    	 image3 = new JLabel(i3);
    	 container = getContentPane();
         nome.setBounds(54, 88, 493, 45);
         senha.setBounds(54, 237, 493, 45);
         image3.setBounds(95, -60, 390, 320);
         nome.setFont(new Font("Calibri", Font.BOLD, 22));
         senha.setFont(new Font("Calibri", Font.BOLD, 22));
         nome.setForeground(Color.WHITE);
         senha.setForeground(Color.WHITE);
         
         Sair = new JLabel("");
         Sair.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Sair.png"));
         Sair.setBounds(513, 0, 67, 67);
         getContentPane().add(Sair);
         Sair.addMouseListener(new MouseListener() {

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
         
         JLabel Cancelar = new JLabel("");
         Cancelar.setBounds(274, 343, 206, 67);
         getContentPane().add(Cancelar);
         Cancelar.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				nome.setText("");
				senha.setText("");
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
         
         save = new JLabel("");
         save.setBounds(37, 343, 206, 67);
         getContentPane().add(save);
         getContentPane().add(nome);
         getContentPane().add(senha);
         
         save = new JLabel("");
         save.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo3\\Imagens\\Captura de tela 2023-11-06 123450.png"));
         save.setBounds(22, 27, 539, 406);
         getContentPane().add(save);
         nome.addFocusListener(new FocusListener() {
 			public void focusGained(FocusEvent e) {
 				if (nome.getText().equals("Crie um login")) {
 					nome.setText("");
 					nome.setForeground(Color.black);
 				}
 			}
 			public void focusLost(FocusEvent e) {
 				if (nome.getText().isEmpty()) {
 					nome.setText("Crie um login");
 					nome.setForeground(Color.WHITE);
 				}
 			}
          });
          senha.addFocusListener(new FocusListener() {
  			public void focusGained(FocusEvent g) {
  				if (senha.getText().equals("Crie uma senha")) {
  			        senha.setText("");
  					senha.setForeground(Color.black);
  				}
  			}
  			public void focusLost(FocusEvent e) {
  				if (senha.getText().isEmpty()) {
  					senha.setText("Crie uma senha");
  				    senha.setForeground(Color.WHITE);
  				}
  			}
           });
    }
    public String getNome() {
        return nome.getText();
    }
    public String getSenha() {
        return senha.getText();
    }
	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
	public void mensagemErro(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro ao cadastrar", JOptionPane.ERROR_MESSAGE);
	}
	public void addBtnSalvar(MouseListener listener) {
		save.addMouseListener(listener);
	}
}