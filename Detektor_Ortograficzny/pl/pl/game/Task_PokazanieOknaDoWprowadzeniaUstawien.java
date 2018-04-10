package pl.game;

import java.util.TimerTask;

import pl.okienkaWyswietlane.OknoDoUstawienGry;

public class Task_PokazanieOknaDoWprowadzeniaUstawien extends TimerTask{

	OknoDoUstawienGry oknoUstawienGry;
	UstawieniaGry ustawieniaGry;

	public Task_PokazanieOknaDoWprowadzeniaUstawien(UstawieniaGry t) {
		// TODO Auto-generated constructor stub
		ustawieniaGry=t;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(this)
		{
		
		 oknoUstawienGry = new OknoDoUstawienGry(ustawieniaGry);
		 
		 while(oknoUstawienGry.isEverythingSet()==false)
		 {
			 try {
				wait(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 }
		 		 
		}
		 oknoUstawienGry.dispose();
	}	
}
