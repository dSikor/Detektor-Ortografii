package pl.okienkaWyswietlane;

import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;

import pl.innePomocneKlasy.WyswietlanaGrafika;


public class OknoPowitalneGry extends JFrame{

	private static final long serialVersionUID = -2266348944736256051L;
	Image tlo;
	WyswietlanaGrafika TloFrame;
	boolean czyAktywneOkno;
	
	
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
	
		TloFrame = new WyswietlanaGrafika(fileWithGraphics);
		setUndecorated(true);		
		getContentPane().add(TloFrame);
		pack();
		setLocationRelativeTo(null);		
		setVisible(true);
		
		
		try {
			Thread.sleep(czasWyswietlania*1000);
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//dispose();
		
		
	}
		
}
