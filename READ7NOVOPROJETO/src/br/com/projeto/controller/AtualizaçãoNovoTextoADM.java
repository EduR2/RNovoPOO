package br.com.projeto.controller;

import java.awt.Window.Type;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.projeto.model.bo.TextoADMBO;
import br.com.projeto.model.vo.TextosVO;
import br.com.projeto.view.TelaEdicaodeTextoADMView;

public class AtualizaçãoNovoTextoADM{
	private TelaEdicaodeTextoADMView view;
	private TextoADMBO txtBO;
	public AtualizaçãoNovoTextoADM(TelaEdicaodeTextoADMView view, Connection conexao) {
		this.view = view;
		txtBO = new TextoADMBO();
		view.addBtnSalvar(new listener());
	}
	class listener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			Type texto = view.getNewTexto();
			Type newTexto = view.getNewTexto();
			TextosVO newtxtVO = new TextosVO();

			boolean alterado = txtBO.textoAtualizado(newtxtVO);
			if (alterado == true) {
				view.mensagem("Texto alterado");
			}else if (alterado == false){
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