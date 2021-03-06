package pl.klasyW�tkow;

import java.util.TimerTask;

import pl.glowneKlasyAplikacji.UstawieniaGry;
import pl.okienkaWyswietlane.Okno_Do_Zgadywania_Has�a;
import pl.okienkaWyswietlane.Okno_Do_Zgadywania_Has�a.StanOkna;

public class Task_PokazanieOknaZgadywaniaHasla  extends TimerTask {

	private Okno_Do_Zgadywania_Has�a Okno_haslo; 
	private String hasloZgadywane;
	private UstawieniaGry ust_Gry;
	
	
	public Task_PokazanieOknaZgadywaniaHasla(String haslo, UstawieniaGry u) {
		// TODO Auto-generated constructor stub
		Okno_haslo=null;
		hasloZgadywane=haslo;			
		ust_Gry=u;
		
	}
	
	public Okno_Do_Zgadywania_Has�a getOkno_haslo() {
		return Okno_haslo;
	}
	

	@Override
	public void run() {
	
		
		synchronized(this)
		{
			Okno_haslo = new Okno_Do_Zgadywania_Has�a(hasloZgadywane,ust_Gry);
			Okno_haslo.setVisible(true);
										
			while(Okno_haslo.getStan()==StanOkna.Statyczny)
			 {
				 try {
					wait(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 				
			 }
						
		}
		
		Okno_haslo.dispose();
	}
	
}
