package pl.innePomocneKlasy;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel_Z_Tlem extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	Image bg ;

	public Panel_Z_Tlem(String nazwaGrafikiTla) {
		// TODO Auto-generated constructor stub
		
	bg=new ImageIcon(nazwaGrafikiTla).getImage();
		
	}
	
	
	
	@Override
	public void paintComponent(Graphics g) {
	 
	g.drawImage(bg, 0, 0, null);  // Drawing image using drawImage method
	 
	}
	
}
