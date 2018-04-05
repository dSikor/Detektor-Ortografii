package pl.windowShowOnScreen;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class BackImagePanel extends JPanel{



	Image bg ;

	public BackImagePanel(String nazwaGrafikiTla) {
		// TODO Auto-generated constructor stub
		
	bg=new ImageIcon(nazwaGrafikiTla).getImage();
		
	}
	
	
	
	@Override
	public void paintComponent(Graphics g) {
	 
	g.drawImage(bg, 0, 0, null);  // Drawing image using drawImage method
	 
	}
	
}
