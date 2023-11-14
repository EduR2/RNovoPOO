package br.com.projeto.model.vo;

public class TextosVO {
	private String classificação;
	private String texto;
	private String novoTexto;
	public String getNovoTexto() {
		return novoTexto;
	}
	public void setNovoTexto(String novoTexto) {
		this.novoTexto = novoTexto;
	}
	public String getClassificação() {
		return classificação;
	}
	public void setClassificação(String classificação) {
		this.classificação = classificação;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}

}
