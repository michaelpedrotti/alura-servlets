package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private Connection conn;
	
	public void open() throws SQLException {
		
		//this.conn = DriverManager.getConnection("");
		
		this.conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc?user=root&password=root");
	}
	
	public void close() throws SQLException{
		
		if(this.conn != null){
			this.conn.close();
		}
	}
	
	public ResultSet query(String sql) throws SQLException {
		
		if(this.conn == null){
			this.open();
		}
		
		Statement stmt = this.conn.createStatement();
		stmt.execute(sql);
		
		return stmt.getResultSet();
	}
	
	public static Database newInstance(){
		return new Database();
	}
}
