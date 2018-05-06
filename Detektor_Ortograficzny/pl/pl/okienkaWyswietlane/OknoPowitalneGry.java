package pl.okienkaWyswietlane;

import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;

import pl.innePomocneKlasy.JPanelWype³nionyGrafika;


/*
Klasa dziedzicz¹ca po JFrame do tworzenia obiektu okna powitalnego gry.  
Wyswietlane na pocz¹tku gry.    
*/

public class OknoPowitalneGry extends JFrame{

	private static final long serialVersionUID = -2266348944736256051L;
	JPanelWype³nionyGrafika jPanelOkna;
	boolean czyAktywneOkno;
	
	/*
	 Konstruktor przyjmujacy 2 parametry: 
	 - nazwa pliku z grafik¹,
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
		
		jPanelOkna = new JPanelWype³nionyGrafika(fileWithGraphics);
		setUndecorated(true);	
		
		
		getContentPane().add(jPanelOkna);
		pack();
		setLocationRelativeTo(null);		
		setVisible(true);
		
	//  Wywo³anie w¹tku uœpienia na okreœlony czas
	//	Okno powitalne pojawia siê i jest wyœwietlane przez okreœlon¹ chwilê
		
		try {
			Thread.sleep(czasWyswietlania*1000);
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		
}
