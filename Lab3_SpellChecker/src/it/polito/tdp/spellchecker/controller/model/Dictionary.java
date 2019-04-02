package it.polito.tdp.spellchecker.controller.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dictionary {
	
	private Set <String> dizionario;
	
	
	public Dictionary() {
		this.dizionario = new HashSet<String>();
		
	}

	public void loadDictionary(String language) {
		
		if(language.equals("English")) {
		
		try {
		
			FileReader fr = new FileReader( "rsc/English.txt" );
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
		
		else if(language.equals("Italiano")) {
			
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
		
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList ){
		
		List<RichWord> output = new ArrayList <RichWord>();
		
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
		
		return output;
	}

	public void clear() {
		this.dizionario.clear();
		
	}
	
 
}	

