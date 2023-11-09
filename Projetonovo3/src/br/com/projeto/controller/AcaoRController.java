package br.com.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import br.com.projeto.controller.GenerosController.listener;
import br.com.projeto.controller.GenerosController.salvarListener;
import br.com.projeto.model.dao.AcaoDAO;
import br.com.projeto.model.dao.AcaoRDAO;
import br.com.projeto.model.dao.ConexaoDAO;
import br.com.projeto.model.vo.GenerosVO;
import br.com.projeto.view.TelaRAcaoView;
import br.com.projeto.view.AcaoView;

public class AcaoRController {
	private TelaRAcaoView view;
	private AcaoRDAO acrDAO;
	private ConexaoDAO conexao;

	public AcaoRController(TelaRAcaoView view, Connection conexao) {
		this.view = view;
		this.acrDAO = new AcaoRDAO();
		view.addtxtAutor(new listener3());
	}
		class listener3 implements DocumentListener{

			@Override
			public void insertUpdate(DocumentEvent e) {
				String email = view.getAutor();
				List<GenerosVO> generos = acrDAO.buscarGenerosEmail(email);
				view.tabela(generos);
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String email = view.getAutor();
				List<GenerosVO> generos = acrDAO.buscarGenerosEmail(email);
				view.tabela(generos);
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				String email = view.getAutor();
				List<GenerosVO> generos = acrDAO.buscarGenerosEmail(email);
				view.tabela(generos);
				
			}
			
		}
}	