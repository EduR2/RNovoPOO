package br.com.projeto.model.dao;

import java.awt.Window.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalvarNovoTextoADMADMDAO {
	private Connection conexao;
	private String url = "jdbc:mysql://localhost:3306/BD";
	public SalvarNovoTextoADMADMDAO (Connection conexao) {
		this.conexao = conexao;
	}
	public boolean insereNewTexto(String type, String type2) {
		try {
			Connection conexao = DriverManager.getConnection (url, "root", "root");
			String sql = "UPDATE Texto SET texto = ? WHERE texto LIKE ?";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, type2);
			statement.setString(2, type);
			int retorno = statement.executeUpdate();
			return retorno>0;
		} catch (SQLException e) {
			return false;
		}
	}
	public boolean insereNewTexto(Type texto, Type texto2) {
		// TODO Auto-generated method stub
		return false;
	}
}