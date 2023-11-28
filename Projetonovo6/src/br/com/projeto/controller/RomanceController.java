package br.com.projeto.controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.projeto.controller.AcaoController.listener;
import br.com.projeto.controller.AcaoController.listener2;
import br.com.projeto.controller.AcaoController.listener3;
import br.com.projeto.controller.AcaoController.salvarListener;
import br.com.projeto.controller.CadastroController.cadListener;
import br.com.projeto.model.bo.CadastroBO;
import br.com.projeto.model.dao.AcaoDAO;
import br.com.projeto.model.dao.TerrorDAO;
import br.com.projeto.model.dao.RomanceDAO;
import br.com.projeto.model.vo.CadastroVO;
import br.com.projeto.view.AcaoView;
import br.com.projeto.view.CadastroView;
import br.com.projeto.view.TerrorView;
import br.com.projeto.view.FiccaoView;
import br.com.projeto.view.RomanceView;
import br.com.projeto.view.TelaADMView;

import br.com.projeto.model.vo.GenerosVO;
import br.com.projeto.model.bo.GenerosBO;

public class RomanceController {
	private RomanceView view;
	private AcaoDAO acDAO;
	public RomanceController(RomanceView view, Connection conexao) {
		this.view = view;
		this.acDAO = new AcaoDAO();
		view.addBtnPegaTxt(new listener());
		view.addBtnPegaTxt2(new listener2());
		view.addBtnPegaTxt3(new listener3());
		view.addBtnSalvar(new salvarListener());
	}

	class listener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			try {
				String caminhoArq = "C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\ProjetoNovo6\\Livros\\O Alienista.pdf";
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					File file = new File(caminhoArq);
					if (file.exists()) {
						desktop.open(file);
					} else {
						System.out.println("O arquivo não existe");
					}
				}
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "ERRO");
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
					//view.setTexto(texto);
					view.setClassificacao("Romance");
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
					//view.setTexto(texto);
					view.setClassificacao("Romance");
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
	class salvarListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			String titulo = view.getTitulo();
			String autor = view.getAutor();
			String texto = view.getTexto();
			String classi = view.getClassificacao();
			GenerosVO acaoVO = new GenerosVO();
			acaoVO.setTitulo(titulo);
			acaoVO.setAutor(autor);
			acaoVO.setTexto(texto);
			acaoVO.setClassificao(classi);
			GenerosBO acaoBO = new GenerosBO();
			String fonte = view.getFonteName();
			boolean Negrito = view.getSelectNegrito();
			boolean Itálico = view.getSelectItalico();
			java.awt.Font fonteSize = view.getFont();
			int tamanho = fonteSize.getSize();
			boolean inserido = acaoBO.InserirAcao(acaoVO);
			if(inserido) {
				generatePDF("Título: "+titulo+"\n" , "Autor: "+autor+"\n", "------------------------------------------------------------------------------------------------------------------------------\nResumo:\n\n", texto, fonte, tamanho, Negrito, Itálico);
				view.mensagem("Texto Salvo");
			}else {
				view.mensagem("Texto não salvo");
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
	public static void generatePDF(String titulo, String content, String content2, String content3, String fonte, int fontesize, boolean Negrito, boolean Itálico) {
		Document document = new Document();
		try {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Salve seu resumo");
			int userSelection = fileChooser.showSaveDialog(fileChooser);
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				String filePath = fileChooser.getSelectedFile().getAbsolutePath() + ".pdf";
				PdfWriter.getInstance(document, new FileOutputStream(filePath));
				document.open();
				Font fonteResumo = new Font(FontFamily.valueOf(fonte), fontesize, (Negrito ? Font.BOLD : 0)| (Itálico ? Font.ITALIC : 0));
				Chunk resumoComFonte = new Chunk(content3, fonteResumo);
				Phrase phrase = new Phrase();
				phrase.add(new Chunk(content3, fonteResumo));
				phrase.setFont(fonteResumo);
				document.add(new Paragraph (titulo));
				document.add(new Paragraph(content));
				document.add(new Paragraph(content2));
				document.add(phrase);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally	{
			document.close();
		}
	}
	
}
