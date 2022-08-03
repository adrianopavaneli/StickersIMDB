package application;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import main.ClienteHttp;
import main.Conteudo;
import main.ExtratorDeConteudo;
import main.Figurinhas;

public class Program {

	public static void main(String[] args) throws Exception {
		
		Properties config = Prop();
		
		String url = "https://imdb-api.com/en/API/Top250Movies/" + config.get("key");
		
		ExtratorDeConteudo extrator = new ExtratorDeConteudo();
		
		ClienteHttp http = new ClienteHttp();
		String json = http.buscarDados(url);
		
		
		List<Conteudo> conteudos = extrator.extrairConteudos(json);
		
		Figurinhas geradora = new Figurinhas();
		
		for(int i = 0; i < 250; i++) {
			Conteudo conteudo = conteudos.get(i);
			InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			String nomeArquivo = "imagens/" + conteudo.getTitulo() + ".png"; 
			String notaString = conteudo.getNota();
			double nota = Double.parseDouble(notaString);
			
			
		
			geradora.cria(inputStream, nomeArquivo, nota);
			
			System.out.println("\u001b[36;1m\u001b[47;3m\u001b[1m\u001b[3mTítulo: \u001b[m" + conteudo.getTitulo());
			System.out.println("\u001b[36;1m\u001b[47;3m\u001b[1m\u001b[3mAno: \u001b[m" + conteudo.getAno());
			System.out.println("\u001b[33;1m\u001b[47;3mClassificação:\u001b[m" + " " + conteudo.getNota());
			
			float notafilme = Float.parseFloat(conteudo.getNota());
			String estrelas = "";
			for(int j = 0; j< notafilme; j++) {
				estrelas = estrelas + "\u2B50";
			}
			
			System.out.println(estrelas);
			System.out.println();
			
			
			
		}
		
		
		}
	public static Properties Prop() throws Exception{
		Properties config = new Properties();
		FileInputStream file = new FileInputStream("config.properties");
		config.load(file);
		return config;

	}

}
