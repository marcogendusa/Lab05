package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWord;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea AnagrammiErrati;

    @FXML
    private Button btnReset;

    @FXML
    void handleAnagrammi(ActionEvent event) {
    		String parola = txtWord.getText();
    		model.findSoluzione(parola);
    		
    		for(String s: model.getAnagrammiCorretti())
    			txtAnagrammiCorretti.appendText(s+"\n");
    		
    		for(String s: model.getAnagrammiErrati())
    			AnagrammiErrati.appendText(s+"\n");
    }

    @FXML
    void handleReset(ActionEvent event) {
    		txtWord.clear();
    		txtAnagrammiCorretti.clear();
    		AnagrammiErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert AnagrammiErrati != null : "fx:id=\"AnagrammiErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
    
    public void setModel(Model model) {
  		this.model = model;
  	}
}
