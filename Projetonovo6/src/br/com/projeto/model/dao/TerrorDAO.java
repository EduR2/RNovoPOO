package br.com.projeto.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.projeto.model.vo.GenerosVO;

public class TerrorDAO {
	private Connection conexao;
	private String url = "jdbc:mysql://localhost:3306/BD";
	public ResultSet Leitura() {
	    try {
	    	 Connection conexao = DriverManager.getConnection(url, "root", "root");
	    	 String sql = "SELECT texto FROM Texto WHERE ID_TEXTO = 4";
    		 PreparedStatement statement = conexao.prepareStatement(sql);
    		 ResultSet resultado = statement.executeQuery();
    		 return resultado;
	    } catch (SQLException slcte) {
	        return null;
	    }
	}
	public ResultSet Leitura2() {
	    try {
	    	 Connection conexao = DriverManager.getConnection(url, "root", "root");
	    	 String sql = "SELECT texto FROM Texto WHERE ID_TEXTO = 5";
    		 PreparedStatement statement = conexao.prepareStatement(sql);
    		 ResultSet resultado = statement.executeQuery();
    		 return resultado;
	    } catch (SQLException slcte) {
	        return null;
	    }
	}
	public ResultSet Leitura3() {
	    try {
	    	 Connection conexao = DriverManager.getConnection(url, "root", "root");
	    	 String sql = "SELECT texto FROM Text WHERE ID_TEXTO = 6";
    		 PreparedStatement statement = conexao.prepareStatement(sql);
    		 ResultSet resultado = statement.executeQuery();
    		 return resultado;
	    } catch (SQLException slcte) {
	        return null;
	    }
	}
	public boolean InserirTerror(GenerosVO inserirAcao) {
		try {
			Connection conexao = DriverManager.getConnection (url, "root", "root");
			String sql = "INSERT INTO Resumos(emailAutor, Título, TextoUsuario, Classificação_resumo) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, inserirAcao.getAutor());
			statement.setString(2, inserirAcao.getTitulo());
			statement.setString(3, inserirAcao.getTexto());
			statement.setString(4, inserirAcao.getClassificao());
			int rowsAffected = statement.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            return false;
	        }
	}
}
