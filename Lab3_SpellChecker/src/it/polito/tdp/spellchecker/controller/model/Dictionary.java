package it.polito.tdp.spellchecker.controller.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dictionary {
	
	/*questo è il model vero e proprio*/
	
	
	/*
	 * La prima soluzione prevede che ogni volta che l'utente preme il pulsante 
	 * di spell checker venga letto il file contenete il dizionario.
	 * 
	 * Una possibile, e forse migliore alternativa, consiste nel caricare il file,
	 * sotto forma di set, all'interno di due set dizionario (inglese e italiano)
	 * direttamente all'avvio del programma.
	 * In quel caso il pulsante spell checker chiamerà nel model un metodo che 
	 * lavora esclusimente con dati già presenti.
	 * 
	 */
	
	private Set <String> dizionario;
	private Set <String> dictionary;
	
 	public Dictionary() {
		this.dizionario = new HashSet<String>();
		this.dictionary = new HashSet<String>();
	}

 	/**
 	 * tale metodo si occupa di caricare
 	 * i dizionari (italiano ed inglese) all'interno di Set nel model
 	 */
 	
	public void loadDictionary() {
	
		
		try {
		
			FileReader fr = new FileReader( "rsc/English.txt" );
		    BufferedReader br = new BufferedReader(fr);
	     	String word ;
	    	while (( word = br .readLine()) != null ) {
		// Aggiungere parola alla struttura dati
	    		
	    		this.dictionary.add(word);
	    		
		}
		br .close();
		} catch (IOException e ){
		System. out .println( "Errore nella lettura del file" );
		}
				
			
	    try {
			
			FileReader fr = new FileReader( "rsc/Italian.txt" );
		    BufferedReader br = new BufferedReader(fr);
	     	String word ;
	    	while (( word = br .readLine()) != null ) {
			// Aggiungere parola alla struttura dati
		    		
		    		this.dizionario.add(word);
		    		
			}
			br .close();
			} catch (IOException e ){
			System. out .println( "Errore nella lettura del file" );
			}
			
		}
		
	/**
	 * Riceve una Lista di String che corrisponde alla lista di parole
	 * e la lingua di tali parole e restituisce una Lista di RichWord dove
	 * viene marcato se tali paroli siano o meno correte
	 * @param inputTextList
	 * @param lingua
	 * @return Lista di RichWord dove
	 * viene marcato (attraverso un valore boolean) se tali paroli siano o meno correte
	 */
	
	public List<RichWord> spellCheckText(List<String> inputTextList, String lingua ){
		
		
		List<RichWord> output = new ArrayList <RichWord>();
		
		if(lingua.equals("Italiano")) {
			
	 	for(String s : inputTextList) {
		  if(this.dizionario.contains(s)) {
			  RichWord rw = new RichWord(s,true);
			  output.add(rw);
		  }
		  else {
			  RichWord rw = new RichWord(s,false);
		      output.add(rw);
		  }
			  
		}
	}
		else {
		
			for(String s : inputTextList) {
				  if(this.dictionary.contains(s)) {
					  RichWord rw = new RichWord(s,true);
					  output.add(rw);
				  }
				  else {
					  RichWord rw = new RichWord(s,false);
				      output.add(rw);
				  }
					  
				}
			}
		
		return output;
	}

	
	
 
}	

