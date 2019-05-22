package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractModel {

	private static Database db;
	
	public AbstractModel() {

		if(AbstractModel.db == null) {
			
			try {
				AbstractModel.db = Database.newInstance();
			}
			catch(SQLException e){
				System.out.println(e.getMessage());
			}
		}
	}
	
	public Connection getConnection() {
		return AbstractModel.db.getConnection();
	}
	
	protected Integer insert(String table, HashMap<String, String> binds) throws SQLException{
		
		String keys = "";
		String vals = "";
		Integer id = null;

		for(Map.Entry<String, String> entry : binds.entrySet()){
			
			keys += String.format("`%s`,", entry.getKey());
			vals += String.format("'%s',", entry.getValue());
		}
		
		keys = keys.substring(0, keys.length() - 1);
		vals = vals.substring(0, vals.length() - 1);
		
		String sql = String.format("INSERT INTO Produto(%s) values(%s)", keys, vals);
		System.out.println(sql);
		Statement stmt = this.getConnection().createStatement();
		stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
	
		ResultSet result = stmt.getGeneratedKeys();
	
		if(result.next()){
		
			id = result.getInt(1);
		}
		
		result.close();
	
		return id;
	}
	
	protected Integer update(String table, String column, Integer id, HashMap<String, String> binds) throws SQLException{

		String vals = "";

		for(Map.Entry<String, String> entry : binds.entrySet()){
			vals += String.format("`%s` = '%s',", entry.getKey(), entry.getValue());
		}
		
		vals = vals.substring(0, vals.length() - 1);
		
		String sql = String.format("UPDATE `%s` SET %s WHERE `%s` = '%s'",
			table,
			vals,
			column,
			id
		);
		
		Statement stmt = this.getConnection().createStatement();
		stmt.execute(sql);
		
		return stmt.getUpdateCount();
	}
	
	protected Integer delete(String table, String column, Integer id) throws SQLException{
		
		String sql = String.format("DELETE FROM `%s` WHERE `%s` = '%s'", table, column, id);
		
		Statement stmt = this.getConnection().createStatement();

		stmt.execute(sql);

		return stmt.getUpdateCount();
	}
	
	protected ResultSet select(String table, String column, int id) throws SQLException{
		
		String sql = String.format("SELECT * FROM `%s` WHERE `%s` = '%s' LIMIT 1", table, column, id);
		
		Statement stmt = this.getConnection().createStatement();
		stmt.execute(sql);
	
		ResultSet result = stmt.getResultSet();
	
		//if(result.next()){
		
			
			//id = result.getInt(1);
		//}
		
		//result.close();
		
		return result;

	}
}