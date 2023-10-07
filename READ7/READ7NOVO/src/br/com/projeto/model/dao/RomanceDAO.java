package br.com.projeto.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.projeto.model.vo.GenerosVO;

public class RomanceDAO {
	private Connection conexao;
	private String url = "jdbc:mysql://localhost:3306/BD";

	public ResultSet Leitura() {
	    try {
	    	 Connection conexao = DriverManager.getConnection(url, "root", "root");
	    	 String sql = "SELECT texto FROM Texto WHERE ID_TEXTO = 10";
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
	    	 String sql = "SELECT texto FROM Texto WHERE ID_TEXTO = 11";
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
	    	 String sql = "SELECT texto FROM Text WHERE ID_TEXTO = 12";
    		 PreparedStatement statement = conexao.prepareStatement(sql);
    		 ResultSet resultado = statement.executeQuery();
    		 return resultado;
	    } catch (SQLException slcte) {
	        return null;
	    }
	}

	public boolean InserirRomance(GenerosVO inserirAcao) {
		try {
			Connection conexao = DriverManager.getConnection (url, "root", "root");
			String sql = "INSERT INTO Genero(ID_GENERO, emailAutor, Título, Resumo) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, inserirAcao.getId());
			statement.setString(2, inserirAcao.getAutor());
			statement.setString(3, inserirAcao.getTitulo());
			statement.setString(4, inserirAcao.getTexto());
			int rowsAffected = statement.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            return false;
	        }
	}
}
