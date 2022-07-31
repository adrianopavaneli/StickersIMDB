package main;

public class Conteudo {
	
	private String titulo;
	private String urlImagem;
	private String ano;
	private String nota;
	
	
	public Conteudo(String titulo, String urlImagem, String ano, String nota) {
		
		this.titulo = titulo;
		this.urlImagem = urlImagem;
		this.ano = ano;
		this.nota = nota;
	}


	public Conteudo(String titulo, String urlImagem) {
		this.nota = null;
		this.titulo = titulo;
		this.urlImagem = urlImagem;
		this.ano = null;
	}


	public String getTitulo() {
		return titulo;
	}


	public String getUrlImagem() {
		return urlImagem;
	}


	public String getAno() {
		return ano;
	}


	public String getNota() {
		return nota;
	}
	
	
	
	
	
	
	
	

}
