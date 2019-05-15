package br.com.alura.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws SQLException  {

		Database db = Database.newInstance();	
		
		ResultSet result = db.query("SELECT * FROM Produto");
		
		while(result.next()){
			
			System.out.println(result.getInt("id"));
			System.out.println(result.getString("Nome"));
		}
		
		result.close();
		
		db.close();
	}
}
