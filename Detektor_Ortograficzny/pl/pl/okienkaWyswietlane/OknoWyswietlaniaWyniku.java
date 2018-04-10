package pl.okienkaWyswietlane;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class OknoWyswietlaniaWyniku extends JFrame {

	
	private static final long serialVersionUID = -4238255780005705840L;
	private int iloscPoprawnychOdpowiedzi;
	private int iloscBlednychOdpowiedzi;
	private int liczbaOdpowiedzi;
	private BufferedImage obrazGrafiki;
	
	private JPanel pole1;
	private JPanel pole2;
	
	
	public OknoWyswietlaniaWyniku(int licz_Odpowiedzi, int licz_ZdobytychPunktow)
	{
		this.liczbaOdpowiedzi=licz_Odpowiedzi;
		this.iloscPoprawnychOdpowiedzi=licz_ZdobytychPunktow;
		this.iloscBlednychOdpowiedzi=liczbaOdpowiedzi-iloscPoprawnychOdpowiedzi;
		
		this.setLocationByPlatform(true);
		this.setLocale(new Locale("pl", "PL"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//this.setContentPane(new Panel_Z_Tlem("tlo.jpg"));
		this.setContentPane(new Panel_Z_Tlem("tloOknaUstawienGry_Wyniku.jpg"));
		this.getContentPane().setLayout(new FlowLayout());
		this.setTitle("Wynik Gry");
		//this.getContentPane().setBackground(new Color(44,255,127));
		
		Border loweredbevel=BorderFactory.createLoweredSoftBevelBorder();
		Border blueline = BorderFactory.createLineBorder(Color.blue);
		Border compound= BorderFactory.createCompoundBorder(blueline, loweredbevel);
		
		pole1=new JPanel(new GridLayout(3,2,15,15));
		//pole1.setBackground(Color.);
		pole1.setBorder(compound);
		
		JLabel tekst1=new JLabel("Poprawne odpowiedzi:");
		JLabel tekst2=new JLabel("B³êdne odpowiedzi:");
		JLabel tekst3=new JLabel("Liczba odpowiedzi:");
	
		
		JLabel poleTekst1 = new JLabel(Integer.toString(iloscPoprawnychOdpowiedzi));
		JLabel poleTekst2 = new JLabel(Integer.toString(iloscBlednychOdpowiedzi));
		JLabel poleTekst3 = new JLabel(Double.toString(liczbaOdpowiedzi));
	
		
		pole1.add(tekst1);
		pole1.add(poleTekst1);
		
		pole1.add(tekst2);
		pole1.add(poleTekst2);
		
		pole1.add(tekst3);
		pole1.add(poleTekst3);
		
			
		pole2=new JPanel(new GridLayout());
		pole2.setBackground(Color.WHITE);
		
		if(licz_ZdobytychPunktow==licz_Odpowiedzi)
		{
			dodajGrafikê("szczesliwyGracz.jpg",obrazGrafiki,pole2);
			
		}else
		{
			dodajGrafikê("smutnyGracz.jpg",obrazGrafiki,pole2);
		}
		
		
		this.add(pole1);
		this.add(pole2);
		
		this.pack();
		this.setLocationRelativeTo(null);
		
	}
	
	public void dodajGrafikê(String nazwaGrafiki,BufferedImage img , JPanel p)
	{
		File imageFile = new File(nazwaGrafiki);
		try {
			img = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}
			
		JLabel picLabel = new JLabel(new ImageIcon(img));
		
		p.add(picLabel);
		p.repaint();
					
	}
	
}
