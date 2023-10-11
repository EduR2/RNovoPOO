package br.com.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;

import br.com.projeto.model.bo.ADMBO;
import br.com.projeto.model.dao.ConexaoDAO;
import br.com.projeto.model.vo.ADMVO;
import br.com.projeto.view.ConfiguracoesView;
import br.com.projeto.view.ExclusaoView;
import br.com.projeto.view.LoginView;
import br.com.projeto.view.TelaPrincipalView;
import br.com.projeto.view.TelaAcaodeADMView;

public class ExclusaoController {
	private ExclusaoView view;
	private ADMBO admBO;
	private ConexaoDAO conexao;
	public ExclusaoController(ExclusaoView view, Connection conexao) {
		this.view = view;
		admBO = new ADMBO();
		view.addExcluir(new excluirListener());
	}
	class excluirListener implements MouseListener{

		@Override
		public void mouseClicked
		(MouseEvent e) {
			 	 String email = view.getEmail();
	          	 ADMVO removeLogin = new ADMVO();
	          	 ADMVO removeLogin2 = new ADMVO();
	          	 removeLogin.setEmail(email);
	          	 removeLogin2.setEmail(email);
	          	 boolean removidoUsuario = admBO.removeLogin(removeLogin);
	          	 boolean removidoResumo = admBO.removeLogin2(removeLogin2);
	          	 if (removidoUsuario == true && removidoResumo == true) {
	          		view.mensagem("Conta Removida");
	          		view.mensagem("Seus dados foram removidos juntamente com o seus resumos\nFoi bom ter você conosco.");
	          		System.exit(0);
	          	 	 
	          	 } else if (removidoUsuario == false && removidoResumo == false){
	          		 view.mensagemErro("Erro ao remover conta");
	          	}else if (removidoUsuario == true && removidoResumo == false);
	          	view.mensagem("Conta Removida");
          		
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