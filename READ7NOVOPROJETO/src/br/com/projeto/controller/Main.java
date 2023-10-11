package br.com.projeto.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

import br.com.projeto.view.*;
public class Main {
	public static void main (String[]args) {
		try {
			String url = "jdbc:mysql://localhost:3306/BD";
			Connection conexao = DriverManager.getConnection(url, "root", "Hr102206");
			TelaBemVindoView tela = new TelaBemVindoView();
			tela.setVisible(true);
			Thread.sleep(3000);
			tela.setVisible(false);
			LoginView view = new LoginView();
			LoginController controle = new LoginController (view, conexao);
			view.setResizable(false);
			view.setVisible(true);
			}catch (Exception e) {}
		
		

	
	}
}

