package pl.okienkaWyswietlane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pl.glowneKlasyAplikacji.UstawieniaGry;
import pl.innePomocneKlasy.Panel_Z_Tlem;


public class Okno_Do_Zgadywania_Has³a extends JFrame {

	
	private static final long serialVersionUID = -8149102182291533971L;
	static int numerHas³a=0;
	private String has³oDoZgadniecia;
	private String odpowiedzGracza;
	private JPanel pole_Z_Literami_Hasla; 
	private JPanel pole_Z_Przyciskami;
	static JButton[] przyciskiFunkcyjne;
	private JTextField[] polaHasla;
	private StanOkna stan;
	
	private UstawieniaGry ust;
	
	
	public enum StanOkna{ Przejdz_dalej,Statyczny;}
		
	
	public Okno_Do_Zgadywania_Has³a(String haslo, UstawieniaGry t) 
	{
	ust=t;
	stan=StanOkna.Statyczny;			
	numerHas³a++;	
	odpowiedzGracza="";
	
	this.has³oDoZgadniecia=haslo;			
	this.setLocationByPlatform(true);
	this.setLocale(new Locale("pl", "PL"));
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setContentPane(new Panel_Z_Tlem("tloOknaZgadywaniaHasla.jpg"));
	
	this.getContentPane().setLayout(new BorderLayout());
	this.setTitle("Has³o nr: "+numerHas³a);
			
	pole_Z_Literami_Hasla=new Panel_Z_Tlem("tloNowe.jpg");
	pole_Z_Literami_Hasla.setLayout(new FlowLayout(FlowLayout.CENTER));
	
	addTextEdit(haslo.length(),pole_Z_Literami_Hasla);	
		
	pole_Z_Przyciskami=new Panel_Z_Tlem("tloNowe.jpg");
	pole_Z_Przyciskami.setLayout(new FlowLayout(FlowLayout.CENTER));
		
	addButton(pole_Z_Przyciskami);	
		
	this.add(pole_Z_Literami_Hasla,BorderLayout.CENTER);
	this.add(pole_Z_Przyciskami,BorderLayout.PAGE_END);
	
	this.pack();
	this.setLocationRelativeTo(null);
		
	}

	public StanOkna getStan() {
		return stan;
	}
	
	
	public void setOdpowiedzGracza(String odpowiedzGracza) {
		this.odpowiedzGracza = odpowiedzGracza;
	}
	public String getOdpowiedzGracza() {
		return odpowiedzGracza;
	}
	
	void addTextEdit(int liczbaPol, JPanel przestrzen)
	{
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		
		char litera;
		String hasloPoPrzerobce=szukaj_Znaki_Wyrazenia_Ortograficzne_I_Zastap_je(has³oDoZgadniecia,ust.getRegulaOrtograficzna_sekfencja());
		polaHasla=new JTextField[hasloPoPrzerobce.length()];
		for(int i=0;i<hasloPoPrzerobce.length();i++)
		{
			litera=hasloPoPrzerobce.charAt(i);
			polaHasla[i]=new JTextField(Character.toString(litera));
			polaHasla[i].setFont(font1);
			polaHasla[i].setHorizontalAlignment(JTextField.CENTER);
			polaHasla[i].setPreferredSize( new Dimension(50,54));
			przestrzen.add(polaHasla[i]);
		}		
	}
				
	void addButton(JPanel przestrzen)
	{
		
		JButton przycisk1=new JButton("Dalej");
			
		przycisk1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				stan=StanOkna.Przejdz_dalej;
				setOdpowiedzGracza(przetworzOdpowiedzGracznaDoSlowa(polaHasla));
				ust.dodajKolejnaOdpowiedzGraczaDoHasel(getOdpowiedzGracza());				
			}
		});
		
				
		przestrzen.add(przycisk1);
			
	}
	
	
	String szukaj_Znaki_Wyrazenia_Ortograficzne_I_Zastap_je(String s³owo,CharSequence regula)
	{
		
		if(regula=="rz/¿")
		{
			s³owo=s³owo.replace("rz"," ");
			s³owo=s³owo.replace("¿"," ");
			
		}
		else if(regula=="ch/h")
		{
			s³owo=s³owo.replace("ch"," ");
			s³owo=s³owo.replace("h"," ");
		}
		else if(regula=="ó/u")
		{
			s³owo=s³owo.replace("ó"," ");
			s³owo=s³owo.replace("u"," ");
		}
		
		return s³owo;
		
	}
	
	

	String przetworzOdpowiedzGracznaDoSlowa(JTextField[] tablicaPol)
	{
		StringBuilder odpowiedzGracza = new StringBuilder();
		for(JTextField pole : tablicaPol)
		{	
			odpowiedzGracza.append(pole.getText());
			
		}

		return (odpowiedzGracza.toString().replaceAll(" ",""));
	}
		
}
