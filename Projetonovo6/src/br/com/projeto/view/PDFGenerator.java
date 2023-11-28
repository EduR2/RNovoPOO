package br.com.projeto.view;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import javax.swing.text.Caret;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;

public class PDFGenerator extends JFrame {

    private JTextArea textArea;

    public PDFGenerator() {
        initializeUI();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("PDF Generator");

        // Layout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Componentes
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        JButton boldButton = new JButton("Negrito");
        boldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aplicarNegrito();
            }
        });
        add(boldButton);

        JButton saveButton = new JButton("Salvar PDF");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarPDF();
            }
        });
        add(saveButton);

        // Empacota e define visibilidade
        pack();
        setLocationRelativeTo(null); // Centraliza a janela
        setVisible(true);
    }

    private void aplicarNegrito() {
        Font fontNegrito = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        textArea.setCaret((Caret) fontNegrito);
    }

    private void salvarPDF() {
        String texto = textArea.getText();

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("saida.pdf"));
            document.open();

            java.awt.Font font = textArea.getFont();
            Paragraph paragraph = new Paragraph(texto);

            document.add(paragraph);

            JOptionPane.showMessageDialog(this, "PDF gerado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao gerar PDF!");

        } finally {
            document.close();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PDFGenerator();
            }
        });
    }
}

