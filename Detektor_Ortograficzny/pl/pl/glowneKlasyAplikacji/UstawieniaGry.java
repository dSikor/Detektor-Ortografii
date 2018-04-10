package pl.glowneKlasyAplikacji;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class UstawieniaGry {

private String imieGracza;
private int liczbaHaselZgadywanych;
private List<String> haslaDoZgadniecia;
private CharSequence regulaOrtograficzna_sekfencja;
private List<String> odpowiedziGracza;

private boolean stanGry;
	
public UstawieniaGry(String name, int number, CharSequence regula) {

	imieGracza = name;
	liczbaHaselZgadywanych=number;
	regulaOrtograficzna_sekfencja=regula;
	haslaDoZgadniecia=new ArrayList<String>();
	odpowiedziGracza=new ArrayList<String>();
	stanGry=true;
	
}	


public void setRegulaOrtograficzna_sekfencja(CharSequence regulaOrtograficzna_sekfencja) {
	this.regulaOrtograficzna_sekfencja = regulaOrtograficzna_sekfencja;
}


public CharSequence getRegulaOrtograficzna_sekfencja() {
	return regulaOrtograficzna_sekfencja;
}


public void setStanGry(boolean stanGry) {
	this.stanGry = stanGry;
}
public boolean isStanGry() {
	return stanGry;
}



public String getNameOfPlayer() {
	return imieGracza;
}

public int getNumberOfPassword() {
	return liczbaHaselZgadywanych;
}

public void setNameOfPlayer(String nameOfPlayer) {
	this.imieGracza = nameOfPlayer;
}

public void setNumberOfPassword(int numberOfPassword) {
	this.liczbaHaselZgadywanych = numberOfPassword;
}

public void dodajKolejneHasloDoZgadywania(String password) {
	
	this.haslaDoZgadniecia.add(password);
	
}
public List<String> getPasswordToGuess() {
	return haslaDoZgadniecia;
}

public void dodajKolejnaOdpowiedzGraczaDoHasel(String password) {
	
	this.odpowiedziGracza.add(password);
	
}

public List<String> getOdpowiedziGracza() {
	return odpowiedziGracza;
}


public int sprawdzLiczbePoprawnychOdpowiedzi()
{
	int liczbaPunktow=0;
	boolean czyPoprawnaOdpowiedz;
	for(int i=0;i<getNumberOfPassword();i++)
	{
		czyPoprawnaOdpowiedz=haslaDoZgadniecia.get(i).equals(odpowiedziGracza.get(i));
		if(czyPoprawnaOdpowiedz)
		{
			liczbaPunktow++;
		}
	}
	
	
	return liczbaPunktow;
}

public LinkedList<Integer> losujNumerHasla(int zakres)
{

	LinkedList<Integer> wylosowaneNumeryHase³ = new LinkedList<>();
	Random generator = new Random();
	

	for(int i=0; i<liczbaHaselZgadywanych; i++) {
		
		int wylosowanaLiczba;
		wylosowanaLiczba=generator.nextInt(zakres);
		
		boolean czyMamyInnaLiczbe;
		do{
			
			
			wylosowanaLiczba=generator.nextInt(zakres);
			czyMamyInnaLiczbe=sprawdzCzyNumerHaslaSiêPowtórzy³(wylosowanaLiczba, wylosowaneNumeryHase³);			
			
		}while(czyMamyInnaLiczbe);
		
		wylosowaneNumeryHase³.add(wylosowanaLiczba);
		 		 
	}
	return wylosowaneNumeryHase³;
	
}


public void pobierzIwylosujHaslaDoGry(String nazwaPliku, CharSequence regula)
{
	LinkedList<Integer> numery = new LinkedList<>();
	List<String> pobraneHasla = new ArrayList<String>();		
	File Plik_odpowiedzi = new File(nazwaPliku);	
	
	try (BufferedReader br = new BufferedReader(new FileReader(Plik_odpowiedzi))) 
	{
	  
		String line;
		int liczbaHasel=0;
		
		CharSequence ort_znak1 = null,ort_znak2 = null;
		
		if(regula=="rz/¿")
		{
			ort_znak1="rz";
			ort_znak2="¿";
			
		}
		else if(regula=="ch/h")
		{
			ort_znak1="ch";
			ort_znak2="h";
		}
		else if(regula=="ó/u")
		{
			ort_znak1="ó";
			ort_znak2="u";
		}
		
		
	    while ((line=br.readLine()) != null) {
	    	 
	    	if(line.contains(ort_znak1)||line.contains(ort_znak2))
	    	{
	    		liczbaHasel++;
		    	pobraneHasla.add(line);
	    	}
	    	
	    }
	    
	    numery=losujNumerHasla(liczbaHasel);
	       
	    for(int i=0;i<numery.size();i++)
	    {
	    	int id_hasla=numery.get(i);
	    	haslaDoZgadniecia.add(pobraneHasla.get(id_hasla));	    	
	    }
	    		    
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
				
}


boolean sprawdzCzyNumerHaslaSiêPowtórzy³(int liczbaWylosowana, LinkedList<Integer> numeryHase³)
{
	
	if(numeryHase³.isEmpty())
	{
		return false;
	}
	else
	{
		for(int numery : numeryHase³)
		{
			if(numery==liczbaWylosowana)
			{
				return true;
			}
		}
	}
	return false;
}




}
