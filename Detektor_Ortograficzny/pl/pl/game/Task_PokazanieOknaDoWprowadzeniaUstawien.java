package pl.game;

import java.util.TimerTask;

import pl.windowShowOnScreen.FrameToSettingGame;

public class Task_PokazanieOknaDoWprowadzeniaUstawien extends TimerTask{

	FrameToSettingGame oknoUstawienGry;
	GameSetting ustawieniaGry;

	public Task_PokazanieOknaDoWprowadzeniaUstawien(GameSetting t) {
		// TODO Auto-generated constructor stub
		ustawieniaGry=t;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(this)
		{
		
		 oknoUstawienGry = new FrameToSettingGame(ustawieniaGry);
		 
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
