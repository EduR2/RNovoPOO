package br.com.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.projeto.controller.LoginController.cadListener;
import br.com.projeto.model.bo.LembrarSenhaBO;
import br.com.projeto.model.vo.LembrarSenhaVO;
import br.com.projeto.view.LembrarSenhaView;
import br.com.projeto.view.TelaAcaodeADMView;
import br.com.projeto.view.TelaPrincipalView;

public class EdicaoADMController {
	private TelaAcaodeADMView view;
	private LembrarSenhaBO lembraBO;

	public EdicaoADMController(TelaAcaodeADMView view, Connection conexao) {
		this.view = view;
		lembraBO = new LembrarSenhaBO();
		view.editar(new editaListener());
	}

	class editaListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			String nome = view.getNome();
			String senha = view.getSenha();
			String email = view.getEmail();
			LembrarSenhaVO alterar = new LembrarSenhaVO();
			alterar.setEmail(email);
			alterar.setNome(nome);
			alterar.setSenha(senha);
			boolean alterado = lembraBO.alterarSenha(alterar);
			if (alterado == true) {
				view.mensagem("Alteração de senha efetuada");
				view.dispose();
			} else if (alterado == false) {
				view.mensagem("Alteração não foi feita\nVerifique se seu e-mail foi informado corretamente");

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
	}

}