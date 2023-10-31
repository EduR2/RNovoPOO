package br.com.projeto.model.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.projeto.model.dao.LembraSenhaDAO;
import br.com.projeto.model.dao.EdiçãoResumoDAO;
import br.com.projeto.model.vo.LembrarSenhaVO;
import br.com.projeto.model.vo.LoginVO;
import br.com.projeto.model.vo.ResumosVO;
import br.com.projeto.model.vo.TextosVO;
public class ResumosBO {
	private EdiçãoResumoDAO ediçãoDAO;
	private Connection conexao;
	public ResumosBO() {
		ediçãoDAO= new EdiçãoResumoDAO();
	}
	
	public boolean textoAtualizado(ResumosVO resumo) {
		return ediçãoDAO.alterarResumo(resumo.getOldTitulo(), resumo.getTitulo(), resumo.getOldResumo(),  resumo.getResumo());
	}
}
