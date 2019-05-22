package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.hsqldb.jdbc.JDBCPool;

public class Database {

	private Connection conn;
	
	private DataSource datasource;
	
	public Database() throws SQLException{
		
		if(this.conn == null){
			this.open();
		}
		
		//this.conn.setAutoCommit(false);
	}
	
	public void open() throws SQLException {
		
		this.conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc?user=root&password=root");
		
		// connection pool: recebe uma conexão do pool e pode reutiliza-la varias vezes sem realmente fecha-la,
		// ou passa-la para outro cliente que queira fazer uma transação a devolvendo para o pool.
		
//		JDBCPool pool = new JDBCPool();
//		pool.setUrl("jdbc:mysql://localhost/jdbc");
//		pool.setUser("root");
//		pool.setPassword("root");
//		
//		this.datasource = pool;
//		this.conn = this.datasource.getConnection();

	}
	
	public void close() throws SQLException{
		
		if(this.conn != null){
			this.conn.close();
		}
	}
	
	public Connection getConnection() {
		return this.conn;
	}
	
	public static Database newInstance() throws SQLException{
		return new Database();
	}

}
