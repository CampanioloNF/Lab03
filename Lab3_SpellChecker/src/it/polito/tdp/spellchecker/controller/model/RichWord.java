package it.polito.tdp.spellchecker.controller.model;

public class RichWord {

	/* questa è una classe BEAN (contenitore)*/
	private String parola;
	private boolean isOk;
	
	
	public RichWord(String parola, boolean isOk) {
		super();
		this.parola = parola;
		this.isOk=isOk;
		
	}


	public String getParola() {
		return parola;
	}


	public boolean isOk() {
		return isOk;
	}
	

	
}
