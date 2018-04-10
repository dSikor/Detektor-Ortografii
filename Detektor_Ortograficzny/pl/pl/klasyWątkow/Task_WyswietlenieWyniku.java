package pl.klasyW¹tkow;

import java.util.TimerTask;

import pl.okienkaWyswietlane.OknoWyswietlaniaWyniku;

public class Task_WyswietlenieWyniku extends TimerTask {

	OknoWyswietlaniaWyniku window_wynik;
	int liczbaHasel;
	int liczbaZdobytychPunktow;
	
	public Task_WyswietlenieWyniku(int licz_h,int licz_p) {
		liczbaHasel=licz_h;
		liczbaZdobytychPunktow=licz_p;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		OknoWyswietlaniaWyniku ok = new OknoWyswietlaniaWyniku(liczbaHasel,liczbaZdobytychPunktow);
		ok.setVisible(true);
	
	}
	
	
}
