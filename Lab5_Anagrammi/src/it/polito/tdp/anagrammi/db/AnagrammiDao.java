package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammiDao {
	
	public boolean isCorrect(String anagramma){
	 String sql="select id, nome from parola where nome =?";
	 Connection conn;
	 try {
		conn = DBConnect.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, anagramma);
		ResultSet rs = st.executeQuery();
		if(rs.next()){
		 return true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	 return false;
	 }

}
