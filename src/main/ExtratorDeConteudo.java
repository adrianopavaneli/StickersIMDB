package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudo {
	
	public List<Conteudo> extrairConteudos(String json){
		JsonParser parser = new JsonParser();
		List<Map<String, String>> listaDeAtributos = parser.parse(json);
		List<Conteudo> conteudos = new ArrayList<>();
		
		for(Map<String, String> atributos : listaDeAtributos) {
			String titulo = atributos.get("title");
			String ano = atributos.get("year");
			String nota = atributos.get("imDbRating");
			
			String urlImagem = atributos.get("image")
					.replaceAll("(@+)(.*).jpg$", "$1.jpg");
			Conteudo conteudo = new Conteudo(titulo, urlImagem, ano, nota);
			conteudos.add(conteudo);
		}
		return conteudos;
	}
	
	

}
