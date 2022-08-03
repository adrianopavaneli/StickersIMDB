package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Figurinhas {

	
	public void cria(InputStream impuStream, String nomeArquivo, double nota) throws Exception{
		BufferedImage imagemOriginal = ImageIO.read(impuStream);
		Image imagemMenor = imagemOriginal.getScaledInstance(674, 1000, Image.SCALE_DEFAULT);
		
		int width = imagemMenor.getWidth(null);
		int height = imagemMenor.getHeight(null);
		int newHeight = height + 200;
		BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
		
		
					
		Graphics2D graphics = (Graphics2D) newImage.getGraphics();

		graphics.drawImage(imagemMenor, 0, 0, null);
		
		File folder = new File("C:\\Temp\\ws-eclipse\\StickersIMDB\\folderfonts\\impact.ttf");
		Font novaFont = Font.createFont(Font.LAYOUT_LEFT_TO_RIGHT, folder);
		
		
		if(nota >= 9.0) {
			novaFont = novaFont.deriveFont(Font.LAYOUT_NO_LIMIT_CONTEXT, 80);
			graphics.setColor(Color.YELLOW);
			graphics.setFont(novaFont);
			graphics.drawString("ESPETACULAR", 120, newHeight - 100);
		}
		if(nota >= 8.8 && nota < 9.0) {
			novaFont = novaFont.deriveFont(Font.LAYOUT_NO_LIMIT_CONTEXT, 100);
			graphics.setColor(Color.YELLOW);
			graphics.setFont(novaFont);
			graphics.drawString("OTIMO", 195, newHeight - 100);
		}
		if(nota < 8.8) {
			novaFont = novaFont.deriveFont(Font.LAYOUT_NO_LIMIT_CONTEXT, 100);
			graphics.setColor(Color.YELLOW);
			graphics.setFont(novaFont);
			graphics.drawString("MUITO BOM", 145, newHeight - 100);
		}
		
		
			
		
		
		
		
		ImageIO.write(newImage, "png",  new File(nomeArquivo));
		
		
	}
}
