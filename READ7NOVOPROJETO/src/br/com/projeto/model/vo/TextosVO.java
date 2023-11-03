package br.com.projeto.model.vo;

import java.awt.Window.Type;

public class TextosVO {
	private String classificação;
	private Type texto;
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
	public Type getTexto() {
		return texto;
	}
	public void setTexto(Type texto2) {
		this.texto = texto2;
	}

}