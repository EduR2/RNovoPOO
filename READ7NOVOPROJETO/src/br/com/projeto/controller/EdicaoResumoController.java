package br.com.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.projeto.controller.LembrarSenhaController.lembraListener;
import br.com.projeto.model.bo.CadastroBO;
import br.com.projeto.model.bo.LembrarSenhaBO;
import br.com.projeto.model.bo.ResumosBO;
import br.com.projeto.model.vo.CadastroVO;
import br.com.projeto.model.vo.LembrarSenhaVO;
import br.com.projeto.view.CadastroView;
import br.com.projeto.view.LembrarSenhaView;
import br.com.projeto.view.TelaADMView;
import br.com.projeto.view.TelaEdicaoResumoView;
import br.com.projeto.view.TelaLeituraView;
import br.com.projeto.model.vo.ResumosVO;

public class EdicaoResumoController{
	
	
	private TelaEdicaoResumoView view;
	private TelaADMView view2;
	private ResumosBO resumosBO;
	public EdicaoResumoController (TelaEdicaoResumoView view, Connection conexao) {
		this.view = view;
		resumosBO = new ResumosBO ();
		view.addBtnSalvar(new listener());
	}
	class listener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			String titulo_old = view.getTitulo();
			String titulo_novo = view.getNewTitulo();
			String oldResumo = view.getTexto();
			String resumo = view.getNewTexto();
			ResumosVO resumos = new ResumosVO();
			resumos.setTitulo(titulo_novo);
			resumos.setOldTitulo(titulo_old);
			resumos.setOldResumo(oldResumo);
			resumos.setResumo(resumo);
          	 boolean alterado = resumosBO.textoAtualizado(resumos);
          	 if (alterado) {
          		 view.mensagem("Alteração Efetuada");
          	 	 view.dispose();
          	 } else {
          	 JOptionPane.showMessageDialog(null, "Erro ao editar o resumo.");
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