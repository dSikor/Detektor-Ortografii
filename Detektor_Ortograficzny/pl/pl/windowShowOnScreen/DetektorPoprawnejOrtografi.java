package pl.windowShowOnScreen;


import java.util.List;
import pl.game.GameSetting;
import pl.game.Task_PokazanieOknaDoWprowadzeniaUstawien;
import pl.game.Task_PokazanieOknaZgadywaniaHasla;
import pl.game.Task_WyswietlenieWyniku;

public class DetektorPoprawnejOrtografi {

		
	public static void main(String[] args) {

		
		//**********************************************
		//**** Wyœwietlenie grafiki pocz¹tkowej ********
		
		OknoPowitalneGry OknoWitam = new OknoPowitalneGry("grafika_witam.jpg",3);
		OknoWitam.dispose();
		
		//**********************************************
		//**********************************************
		
		//***  Wprowardzenie ustawieñ poczatkowych  ***//
		
		GameSetting UstawieniaGry = new GameSetting("",0,"a");
		Task_PokazanieOknaDoWprowadzeniaUstawien n = new Task_PokazanieOknaDoWprowadzeniaUstawien(UstawieniaGry);
		n.run();
		
		//*********************************************//		
		//***  Wylosowanie hase³  ***//
		
		UstawieniaGry.pobierzIwylosujHaslaDoGry("Has³a Ortograficzne_1.txt",UstawieniaGry.getRegulaOrtograficzna_sekfencja());		
		List<String> hasla = UstawieniaGry.getPasswordToGuess();
		
		//***************************//
		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		//****  Test ortografii  ****//
		
		Task_PokazanieOknaZgadywaniaHasla[] oknaNaHasla = new Task_PokazanieOknaZgadywaniaHasla[hasla.size()];
		
		for(int i=0;i<hasla.size();i++)
		{			
				
			oknaNaHasla[i]= new Task_PokazanieOknaZgadywaniaHasla(hasla.get(i),UstawieniaGry);
			oknaNaHasla[i].run();
			
		}
		
		//***************************** 
		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		
		//*****************************
		//**** Wyœwietlenie wyniku ****
		
		int liczbaPunktow=UstawieniaGry.sprawdzLiczbePoprawnychOdpowiedzi();	
		Task_WyswietlenieWyniku oknoKoncowe = new Task_WyswietlenieWyniku(UstawieniaGry.getNumberOfPassword(),liczbaPunktow);
		oknoKoncowe.run();
				
		//*****************************
		//*****************************
		
		
}
}
