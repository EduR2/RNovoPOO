package br.com.projeto.model.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.projeto.model.dao.LembraSenhaDAO;
import br.com.projeto.model.dao.SalvarNovoTextoADMADMDAO;
import br.com.projeto.model.vo.LembrarSenhaVO;
import br.com.projeto.model.vo.LoginVO;
import br.com.projeto.model.vo.TextosVO;
public class TextoADMBO {
	private SalvarNovoTextoADMADMDAO UpdateDAO;
	private Connection conexao;
	public TextoADMBO() {
		UpdateDAO = new SalvarNovoTextoADMADMDAO(conexao);
	}
	
	public boolean textoAtualizado(TextosVO texto) {
		return UpdateDAO.insereNewTexto(texto.getTexto(), texto.getNovoTexto());
	}
}
