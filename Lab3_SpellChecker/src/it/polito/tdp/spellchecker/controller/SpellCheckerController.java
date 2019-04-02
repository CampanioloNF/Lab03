package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.controller.model.Dictionary;
import it.polito.tdp.spellchecker.controller.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class SpellCheckerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuButton btnLanguage;

    @FXML
    private TextArea txtResult;

    @FXML
    private TextArea txtInput;
    
    @FXML
    private MenuItem btnItalian;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private Text txtError;

    @FXML
    private Button btnClear;

    @FXML
    private Text txtTime;

	private Dictionary model;

    @FXML
    void doClearText(ActionEvent event) {

    	this.txtInput.clear();
    	this.txtResult.clear();
    	
    }

    @FXML
    void doSpellCheck(ActionEvent event) {

    	long time = System.currentTimeMillis();
    	
    	String input = this.txtInput.getText().toLowerCase();
    	    	
        String inClean =  input.replaceAll("[.,\\\\/#!?$%\\\\^&\\\\*;:{}=\\\\-_`~()\\\\[\\\\]\\\"]", "");
    	
        
 
        this.model.loadDictionary(this.btnLanguage.getText());
        
      
        //mando una lista di String che corrisponde alle parole caricate
        List <String> parole = new ArrayList <String>();
        
        String [] arr = inClean.split(" ");
        
        for(String s : arr) {
        	
        	parole.add(s);
        }
        
        //la controllo  e ricevo le parole errate
        List <RichWord> output = this.model.spellCheckText(parole);
        
        List <String> wrongs = new ArrayList <String>();

           for(RichWord rw : output) {
        	   if(!rw.isOk())
        		   wrongs.add(rw.getParola());
           }
          
        for (String s : wrongs) {
        	this.txtResult.appendText(s+"\n");
        }
        
        long ora = (System.currentTimeMillis()-time)/1000;
        
        this.txtError.setText("The text contains "+wrongs.size()+" errors");
        this.txtTime.setText("Spell check completed in "+ora+" seconds" );
        
        this.model.clear();
        
    }
    
    

    @FXML
    void setItaliano(ActionEvent event) {
    	
    	String primo = this.btnLanguage.getText();
    	String secondo = this.btnItalian.getText();
    	
    	this.btnLanguage.setText(secondo);
    	this.btnItalian.setText(primo);

    }

    @FXML
    void initialize() {
        assert btnLanguage != null : "fx:id=\"btnLanguage\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnItalian != null : "fx:id=\"btnItalian\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtError != null : "fx:id=\"txtError\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'SpellChecker.fxml'.";

    }


	public void setModel(Dictionary model) {
		this.model=model;
		
	}
}
