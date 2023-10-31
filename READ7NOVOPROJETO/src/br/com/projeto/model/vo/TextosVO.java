package br.com.projeto.model.vo;

import java.awt.Window.Type;

public class TextosVO {
	private String classificação;
	private Type texto;
	public String getClassificação() {
		return classificação;
	}
	public void setClassificação(String classificação) {
		this.classificação = classificação;
	}
	public Type getTexto() {
		return texto;
	}
	public void setTexto(Type newTexto) {
		this.texto = newTexto;
	}
	public void setTexto(String coluna1) {
		// TODO Auto-generated method stub
		
	}

}