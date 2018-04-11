package it.polito.tdp.anagrammi.model;

import it.polito.tdp.anagrammi.DAO.DizionarioDAO;

public class TestModel {

	public static void main(String[] args) {
		
		//DizionarioDAO d = new DizionarioDAO(); 
		//d.getParole();
		Model m = new Model();
		m.findSoluzione("oro");

	}

}
