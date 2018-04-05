package pl.game;

import java.util.TimerTask;

import pl.game.Okno_Do_Zgadywania_Has³a.StanOkna;

public class Task_PokazanieOknaZgadywaniaHasla  extends TimerTask {

	private Okno_Do_Zgadywania_Has³a Okno_haslo; 
	private String hasloZgadywane;
	private GameSetting ust_Gry;
	
	
	public Task_PokazanieOknaZgadywaniaHasla(String haslo, GameSetting u) {
		// TODO Auto-generated constructor stub
		Okno_haslo=null;
		hasloZgadywane=haslo;			
		ust_Gry=u;
		
	}
	
	public Okno_Do_Zgadywania_Has³a getOkno_haslo() {
		return Okno_haslo;
	}
	

	@Override
	public void run() {
	
		
		synchronized(this)
		{
			Okno_haslo = new Okno_Do_Zgadywania_Has³a(hasloZgadywane,ust_Gry);
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
