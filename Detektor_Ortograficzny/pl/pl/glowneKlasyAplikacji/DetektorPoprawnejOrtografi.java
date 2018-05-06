package pl.glowneKlasyAplikacji;


import java.util.List;

import pl.klasyW�tkow.Task_PokazanieOknaDoWprowadzeniaUstawien;
import pl.klasyW�tkow.Task_PokazanieOknaZgadywaniaHasla;
import pl.klasyW�tkow.Task_WyswietlenieWyniku;
import pl.okienkaWyswietlane.OknoDoUstawienGry;
import pl.okienkaWyswietlane.OknoPowitalneGry;

public class DetektorPoprawnejOrtografi {

		
	public static void main(String[] args) {

		
		//**********************************************
		//**** Wy�wietlenie grafiki pocz�tkowej ********
		
		OknoPowitalneGry OknoWitam = new OknoPowitalneGry("grafika_witam.jpg",3);
		OknoWitam.dispose();
		
		//**********************************************
		//**********************************************
		
		//***  Wprowardzenie ustawie� poczatkowych  ***//
		
		UstawieniaGry UstawieniaGry = new UstawieniaGry("",0,"a");
		Task_PokazanieOknaDoWprowadzeniaUstawien n = new Task_PokazanieOknaDoWprowadzeniaUstawien(UstawieniaGry);
		n.run();
		
		//*********************************************//		
		//***  Wylosowanie hase�  ***//
		
		UstawieniaGry.pobierzIwylosujHaslaDoGry("Has�a Ortograficzne_1.txt",UstawieniaGry.getRegulaOrtograficzna_sekfencja());		
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
		//**** Wy�wietlenie wyniku ****
		
		int liczbaPunktow=UstawieniaGry.sprawdzLiczbePoprawnychOdpowiedzi();	
		Task_WyswietlenieWyniku oknoKoncowe = new Task_WyswietlenieWyniku(UstawieniaGry.getNumberOfPassword(),liczbaPunktow);
		oknoKoncowe.run();
				
		//*****************************
		//*****************************
		
		
}
}
