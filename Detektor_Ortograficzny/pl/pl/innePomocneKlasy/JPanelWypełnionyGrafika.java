package pl.innePomocneKlasy;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/*
 Klasa dziedzicz¹ca po JPanel do tworzenia obiektu wype³nionego grafik¹.  
 Grafika wczytywana jest z pliku.   
*/

public class JPanelWype³nionyGrafika extends JPanel {

	private static final long serialVersionUID = -5960357195329625180L;
	private BufferedImage grafika_bufor;

	// Konstruktor z parametrem nazwaPliku. Nazwa pliku podana z rozszerzeniem (.jpg)   
	
	public JPanelWype³nionyGrafika(String nazwaPliku) {
		
		super();			
		File grafika_Plik = new File(nazwaPliku);
		
		try {
			
			grafika_bufor = ImageIO.read(grafika_Plik);
				
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}
		
		Dimension wymiar_Grafiki = new Dimension(grafika_bufor.getWidth(), grafika_bufor.getHeight());
		setPreferredSize(wymiar_Grafiki);
				
	}
	
	@Override
    protected void paintComponent(Graphics g)
    {
    super.paintComponent(g); 
    
        g.drawImage(grafika_bufor, 0,0,this);
    }
		
}
