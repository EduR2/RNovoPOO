package br.com.projeto.view;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.*;

public class AbrirRView {

    private static final int MAX_CHARACTERS_PER_LINE = 50;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AbrirRView::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Limited Width JTextPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextPane textPane = new JTextPane();
        textPane.setEditable(true);
        LimitedWidthDocument limitedDocument = new LimitedWidthDocument();
        textPane.setDocument(limitedDocument);

        JButton boldUnderlineButton = new JButton("Negrito Sublinhado");
        boldUnderlineButton.addActionListener(e -> applyBoldUnderline(textPane));
        boldUnderlineButton.setFocusPainted(false);
        boldUnderlineButton.setPreferredSize(new Dimension(120, 25));

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(textPane, BorderLayout.CENTER);
        panel.add(boldUnderlineButton, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(panel);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JButton underlineOrItalicButton = new JButton("Sublinhado / Itálico");
        underlineOrItalicButton.addActionListener(e -> applyItalicOrUnderline(textPane));
        underlineOrItalicButton.setFocusPainted(false);

        panel.add(underlineOrItalicButton, BorderLayout.NORTH);

        JComboBox comboBox = new JComboBox();
        panel.add(comboBox, BorderLayout.EAST);

        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        JComboBox<String> fontComboBox = new JComboBox<>(fontNames);
        fontComboBox.setSelectedItem("Arial");

        fontComboBox.addActionListener(e -> applyFont(textPane, (String) fontComboBox.getSelectedItem()));

        JPanel comboBoxPanel = new JPanel(new GridLayout(1, 1));
        comboBoxPanel.add(fontComboBox);
        panel.add(comboBoxPanel, BorderLayout.EAST);

        fontComboBox.setPreferredSize(new Dimension(50, 10));

        JButton saveToPdfButton = new JButton("Salvar em PDF");
        saveToPdfButton.addActionListener(e -> saveToPdf(textPane));
        saveToPdfButton.setFocusPainted(false);
        saveToPdfButton.setPreferredSize(new Dimension(120, 25));
        panel.add(saveToPdfButton, BorderLayout.WEST);

        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void applyFont(JTextPane textPane, String fontName) {
        StyledDocument doc = textPane.getStyledDocument();
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();

        if (start != end) {
            SimpleAttributeSet attrs = new SimpleAttributeSet();
            StyleConstants.setFontFamily(attrs, fontName);
            doc.setCharacterAttributes(start, end - start, attrs, false);
        }
    }

    private static void applyItalicOrUnderline(JTextPane textPane) {
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();

        if (start != end) {
            StyledDocument doc = textPane.getStyledDocument();
            Element element = (Element) doc.getCharacterElement(start);
            AttributeSet as = ((javax.swing.text.Element) element).getAttributes();

            boolean isUnderline = StyleConstants.isUnderline(as);

            SimpleAttributeSet attrs = new SimpleAttributeSet();
            if (isUnderline) {
                StyleConstants.setUnderline(attrs, false);
                StyleConstants.setItalic(attrs, true);
            } else {
                StyleConstants.setUnderline(attrs, true);
                StyleConstants.setItalic(attrs, false);
            }

            doc.setCharacterAttributes(start, end - start, attrs, false);
        }
    }

    private static void applyBoldUnderline(JTextPane textPane) {
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();

        if (start != end) {
            StyledDocument doc = textPane.getStyledDocument();
            SimpleAttributeSet attrs = new SimpleAttributeSet();

            StyleConstants.setBold(attrs, true);
            StyleConstants.setUnderline(attrs, true);

            doc.setCharacterAttributes(start, end - start, attrs, false);
        }
    }

    private static void saveToPdf(JTextPane textPane) {
        Document document = new Document();

        try {
            // Caminho do arquivo PDF
            String filePath = "C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\oasas0iuytrdter9AFDSFGGFHuyfdgfst.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 12);

            // Adiciona um parágrafo ao documento com a fonte especificada
            addParagraph(document, textPane.getText(), font);

            JOptionPane.showMessageDialog(null, "PDF gerado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar PDF!");
        } finally {
            document.close();
        }
    }

    private static void addParagraph(Document document, String text, Font font) throws Exception {
        Paragraph paragraph = new Paragraph();
        com.itextpdf.text.Font pdfFont = new com.itextpdf.text.Font(Font.FontFamily.TIMES_ROMAN, font.getSize());

        if (font.isBold() && font.isItalic()) {
            pdfFont.setStyle(com.itextpdf.text.Font.BOLDITALIC);
        } else if (font.isBold()) {
            pdfFont.setStyle(com.itextpdf.text.Font.BOLD);
        } else if (font.isItalic()) {
            pdfFont.setStyle(com.itextpdf.text.Font.ITALIC);
        }

        Chunk chunk = new Chunk(text, pdfFont);
        paragraph.add(chunk);
        document.add(paragraph);
    }

    private static class LimitedWidthDocument extends DefaultStyledDocument {
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (getLength() + str.length() <= MAX_CHARACTERS_PER_LINE) {
                super.insertString(offs, str, a);
            }
        }
    }
}

