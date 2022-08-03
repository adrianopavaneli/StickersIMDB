package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Figurinhas {

	public void cria(InputStream impuStream, String nomeArquivo, double nota) throws Exception {

		// Leitura de imagem
		BufferedImage imagemOriginal = ImageIO.read(impuStream);
		// Padronização tamanho da imagem
		Image imagemMenor = imagemOriginal.getScaledInstance(674, 1000, Image.SCALE_DEFAULT);

		// cria nova imagem em memoria com transparencia
		// Largura irá pegar toda a largura da imagem inicial
		int width = imagemMenor.getWidth(null);
		// Altura irá pegar toda a altura da imagem inicial
		int height = imagemMenor.getHeight(null);
		// novaAltura irá pegar toda a altura e adicionar mais 200PX
		int newHeight = height + 200;
		BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
		// copiar a imagem original para a nova imagem
		Graphics2D graphics = (Graphics2D) newImage.getGraphics();

		graphics.drawImage(imagemMenor, 0, 0, null);

		// Pegando a Fonte e adicionando no tamanho 80

		File folder = new File("C:\\Temp\\ws-eclipse\\StickersIMDB\\folderfonts\\impact.ttf");
		Font novaFont = Font.createFont(Font.LAYOUT_LEFT_TO_RIGHT, folder);

		if (nota >= 9.0) {
			// Vamos selecionar o tamanho com o deriveFont, não é necessário mudar o
			// alinhamento
			novaFont = novaFont.deriveFont(Font.LAYOUT_NO_LIMIT_CONTEXT, 80);
			graphics.setColor(Color.YELLOW);
			graphics.setFont(novaFont);
			graphics.drawString("ESPETACULAR", 50, newHeight - 100);

			// Colocando borda do texto
			FontRenderContext fontRenderContext = graphics.getFontRenderContext();

			// Passando a frase da borda e fonte, conteudo já renderizado
			TextLayout textLayout = new TextLayout("ESPETACULAR", graphics.getFont(), fontRenderContext);
			// pegando a borda
			Shape outline = textLayout.getOutline(null);
			// criando uma transformação no mesmo local da fonte
			AffineTransform transform = graphics.getTransform();
			AffineTransform nova = graphics.getTransform();
			transform.translate(50, (int) (newHeight - 100));
			// Setando a borda no mesmo local
			graphics.setTransform(transform);

			// Salvando as informações originais para usar na imagem
			var outlineAntiga = graphics.getStroke();
			var clipe = graphics.getClip();
			// Tamanho da borda
			var outlineStroke = new BasicStroke(width * 0.004166f);
			graphics.setStroke(outlineStroke);
			// Setando a cor da borda
			graphics.setColor(Color.BLACK);
			graphics.draw(outline);
			graphics.setClip(outline);
			// Pegando a imagem na pasta raiz
			File figura = new File("C:\\Temp\\ws-eclipse\\StickersIMDB\\figura\\aprovado.png");
			BufferedImage figuraAprovado = ImageIO.read(figura);
			Image figuraFinal = figuraAprovado.getScaledInstance(160, 160, Image.SCALE_DEFAULT);
			// Colocando a largura
			width = 480;
			// Colocando a altura
			newHeight = (int) (newHeight - 180);
			// setando a graphics com informações originais
			graphics.setStroke(outlineAntiga);
			graphics.setTransform(nova);
			graphics.setClip(clipe);
			graphics.drawImage(figuraFinal, width, newHeight, null);

		}
		if (nota >= 8.8 && nota < 9.0) {
			// Vamos selecionar o tamanho com o deriveFont, não é necessário mudar o
			// alinhamento
			novaFont = novaFont.deriveFont(Font.LAYOUT_NO_LIMIT_CONTEXT, 100);
			graphics.setColor(Color.YELLOW);
			graphics.setFont(novaFont);
			graphics.drawString("OTIMO", 160, newHeight - 100);

			// Colocando borda do texto
			FontRenderContext fontRenderContext = graphics.getFontRenderContext();

			// Passando a frase da borda e fonte, conteudo já renderizado
			TextLayout textLayout = new TextLayout("OTIMO", graphics.getFont(), fontRenderContext);
			// pegando a borda
			Shape outline = textLayout.getOutline(null);
			// criando uma transformação no mesmo local da fonte
			AffineTransform transform = graphics.getTransform();
			AffineTransform nova = graphics.getTransform();
			transform.translate(160, (int) (newHeight - 100));
			// Setando a borda no mesmo local
			graphics.setTransform(transform);

			// Salvando as informações originais para usar na imagem
			var outlineAntiga = graphics.getStroke();
			var clipe = graphics.getClip();
			// Tamanho da borda
			var outlineStroke = new BasicStroke(width * 0.004166f);
			graphics.setStroke(outlineStroke);
			// Setando a cor da borda
			graphics.setColor(Color.BLACK);
			graphics.draw(outline);
			graphics.setClip(outline);
			// Pegando a imagem na pasta raiz
			File figura = new File("C:\\Temp\\ws-eclipse\\StickersIMDB\\figura\\aprovado.png");
			BufferedImage figuraAprovado = ImageIO.read(figura);
			Image figuraFinal = figuraAprovado.getScaledInstance(160, 160, Image.SCALE_DEFAULT);
			// Colocando a largura
			width = 420;
			// Colocando a altura
			newHeight = (int) (newHeight - 210);
			// setando a graphics com informações originais
			graphics.setStroke(outlineAntiga);
			graphics.setTransform(nova);
			graphics.setClip(clipe);
			graphics.drawImage(figuraFinal, width, newHeight, null);
		}

		if (nota < 8.8) {
//			//Vamos selecionar o tamanho com o deriveFont, não é necessário mudar o alinhamento
			novaFont = novaFont.deriveFont(Font.LAYOUT_NO_LIMIT_CONTEXT, 100);
			graphics.setColor(Color.YELLOW);
			graphics.setFont(novaFont);
			graphics.drawString("MUITO BOM", 50, newHeight - 100);

			// Colocando borda do texto
			FontRenderContext fontRenderContext = graphics.getFontRenderContext();

			// Passando a frase da borda e fonte, conteudo já renderizado
			TextLayout textLayout = new TextLayout("MUITO BOM", graphics.getFont(), fontRenderContext);
			// pegando a borda
			Shape outline = textLayout.getOutline(null);
			// criando uma transformação no mesmo local da fonte
			AffineTransform transform = graphics.getTransform();
			AffineTransform nova = graphics.getTransform();
			transform.translate(50, (int) (newHeight - 100));
			// Setando a borda no mesmo local
			graphics.setTransform(transform);

			// Salvando as informações originais para usar na imagem
			var outlineAntiga = graphics.getStroke();
			var clipe = graphics.getClip();
			// Tamanho da borda
			var outlineStroke = new BasicStroke(width * 0.004166f);
			graphics.setStroke(outlineStroke);
			// Setando a cor da borda
			graphics.setColor(Color.BLACK);
			graphics.draw(outline);
			graphics.setClip(outline);
			// Pegando a imagem na pasta raiz
			File figura = new File("C:\\Temp\\ws-eclipse\\StickersIMDB\\figura\\aprovado.png");
			BufferedImage figuraAprovado = ImageIO.read(figura);
			Image figuraFinal = figuraAprovado.getScaledInstance(160, 160, Image.SCALE_DEFAULT);
			// Colocando a largura
			width = 500;
			// Colocando a altura
			newHeight = (int) (newHeight - 210);
			// setando a graphics com informações originais
			graphics.setStroke(outlineAntiga);
			graphics.setTransform(nova);
			graphics.setClip(clipe);
			graphics.drawImage(figuraFinal, width, newHeight, null);
		}

		// cria a imagem na pasta de saida
		ImageIO.write(newImage, "png", new File(nomeArquivo));

	}
}
