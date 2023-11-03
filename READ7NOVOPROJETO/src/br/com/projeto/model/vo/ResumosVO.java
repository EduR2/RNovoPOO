package br.com.projeto.model.vo;

public class ResumosVO {
	private String oldResumo;
	private String resumo;
	private String oldTitulo;
	public String getOldTitulo() {
		return oldTitulo;
	}
	public void setOldTitulo(String oldTitulo) {
		this.oldTitulo = oldTitulo;
	}
	private String titulo;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getOldResumo() {
		return oldResumo;
	}
	public void setOldResumo(String oldResumo) {
		this.oldResumo = oldResumo;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

}