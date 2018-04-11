package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.DizionarioDAO;

public class Model {
	
	List<String> soluzione;
	
	DizionarioDAO dizionarioDAO = new DizionarioDAO();
	private List<String> dizionario = this.dizionarioDAO.getParole();
	
	String parziale = "";

	public List<String> findSoluzione(String inserita) {

		soluzione = new ArrayList<String>();

		String daTogliere = inserita;
		recursive(0, inserita, parziale, daTogliere);

		return soluzione;
	}

	private void recursive(int livello, String inserita, String parziale, String daTogliere) {
				
		if (parziale.length() == inserita.length() && !this.soluzione.contains(parziale)) {
			soluzione.add(parziale);
			System.out.println(parziale);
			}
		
		for (int i=0; i<daTogliere.length(); i++) {
			StringBuilder sb = new StringBuilder(daTogliere);
			sb.deleteCharAt(i);
			recursive(livello+1, inserita, parziale+daTogliere.charAt(i), sb.toString());
			
		}	
	}
	
	public List<String> getAnagrammiCorretti() {
		LinkedList<String> l = new LinkedList<String>();
		for(String s: this.soluzione) {
			if(this.dizionario.contains(s))
				l.add(s);
		}
		return l;
	}
	
	public List<String> getAnagrammiErrati() {
		LinkedList<String> l = new LinkedList<String>();
		for(String s: this.soluzione) {
			if(!this.dizionario.contains(s))
				l.add(s);
		}
		return l;
	}
	

}
