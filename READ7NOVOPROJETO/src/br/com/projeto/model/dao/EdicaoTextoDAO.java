package br.com.projeto.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projeto.model.vo.GenerosVO;
import br.com.projeto.model.vo.TextosVO;

public class EdicaoTextoDAO {

	public List<TextosVO> buscarTextosGen(String classi) {
		List<TextosVO> txt = new ArrayList<>();
		 try {
	    	 Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/BD", "root", "root");
	    	 String sql = "SELECT texto, Classificação_texto FROM Texto WHERE Classificação_texto = ?";
    		 PreparedStatement statement = conexao.prepareStatement(sql);
    		 statement.setString(1, classi);
    		 ResultSet resultado = statement.executeQuery();
    		 while(resultado.next()) {
    			 String coluna1 = resultado.getString("texto");
    			 String coluna2 = resultado.getString("Classificação_texto");
    			 TextosVO tvo = new TextosVO();
    			 tvo.setTexto(coluna1);
    			 tvo.setClassificação(coluna2);
    			 txt.add(tvo);
    		 }
	    } catch (SQLException slcte) {
	        return null;
	    }
		 return txt;


	}

}