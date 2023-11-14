package br.com.projeto.model.bo;

import br.com.projeto.model.dao.ADMDAO;
import br.com.projeto.model.vo.LembrarSenhaVO;
import br.com.projeto.model.dao.EdicaoADMDATADAO;

public class AlteracaoDeDadosADMBO {
	private EdicaoADMDATADAO admDAO;
	public AlteracaoDeDadosADMBO() {
		admDAO = new EdicaoADMDATADAO();
	}
	public boolean alteraADM (LembrarSenhaVO alteraADM) {
		return admDAO.alterarSenha(alteraADM);
	}
}


