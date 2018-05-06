package pl.okienkaWyswietlane;

import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;

import pl.innePomocneKlasy.JPanelWype�nionyGrafika;


/*
Klasa dziedzicz�ca po JFrame do tworzenia obiektu okna powitalnego gry.  
Wyswietlane na pocz�tku gry.    
*/

public class OknoPowitalneGry extends JFrame{

	private static final long serialVersionUID = -2266348944736256051L;
	JPanelWype�nionyGrafika jPanelOkna;
	boolean czyAktywneOkno;
	
	/*
	 Konstruktor przyjmujacy 2 parametry: 
	 - nazwa pliku z grafik�,
	 - czas wyswietlania okna powitalnego,
	*/
	
	
	public OknoPowitalneGry(String fileWithGraphics ,int czasWyswietlania) {
	
		
		setTitle("Witam");
		setBounds(100, 100, 194, 158);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 261, Short.MAX_VALUE)
		);
		
		jPanelOkna = new JPanelWype�nionyGrafika(fileWithGraphics);
		setUndecorated(true);	
		
		
		getContentPane().add(jPanelOkna);
		pack();
		setLocationRelativeTo(null);		
		setVisible(true);
		
	//  Wywo�anie w�tku u�pienia na okre�lony czas
	//	Okno powitalne pojawia si� i jest wy�wietlane przez okre�lon� chwil�
		
		try {
			Thread.sleep(czasWyswietlania*1000);
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		
}
