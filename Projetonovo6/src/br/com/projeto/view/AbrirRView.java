package br.com.projeto.view;
import javax.swing.*;
import javax.swing.text.*;

import br.com.projeto.controller.LimitadorController;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class AbrirRView extends JFrame{
	
	public AbrirRView() {
		
		createAndShowGUI();
	}
		/**
		 * @wbp.parser.entryPoint
		 */


	    private static final int MAX_CHARACTERS_PER_LINE = 50;


	    private static void createAndShowGUI() {
	        JFrame frame = new JFrame("Read 7");
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


	        JTextPane textPane = new JTextPane();
	        textPane.setEditable(true);
	        LimitadorController limitedDocument = new LimitadorController();
	        textPane.setDocument(limitedDocument);

	        
	        ImageIcon icon = new ImageIcon("caminho/do/seu/icone.png");
	        JButton boldUnderlineButton = new JButton("Negrito Sublinhado",icon);
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

	        frame.setSize(598, 503);
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
	            Element element = doc.getCharacterElement(start);
	            AttributeSet as = element.getAttributes();

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
	    
	    
}