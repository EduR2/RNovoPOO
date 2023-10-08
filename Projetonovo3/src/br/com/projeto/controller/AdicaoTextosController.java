 package br.com.projeto.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.projeto.controller.GenerosController.listener;
import br.com.projeto.controller.GenerosController.listener2;
import br.com.projeto.controller.GenerosController.listener3;
import br.com.projeto.controller.GenerosController.salvarListener;
import br.com.projeto.model.dao.AcaoDAO;
import br.com.projeto.view.AcaoView;
import br.com.projeto.view.EdicaoTextoADMView;

public class AdicaoTextosController {
	private EdicaoTextoADMView view;
	private AcaoDAO acDAO;
	public AdicaoTextosController(EdicaoTextoADMView view, Connection conexao) {
		this.view = view;
		this.acDAO = new AcaoDAO();
		view.addBtnPegaTxt(new listener());
		view.addBtnPegaTxt2(new listener2());
		view.addBtnPegaTxt3(new listener3());
		//view.addBtnSalvar(new salvarListener());
	}

	class listener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			ResultSet resultado = acDAO.Leitura();
			try {
				if (resultado.next()) {
					String texto = resultado.getNString("texto");
					view.setTexto(texto);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();			
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
	class listener2 implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			ResultSet resultado = acDAO.Leitura2();
			try {
				if (resultado.next()) {
					String texto = resultado.getNString("texto");
					view.setTexto(texto);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
	class listener3 implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			ResultSet resultado = acDAO.Leitura3();
			try {
				if (resultado.next()) {
					String texto = resultado.getNString("texto");
					view.setTexto(texto);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
