package br.com.projeto.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.projeto.model.bo.CadastroBO;
import br.com.projeto.model.vo.CadastroVO;


public class CadastroView extends JFrame {
	private JLabel image3, txt1;
	private Container container;
	private ImageIcon i1, i2, i3;
	private Font fonte = new Font("Verdana", Font.BOLD, 20);
	private Font fonte1 = new Font("Calibri", Font.BOLD, 15);
	private Font fonte2 = new Font("Verdana", Font.BOLD, 9);
	private Font fonte3 = new Font ("Calibri", Font.BOLD, 35);
    private JTextField nome, senha, email;
    private JButton btnCadastrar, btnVoltar;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    public CadastroView() {
    	getContentPane().setBackground(new Color(255, 128, 64));
    	inicializaComponentes();    	
    }
    public void inicializaComponentes() {
    	 setTitle("Cadastro");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         getContentPane().setLayout(null);
         setBounds(487, 185, 585, 500);
         nome = new JTextField("Crie um login");
    	 nome.setOpaque(false);
    	 nome.setBorder(BorderFactory.createEmptyBorder());
         senha = new JTextField("Crie uma senha");
         senha.setOpaque(false);
    	 senha.setBorder(BorderFactory.createEmptyBorder());
         email = new JTextField ("Registre seu e-mail");
         email.setOpaque(false);
    	 email.setBorder(BorderFactory.createEmptyBorder());
         btnCadastrar = new JButton("Criar");
         btnVoltar = new JButton ("Voltar");
         txt1 = new JLabel ("Criar Conta");
         i1 = new ImageIcon ("Imagens/Fundo.jpg");
         i2 = new ImageIcon("Imagens/Fundo1.jpg");
         i3 = new ImageIcon ("Imagens/read.png");
    	 image3 = new JLabel(i3);
    	 container = getContentPane();
    	 
    	 
    	 txt1.setBounds(100, 85, 350, 45);
    	 email.setBounds(117, 140, 350, 45);
         nome.setBounds(117, 210, 350, 45);
         senha.setBounds(117, 280, 350, 45);
         btnCadastrar.setBounds(215, 340, 152, 45);
         btnVoltar.setBounds(230, 390, 120, 27);
         image3.setBounds(95, -60, 390, 320);
         
         btnCadastrar.setFont(fonte);
         btnVoltar.setFont(fonte2);
         nome.setFont(fonte1);
         senha.setFont(fonte1);
         email.setFont(fonte1);
         btnCadastrar.setBackground(Color.BLUE);
         btnCadastrar.setForeground(Color.WHITE);
         btnVoltar.setBackground(new Color(227,227,227));
         txt1.setFont(fonte3);
         nome.setForeground(Color.WHITE);
         senha.setForeground(Color.WHITE);
         email.setForeground(Color.WHITE);
         
         panel_1 = new JPanel();
         panel_1.setBounds(100, 242, 350, 2);
         getContentPane().add(panel_1);
         
         panel = new JPanel();
         panel.setBounds(100, 172, 350, 2);
         getContentPane().add(panel);
         
         panel_2 = new JPanel();
         panel_2.setBounds(100, 312, 350, 2);
         getContentPane().add(panel_2);
         getContentPane().add(txt1);
         getContentPane().add(nome);
         getContentPane().add(senha);
         getContentPane().add(email);
         getContentPane().add(btnVoltar);
         getContentPane().add(btnCadastrar);
         setVisible(true);
         btnVoltar.addActionListener (new ActionListener() {
        	 public void actionPerformed (ActionEvent e) {
        		 dispose();
        	 }
         });
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
          email.addFocusListener(new FocusListener() {
    			public void focusGained(FocusEvent g) {
    				if (email.getText().equals("Registre seu e-mail")) {
    			        email.setText("");
    					email.setForeground(Color.black);
    				}
    			}
    			public void focusLost(FocusEvent e) {
    				if (email.getText().isEmpty()) {
    					email.setText("Registre seu e-   mail");
    				    email.setForeground(Color.WHITE);
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
    public String getEmail() {
    	return email.getText();
    }
	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
	public void mensagemErro(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro ao cadastrar", JOptionPane.ERROR_MESSAGE);
	}
	public void addBtnCadastrar(ActionListener cadListener) {
		btnCadastrar.addActionListener(cadListener);
	}
	

}