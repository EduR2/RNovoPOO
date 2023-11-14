package br.com.projeto.model.vo;

import java.awt.Window.Type;

public class TextosVO {
	private String classificação;
	private String texto;
	private Type novoTexto;
	public Type getNovoTexto() {
		return novoTexto;
	}
	public void setNovoTexto(Type newTexto) {
		this.novoTexto = newTexto;
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
	public void setTexto(String coluna1) {
		this.texto = coluna1;
	}

}