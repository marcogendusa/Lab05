package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class DizionarioDAO {
		
	
	public List<String> getParole() {

		final String sql = "SELECT * FROM parola";

		ArrayList<String> dizionario = new ArrayList<String>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				String parola = rs.getString("nome");
				
				//System.out.println(parola);

				dizionario.add(parola);
			}
			
			conn.close();

			return dizionario;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	

}
