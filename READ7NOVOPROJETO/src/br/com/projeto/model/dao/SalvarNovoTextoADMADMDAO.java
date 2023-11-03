package br.com.projeto.model.dao;

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
	public boolean insereNewTexto(String texto, String novoTexto) {
		try {
			Connection conexao = DriverManager.getConnection (url, "root", "root");
			String sql = "UPDATE Texto SET texto = ? WHERE texto LIKE ?";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, novoTexto);
			statement.setString(2, texto);
			int retorno = statement.executeUpdate();
			return retorno>0;
		} catch (SQLException e) {
			return false;
		}
	}
}