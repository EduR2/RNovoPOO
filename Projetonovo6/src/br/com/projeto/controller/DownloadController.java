package br.com.projeto.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.projeto.view.TelaLeituraView;

public class DownloadController {
	private TelaLeituraView view;
	public DownloadController(TelaLeituraView view) {
		this.view = view;
		view.addBtnDownload(new download());
	}
	class download implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			String titulo = view.pegaTitutlo();
			String autor = view.pegaAutor();
			String resumo = view.pegaResumo();
			generatePDF("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\'"+titulo+"'", "\n"+autor+"\n\n", "Resumo:\n", resumo);
			JOptionPane.showMessageDialog(null, "Download concluído");
			
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
	public static void generatePDF(String fileName, String content, String content2, String content3) {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(fileName));
			document.open();
			document.add(new Paragraph(content));
			document.add(new Paragraph(content2));
			document.add(new Paragraph(content3));
		}catch(Exception e) {
			e.printStackTrace();
		}finally	{
			document.close();
		}
	}

}
