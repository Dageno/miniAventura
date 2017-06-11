package miniAventura.frontEnd.gui;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.border.Border;

public class PanelImage implements Border {
	BufferedImage backImage = null;

	public PanelImage(BufferedImage bImage) {
		backImage = bImage;
	}

	public void paintComponent(Graphics g) {
		
		
	}

	@Override
	public Insets getBorderInsets(Component arg0) {
		// TODO Auto-generated method stub
		return new Insets(0, 0, 0, 0);
	}

	@Override
	public boolean isBorderOpaque() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void paintBorder(Component arg0, Graphics g, int arg2, int arg3, int width, int heigth) {
		
		if(backImage!= null){
			g.drawImage(backImage, 0, 0, width, heigth, null);
		}
		
	}
}
