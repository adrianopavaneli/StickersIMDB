package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Figurinhas {

	
	public void cria(InputStream impuStream, String nomeArquivo) throws Exception{
		BufferedImage imagemOriginal = ImageIO.read(impuStream);
		
		int width = imagemOriginal.getWidth();
		int height = imagemOriginal.getHeight();
		int newHeight = height + 200;
		BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
		
		Graphics2D graphics = (Graphics2D) newImage.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
		
		Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 80);
		graphics.setColor(Color.YELLOW);
		graphics.setFont(fonte);
		
		
		graphics.drawString("TOPZERA", 140, newHeight - 100);
		
		ImageIO.write(newImage, "png",  new File(nomeArquivo));
		
		
	}
}